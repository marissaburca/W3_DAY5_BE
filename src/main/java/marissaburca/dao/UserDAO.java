package marissaburca.dao;
import marissaburca.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager em; //permette interazione con database

    public UserDAO ( EntityManager em ) {
        this.em = em;
    }

    //*************************** SAVE ****************************
    public void save( User user ){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println( "User " + user.getName() + " " + user.getSurname()+ " successfully added to Archive");
    }

    //*********************** FIND BY ID **************************
    public User findByCard( long id) {
        return em.find(User.class, id);
    }

    //*************************** DELETE **************************
    public void findByCardAndDelete(long id){
        User found = this.findByCard(id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println( "User "  + found.getName() + " "+ found.getSurname()+ " successfully deleted from Archive");
        }else {
            System.out.println( "User not found");
        }
    }
}
