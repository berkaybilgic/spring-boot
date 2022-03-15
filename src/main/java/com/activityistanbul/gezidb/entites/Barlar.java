package com.activityistanbul.gezidb.entites;

import javax.persistence.*;

@Entity
@Table(name = "barlar")
public class Barlar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bar_id")
    private int barId;

    @Column(name = "bar_name")
    private String barName;

    public Barlar(){
    }

    public Barlar(int barId, String barName) {
        this.barId = barId;
        this.barName = barName;
    }

    public int getBarId() {
        return barId;
    }

    public void setBarId(int barId) {
        this.barId = barId;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }
}
