package marissaburca;

import com.github.javafaker.Faker;
import marissaburca.dao.*;
import marissaburca.entities.Book;
import marissaburca.entities.Catalog;
import marissaburca.entities.Magazine;
import marissaburca.entities.User;
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
        String uuid1 = "0dfe7978-135f-4e01-b082-b2c623b273d3";
        Catalog bookdb1 = cd.findByCode(UUID.fromString(uuid1));
        System.out.println("************* Items found by code *************");
        System.out.println(bookdb1.toString());

        List<Catalog> research1 = cd.getElementsByPublicationYear(2021);
        System.out.println("************* Items found by year *************");
        System.out.println(research1);

        List<Book> research2= cd.getElementsByAuthor("Mr. Reggie Haag");
        System.out.println("************* Items found by author *************");
        System.out.println(research2);

        List<Catalog> research3 = cd.getElementsByTitle("I'M");
        System.out.println("************* Items found by title *************");
        System.out.println(research3);

    }
}
