package marissaburca.dao;

import marissaburca.entities.Catalog;
import marissaburca.entities.Loan;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

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
        System.out.println( "Loan for " + loan.getUser() + " successfully added to Archive");
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
    //********************** FIND ACTIVE LOANS USER **************************
    public List<Catalog> getElementsInLoan( long id ){
        TypedQuery<Catalog> getLoans = em.createNamedQuery("itemsInLoan",Catalog.class);
        getLoans.setParameter("userId",id);
        return getLoans.getResultList();
    }

    public List<Loan> getNotReturned(){
        TypedQuery<Loan> getLoans = em.createNamedQuery("notReturned", Loan.class);
        return getLoans.getResultList();
    }
}


