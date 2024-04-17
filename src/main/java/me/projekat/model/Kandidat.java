package me.projekat.model;

import jakarta.persistence.*;
import me.projekat.model.restClient.IpClient;
import me.projekat.rest.server.IpLog;
//import me.projekat.rest.server.Iplog;

import java.util.Date;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = Kandidat.GET_ALL, query = "select k from Kandidat k")
})
public class Kandidat {

    public static final String GET_ALL = "getAll";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private Long id;

    private String ime;

    private String prezime;

    private String jmbg;

    private Date datumRodjenja;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Set<Telefon> telefoni;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private IpLog ipLog;

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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Set<Telefon> getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(Set<Telefon> telefoni) {
        this.telefoni = telefoni;
    }

    public IpLog getIpLog() {
        return ipLog;
    }

    public void setIpLog(IpLog ipLog) {
        this.ipLog = ipLog;
    }
}


