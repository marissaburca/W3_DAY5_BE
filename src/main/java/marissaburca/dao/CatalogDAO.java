package marissaburca.dao;
import marissaburca.entities.Book;
import marissaburca.entities.Catalog;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class CatalogDAO {

    private final EntityManager em; //permette interazione con database

    public CatalogDAO ( EntityManager em ) {
        this.em = em;
    }

    //*************************** SAVE ****************************
    public void save( Catalog element ){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(element);
        transaction.commit();
        System.out.println( "Element " + element.getTitle() + " successfully added to Catalog");
    }

    //*********************** FIND BY ISBN ************************
    public Catalog findByCode( UUID uuid) {
        return em.find(Catalog.class, uuid);
    }

    //*************************** DELETE **************************
    public void findByCodeAndDelete(UUID uuid){
        Catalog found = this.findByCode(uuid);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println( "Element" + found.getTitle() + " successfully deleted from Catalog");
        }else {
            System.out.println( "Element not found");
        }
    }
    //*********************** FIND BY YEAR ************************
    public List<Catalog> getElementsByPublicationYear(int publicationYear){
        TypedQuery<Catalog> getElements = em.createNamedQuery("findByYear",Catalog.class);
        getElements.setParameter("publicationYear", publicationYear);
        return getElements.getResultList();
    }
    //********************** FIND BY AUTHOR ***********************
    public List<Book> getElementsByAuthor(String author){
        TypedQuery<Book> getElements = em.createNamedQuery("findByAuthor", Book.class);
        getElements.setParameter("authorName", author);
        return getElements.getResultList();
    }
    //********************** FIND BY TITLE ***********************
    public List<Catalog> getElementsByTitle(String partialTitle) {
        TypedQuery<Catalog> getElements = em.createNamedQuery("findByTitle", Catalog.class);
        getElements.setParameter("partialTitle", "%" + partialTitle + "%");
        return getElements.getResultList();
    }
}
