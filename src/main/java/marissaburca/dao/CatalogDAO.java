package marissaburca.dao;
import marissaburca.entities.Catalog;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class CatalogDAO {

    private final EntityManager em; //permette interazione con database

    public CatalogDAO ( EntityManager em ) {
        this.em = em;
    }

    //****************** SAVE *****************
    public void save( Catalog element ){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(element);
        transaction.commit();
        System.out.println( "Element " + element.getTitle() + " successfully added to Catalog");
    }

    //****************** FIND BY ID *****************
    public Catalog findByCode( UUID id) {
        return em.find(Catalog.class, id);
    }

    //****************** DELETE *****************
    public void findByCodeAndDelete(UUID id){
        Catalog found = this.findByCode(id);
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
}
