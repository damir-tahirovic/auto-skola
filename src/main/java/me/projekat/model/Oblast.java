package me.projekat.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Oblast {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oblast_seq")
    private Long id;

    private String naziv;

    @OneToMany(mappedBy = "oblast")
    private Set<RadnikPoznajeOblast> radnici;

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

    public Set<RadnikPoznajeOblast> getRadnici() {
        return radnici;
    }

    public void setRadnici(Set<RadnikPoznajeOblast> radnici) {
        this.radnici = radnici;
    }
}
