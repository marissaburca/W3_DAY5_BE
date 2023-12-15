package marissaburca.dao;

import marissaburca.entities.Book;
import marissaburca.entities.Magazine;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class MagazineDAO {
    private final EntityManager em; //permette interazione con database

    public MagazineDAO ( EntityManager em ) {
        this.em = em;
    }

    //*************************** SAVE ****************************
    public void save( Magazine magazine ){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(magazine);
        transaction.commit();
        System.out.println( "Magazine '" + magazine.getTitle() + "' successfully added to Archive");
    }

    //*********************** FIND BY ID **************************
    public Magazine findByCode( UUID id) {
        return em.find(Magazine.class, id);
    }

    //*************************** DELETE **************************
    public void findByCodeAndDelete(UUID id){
        Magazine found = this.findByCode(id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println( "Magazine '" + found.getTitle() + "' successfully deleted from Catalog");
        }else {
            System.out.println( "Magazine not found");
        }
    }
}
