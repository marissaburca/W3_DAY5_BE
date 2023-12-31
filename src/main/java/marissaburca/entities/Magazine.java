package marissaburca.entities;

import marissaburca.enums.Periodicity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Catalog {
    @Column(name="periodicity")
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;


    //CONSTRUCTORS
    public Magazine ( String title, int productionYear, int totalPages, Periodicity periodicity ) {
        super(title, productionYear, totalPages);
        this.periodicity = periodicity;
    }
    public Magazine(){};


    //GETTER
    public Periodicity getPeriodicity () {
        return periodicity;
    }


    //SETTER
    public void setPeriodicity ( Periodicity periodicity ) {
        this.periodicity = periodicity;
    }


    //TO_STRING


    @Override
    public String toString () {
        return "Magazine: " + this.getTitle() + "; publication: "+ this.getPublicationYear() +"; periodicity: " + periodicity ;
    }
}
