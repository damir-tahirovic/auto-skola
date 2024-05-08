package me.projekat.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Radnik {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "radnik_seq")
    private Long id;

    private String ime;

    private String prezime;

    private Date datumRodjenja;

    private String jmbg;

    private String brojTelefona;

    @OneToMany(mappedBy = "radnik")
    private Set<RadnikPoznajeOblast> oblasti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public Set<RadnikPoznajeOblast> getOblasti() {
        return oblasti;
    }

    public void setOblasti(Set<RadnikPoznajeOblast> oblasti) {
        this.oblasti = oblasti;
    }
}
