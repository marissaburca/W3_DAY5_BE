package marissaburca;

import marissaburca.dao.CatalogDAO;
import marissaburca.dao.LoanDAO;
import marissaburca.dao.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Archive");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        CatalogDAO cd = new CatalogDAO(em);
        LoanDAO ld = new LoanDAO(em);
        UserDAO ud = new UserDAO(em);


    }
}
