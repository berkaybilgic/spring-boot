package com.activityistanbul.gezidb.entites;

import javax.persistence.*;

@Entity
@Table(name = "tiyatrolar")
public class Tiyatrolar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tiyatro_id")
    private int tiyatroId;

    @Column(name = "tiyatro_name")
    private String tiyatroName;

    public Tiyatrolar() {
    }

    public Tiyatrolar(int tiyatroId, String tiyatroName) {
        this.tiyatroId = tiyatroId;
        this.tiyatroName = tiyatroName;
    }

    public int getTiyatroId() {
        return tiyatroId;
    }

    public void setTiyatroId(int tiyatroId) {
        this.tiyatroId = tiyatroId;
    }

    public String getTiyatroName() {
        return tiyatroName;
    }

    public void setTiyatroName(String tiyatroName) {
        this.tiyatroName = tiyatroName;
    }
}
