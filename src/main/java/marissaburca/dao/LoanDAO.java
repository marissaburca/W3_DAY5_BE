package marissaburca.dao;

import marissaburca.entities.Loan;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoanDAO {
    private final EntityManager em; //permette interazione con database

    public LoanDAO ( EntityManager em ) {
        this.em = em;
    }

    //*************************** SAVE ****************************
    public void save( Loan loan ){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
        System.out.println( "Loan " + loan.getId() + " successfully added to Archive");
    }

    //*********************** FIND BY ID **************************
    public Loan findById( long id) {
        return em.find(Loan.class, id);
    }

    //*************************** DELETE **************************
    public void findByIdAndDelete(long id){
        Loan found = this.findById(id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println( "Loan " + found.getId() + " successfully deleted from Archive");
        }else {
            System.out.println( "Loan not found");
        }
    }
}


