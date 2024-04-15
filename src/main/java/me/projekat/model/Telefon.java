package me.projekat.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Telefon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    public Long id;

    public String broj;

    @ManyToOne
    @JoinColumn(name = "kandidat_id")
    private Kandidat kandidat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}
