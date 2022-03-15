package com.activityistanbul.gezidb.entites;

import javax.persistence.*;

@Entity
@Table(name = "sinemalar")
public class Sinemalar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sinema_id")
    private int sinemaId;

    @Column(name = "sinema_name")
    private String sinemaName;

    public Sinemalar() {
    }

    public Sinemalar(int sinemaId, String sinemaName) {
        this.sinemaId = sinemaId;
        this.sinemaName = sinemaName;
    }

    public int getSinemaId() {
        return sinemaId;
    }

    public void setSinemaId(int sinemaId) {
        this.sinemaId = sinemaId;
    }

    public String getSinemaName() {
        return sinemaName;
    }

    public void setSinemaName(String sinemaName) {
        this.sinemaName = sinemaName;
    }

}
