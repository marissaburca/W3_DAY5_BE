package marissaburca.entities;

import marissaburca.enums.Genre;

import javax.persistence.*;

@Entity
@DiscriminatorValue("book")
public class Book extends Catalog{
    @Column(name="author")
    private String authorName;
    @Column(name="genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    //CONSTRUCTORS

    public Book ( String title, int productionYear, int totalPages, String authorName, Genre genre ) {
        super(title, productionYear, totalPages);
        this.authorName = authorName;
        this.genre = genre;
    }

    public Book (){};


    //GETTER
    public String getAuthorname () {
        return authorName;
    }

    public Genre getGenre () {
        return genre;
    }


    //SETTER
    public void setAuthorname ( String authorName ) {
        this.authorName = authorName;
    }

    public void setGenre ( Genre genre ) {
        this.genre = genre;
    }


    //TO_STRING
    @Override
    public String toString () {
        return "Book: " +this.getTitle() + " author: " + authorName  + ", genre: " + genre ;
    }
}
