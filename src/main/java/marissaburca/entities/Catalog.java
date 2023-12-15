package marissaburca.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name ="Catalog")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Catalog {
    @Id
    @Column(name ="isbn_code")
    private UUID isbnCode;
    @Column(name="title")
    private String title;
    @Column(name="production_year")
    private int productionYear;
    @Column(name="total_of_pages")
    private int totalPages;

    //CONSTRUCTORS

    public Catalog ( String title, int productionYear, int totalPages ) {
        this.title = title;
        this.productionYear = productionYear;
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

    public int getProductionYear () {
        return productionYear;
    }

    public int getTotalPages () {
        return totalPages;
    }


    //SETTER


    public void setTitle ( String title ) {
        this.title = title;
    }

    public void setProductionYear ( int productionYear ) {
        this.productionYear = productionYear;
    }

    public void setTotalPages ( int totalPages ) {
        this.totalPages = totalPages;
    }

    //TOSTRING

    @Override
    public String toString () {
        return "Catalog has code: " + isbnCode + "; Title: " + title + "; Year of production: " + productionYear + "; Number of pages: " + totalPages;
    }
}
