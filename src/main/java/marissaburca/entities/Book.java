package marissaburca.entities;

import marissaburca.enums.Genre;

import javax.persistence.Column;

public class Book extends Catalog{
    @Column(name="author")
    private String authorname;
    private Genre genre;

    //CONSTRUCTORS

    public Book ( String title, int productionYear, int totalPages, String authorname, Genre genre ) {
        super(title, productionYear, totalPages);
        this.authorname = authorname;
        this.genre = genre;
    }

    public Book (){};


    //GETTER
    public String getAuthorname () {
        return authorname;
    }

    public Genre getGenre () {
        return genre;
    }


    //SETTER
    public void setAuthorname ( String authorname ) {
        this.authorname = authorname;
    }

    public void setGenre ( Genre genre ) {
        this.genre = genre;
    }

    //TOSTRING

    @Override
    public String toString () {
        return "Book author :" + authorname  + "; Genre=" + genre ;
    }
}
