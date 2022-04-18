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

    @Column(name = "bar_location")
    private String barLocation;

    @Column(name = "bar_img")
    private String barImg;

    @Column(name = "bar_description")
    private String barDescription;


    public Barlar() {
    }

    public Barlar(int barId, String barName, String barLocation, String barImg, String barDescription) {
        this.barId = barId;
        this.barName = barName;
        this.barLocation = barLocation;
        this.barImg = barImg;
        this.barDescription = barDescription;
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

    public String getBarLocation() {
        return barLocation;
    }

    public void setBarLocation(String barLocation) {
        this.barLocation = barLocation;
    }

    public String getBarImg() {
        return barImg;
    }

    public void setBarImg(String barImg) {
        this.barImg = barImg;
    }

    public String getBarDescription() {
        return barDescription;
    }

    public void setBarDescription(String barDescription) {
        this.barDescription = barDescription;
    }
}
