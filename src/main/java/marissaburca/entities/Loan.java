package marissaburca.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="loans")
@NamedQuery(name="itemsInLoan", query ="SELECT l.item FROM Loan l WHERE l.user.id = :userId")
@NamedQuery(name="notReturned", query ="SELECT l FROM Loan l WHERE l.ends < CURRENT_DATE AND l.returned IS NULL")
public class Loan {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="loaned_to")
    private User user;
    @ManyToOne
    @JoinColumn(name="loaned_item")
    private Catalog item;
    @Column(name="loan_started_on")
    private LocalDate starts;
    @Column(name="loan_ends_on")
    private LocalDate ends;
    @Column(name="item_returned_on", nullable = true)
    private LocalDate returned;

    //CONSTRUCTORS
    public Loan ( User user, Catalog item, LocalDate starts, LocalDate returned ) {
        this.user = user;
        this.item = item;
        this.starts = starts;
        this.ends = starts.plusDays(30);
        this.returned = returned;
    }
    public Loan (){};

    //SETTER

    public void setUser ( User user ) {
        this.user = user;
    }

    public void setItem ( Catalog item ) {
        this.item = item;
    }

    public void setStarts ( LocalDate starts ) {
        this.starts = starts;
    }

    public void setReturned ( LocalDate returned ) {
        this.returned = returned;
    }


    //GETTER
    public long getId () {
        return id;
    }

    public User getUser () {
        return user;
    }

    public Catalog getItem () {
        return item;
    }

    public LocalDate getStarts () {
        return starts;
    }

    public LocalDate getEnds () {
        return ends;
    }

    public LocalDate getReturned () {
        return returned;
    }

    //TO_STRING

    @Override
    public String toString () {
        return "Loan for: "  + user + "; Item: " + item + "; Started on: " + starts + "; Predicted return on: " + ends + "; Returned on: " + returned;
    }
}
