package me.projekat.rest.server;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IpLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ipLog_seq")
    private Long id;

    private String ipString;

    private String ipType;

    public IpLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpString() {
        return ipString;
    }

    public void setIpString(String ipString) {
        this.ipString = ipString;
    }

    public String getIpType() {
        return ipType;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }


}


