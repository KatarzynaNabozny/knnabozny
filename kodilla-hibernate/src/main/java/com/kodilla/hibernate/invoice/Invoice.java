package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public final class Invoice {
    int ide;
    String number;
    List<Item> items;

    public Invoice(String number, List<Item> items) {
        this.number = number;
        this.items = items;
    }

    public Invoice() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return ide;
    }

    private void setId(int id) {
        this.ide = id;
    }

    @NotNull
    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    private void setNumber(String number) {
        this.number = number;
    }


    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
