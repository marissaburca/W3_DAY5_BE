package marissaburca.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_of_item")
@NamedQuery(name="findByYear", query ="SELECT e FROM Catalog e WHERE e.publicationYear =:publicationYear")
@NamedQuery(name="findByAuthor", query ="SELECT b FROM Book b WHERE b.authorName =:authorName")
@NamedQuery(name = "findByTitle", query = "SELECT e FROM Catalog e WHERE LOWER(e.title) LIKE LOWER(CONCAT('%', :partialTitle, '%'))")
public class Catalog {
    @Id
    @Column(name ="isbn_code")
    private UUID isbnCode;
    @Column(name="title")
    private String title;
    @Column(name="publication_year")
    private int publicationYear;
    @Column(name="total_of_pages")
    private int totalPages;
    @OneToMany(mappedBy = "item")
    private List<Loan> loans = new ArrayList<>();


    //CONSTRUCTORS
    public Catalog ( String title, int publicationYear
            , int totalPages ) {
        this.isbnCode = UUID.randomUUID();
        this.title = title;
        this.publicationYear
                = publicationYear
        ;
        this.totalPages = totalPages;
    }

    public Catalog(){};


    //GETTER
    public UUID getIsbnCode () {
        return isbnCode;
    }

    public String getTitle () {
        return title;
    }

    public int getPublicationYear () {
        return publicationYear
                ;
    }

    public int getTotalPages () {
        return totalPages;
    }


    //SETTER
    public void setTitle ( String title ) {
        this.title = title;
    }

    public void setPublicationYear ( int publicationYear ) {
        this.publicationYear = publicationYear;
    }

    public void setTotalPages ( int totalPages ) {
        this.totalPages = totalPages;
    }


    //TO_STRING
    @Override
    public String toString () {
        return "Item has code: " + isbnCode + "; Title: " + title + "; Year of publication: " + publicationYear
                + "; Number of pages: " + totalPages;
    }
}
