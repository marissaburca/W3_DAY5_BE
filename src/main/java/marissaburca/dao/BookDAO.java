package marissaburca.dao;

import marissaburca.entities.Book;
import marissaburca.entities.Catalog;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class BookDAO {
    private final EntityManager em; //permette interazione con database

    public BookDAO ( EntityManager em ) {
        this.em = em;
    }

    //*************************** SAVE ****************************
    public void save( Book book ){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(book);
        transaction.commit();
        System.out.println( "Book '" + book.getTitle() + "' successfully added to Archive");
    }

    //*********************** FIND BY ID **************************
    public Book findByCode( UUID uuid) {
        return em.find(Book.class, uuid);
    }

    //*************************** DELETE **************************
    public void findByCodeAndDelete(UUID uuid){
        Book found = this.findByCode(uuid);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println( "Book " + found.getTitle() + "' successfully deleted from Catalog");
        }else {
            System.out.println( "Book not found");
        }
    }
}
