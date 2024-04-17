package me.projekat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "radnik_poznaje_oblast")
public class RadnikPoznajeOblast {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "radnik_poznaje_oblast_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "radnik_id")
    private Radnik radnik;

    @ManyToOne
    @JoinColumn(name = "oblast_id")
    private Oblast oblast;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Oblast getOblast() {
        return oblast;
    }

    public void setOblast(Oblast oblast) {
        this.oblast = oblast;
    }
}
