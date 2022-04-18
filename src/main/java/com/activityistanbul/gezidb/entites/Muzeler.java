package com.activityistanbul.gezidb.entites;

import javax.persistence.*;

@Entity
@Table(name = "muzeler")
public class Muzeler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "muze_id")
    private int muzeId;

    @Column(name = "muze_name")
    private String muzeName;

    public Muzeler() {
    }

    public Muzeler(int muzeId, String muzeName) {
        this.muzeId = muzeId;
        this.muzeName = muzeName;
    }

    public int getMuzeId() {
        return muzeId;
    }

    public void setMuzeId(int muzeId) {
        this.muzeId = muzeId;
    }

    public String getMuzeName() {
        return muzeName;
    }

    public void setMuzeName(String muzeName) {
        this.muzeName = muzeName;
    }
}