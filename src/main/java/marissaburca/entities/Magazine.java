package marissaburca.entities;

import marissaburca.enums.Periodicity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Catalog {
    @Column(name="periodicity")
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
        return "Magazine's periodicity: " + periodicity;
    }
}
