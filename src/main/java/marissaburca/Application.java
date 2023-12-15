package marissaburca;

import com.github.javafaker.Faker;
import marissaburca.dao.*;
import marissaburca.entities.*;
import marissaburca.enums.Genre;
import marissaburca.enums.Periodicity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Archive");
    public static void main(String[] args) {
        Faker faker= new Faker();

        EntityManager em = emf.createEntityManager();
        CatalogDAO cd = new CatalogDAO(em);
        BookDAO bd= new BookDAO(em);
        MagazineDAO md= new MagazineDAO(em);
        LoanDAO ld = new LoanDAO(em);
        UserDAO ud = new UserDAO(em);

        //create and save some users in database, then obtain it from db
        User user1= new User(faker.name().firstName(),faker.name().lastName(), LocalDate.of(1999,1,14));
        User user2= new User(faker.name().firstName(),faker.name().lastName(), LocalDate.of(1989,5,22));
        User user3= new User(faker.name().firstName(),faker.name().lastName(), LocalDate.of(2001,8,4));
        User user4= new User(faker.name().firstName(),faker.name().lastName(), LocalDate.of(2005,12,28));
        User user5= new User(faker.name().firstName(),faker.name().lastName(), LocalDate.of(1999,10,1));
        //ud.save(user1);
        //ud.save(user2);
        //ud.save(user3);
        //ud.save(user4);
        //ud.save(user5);
        User userdb1 = ud.findByCard(1);
        User userdb2 = ud.findByCard(2);
        User userdb3 = ud.findByCard(3);
        User userdb4 = ud.findByCard(4);
        User userdb5 = ud.findByCard(5);


        //create and save some items in database
        Book book1 = new Book("TRY AGAIN",2011,500,faker.name().fullName(), Genre.FANTASY);
        Book book2 = new Book("NOT WORKING",2012,320,faker.name().fullName(), Genre.HORROR);
        Book book3 = new Book("I'M TIRED",2023,120,faker.name().fullName(), Genre.THRILLER);
        Book book4 = new Book("LEAVE ME ALONE",2021,150,faker.name().fullName(), Genre.AUTOBIOGRAPHY);
        //bd.save(book1);
        //bd.save(book2);
        //bd.save(book3);
        //bd.save(book4);

        Magazine magazine1 = new Magazine("HERE WE GO AGAIN",2021,60, Periodicity.WEEKLY);
        Magazine magazine2 = new Magazine("A DISASTER",2023,80, Periodicity.MONTHLY);
        Magazine magazine3 = new Magazine("I CAN'T ANYMORE",2022,75, Periodicity.SEMI_ANNUAL);
        //md.save(magazine1);
        //md.save(magazine2);
        //md.save(magazine3);

        //QUERY APPLICATION

        String uuid1 = "013ca189-009e-46a9-9367-d32199c48ffc";
        Catalog bookdb1 = cd.findByCode(UUID.fromString(uuid1));
        String uuid2 = "3488003a-cfb2-4f41-b69c-5beb3b9c6acb";
        Catalog bookdb2 = cd.findByCode(UUID.fromString(uuid2));
        String uuid3 = "37b64ebb-e536-41ef-8b92-7f5fc8806943";
        Catalog bookdb3 = cd.findByCode(UUID.fromString(uuid3));
        String uuid4 = "4a90b4c0-bee1-40ad-9fc5-f9aa7b3f42da";
        Catalog bookdb4 = cd.findByCode(UUID.fromString(uuid4));
        String uuid5 = "f72e2ceb-1aed-458f-8c33-e0042270314d";
        Catalog bookdb5 = cd.findByCode(UUID.fromString(uuid5));
        System.out.println("************* Items found by code *************");
        System.out.println(bookdb1.toString());
        //cd.findByCodeAndDelete(UUID.fromString(uuid1)); //tested deleting

        List<Catalog> research1 = cd.getElementsByPublicationYear(2021);
        System.out.println("************* Items found by year *************");
        System.out.println(research1);

        List<Book> research2= cd.getElementsByAuthor("Mr. Reggie Haag");
        System.out.println("************* Items found by author *************");
        System.out.println(research2);

        List<Catalog> research3 = cd.getElementsByTitle("I'M");
        System.out.println("************* Items found by title *************");
        System.out.println(research3);

        System.out.println("*************************************************");
        //create loans
        Loan loan1 = new Loan(userdb1,bookdb2,LocalDate.now(),null);
        Loan loan2 = new Loan(userdb2,bookdb1,LocalDate.of(2023,10,11),null);
        Loan loan3 = new Loan(userdb3,bookdb3,LocalDate.of(2023,12,5),null);
        Loan loan4 = new Loan(userdb2,bookdb4,LocalDate.of(2023,12,5),LocalDate.now());
        Loan loan5 = new Loan(userdb4,bookdb4,LocalDate.of(2023,12,5),null);
        Loan loan6 = new Loan(userdb3,bookdb4,LocalDate.of(2023,11,8),LocalDate.of(2023,12,5));
        //d.save(loan1);
        //ld.save(loan2);
        //ld.save(loan3);
        //ld.save(loan4);
        //ld.save(loan5);
        //ld.save(loan6);

        List<Catalog> loansPerUser = ld.getElementsInLoan(3);
        System.out.println("**************************************************");
        System.out.println("Following items are still in loan for " + userdb3 );
        System.out.println(loansPerUser);

        System.out.println("**************** NOT RETURNED YET **************");
        List<Loan> notReturned = ld.getNotReturned();
        System.out.println(notReturned);
    }
}
