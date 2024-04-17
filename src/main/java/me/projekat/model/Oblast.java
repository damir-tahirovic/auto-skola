package me.projekat.model;

import jakarta.persistence.*;

@Entity
public class Oblast {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oblast_seq")
    private Long id;

    private String naziv;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
