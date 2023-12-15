package marissaburca.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="user")
public class User {
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="date_of_birth")
    private LocalDate birthday;
    @Id
    @Enumerated
    @Column(name="card_number")
    private long id;

    //CONSTRUCTORS
    public User ( String name, String surname, LocalDate birthday ) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }
    public User(){};


    //SETTER
    public void setName ( String name ) {
        this.name = name;
    }

    public void setSurname ( String surname ) {
        this.surname = surname;
    }

    public void setBirthday ( LocalDate birthday ) {
        this.birthday = birthday;
    }


    //GETTER
    public String getName () {
        return name;
    }

    public String getSurname () {
        return surname;
    }

    public LocalDate getBirthday () {
        return birthday;
    }

    public long getId () {
        return id;
    }

    //TO_STRING
    @Override
    public String toString () {
        return "User: " + name +  surname +  "; Date of birth: " + birthday + "; Card n°: " + id ;
    }
}
