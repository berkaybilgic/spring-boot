package com.activityistanbul.gezidb.entites;


import javax.persistence.*;

@Entity
@Table(name = "mekanlar")
public class Mekanlar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mekan_id")
    private int mekanId;

    @Column(name = "mekan_name")
    private String mekanName;

    @Column(name = "mekan_location")
    private String mekanLocation;

    @Column(name = "mekan_img")
    private String mekanImg;

    @Column(name = "mekan_description")
    private String mekanDescription;

    @Column(name = "mekan_kategori")
    private String mekanKategori;


     public Mekanlar(){
     }


    public Mekanlar(int mekanId, String mekanName, String mekanLocation, String mekanImg, String mekanDescription, String mekanKategori) {
        this.mekanId = mekanId;
        this.mekanName = mekanName;
        this.mekanLocation = mekanLocation;
        this.mekanImg = mekanImg;
        this.mekanDescription = mekanDescription;
        this.mekanKategori = mekanKategori;
    }


    public int getMekanId() {
        return mekanId;
    }

    public void setMekanId(int mekanId) {
        this.mekanId = mekanId;
    }

    public String getMekanName() {
        return mekanName;
    }

    public void setMekanName(String mekanName) {
        this.mekanName = mekanName;
    }

    public String getMekanLocation() {
        return mekanLocation;
    }

    public void setMekanLocation(String mekanLocation) {
        this.mekanLocation = mekanLocation;
    }

    public String getMekanImg() {
        return mekanImg;
    }

    public void setMekanImg(String mekanImg) {
        this.mekanImg = mekanImg;
    }

    public String getMekanDescription() {
        return mekanDescription;
    }

    public void setMekanDescription(String mekanDescription) {
        this.mekanDescription = mekanDescription;
    }

    public String getMekanKategori() {
        return mekanKategori;
    }

    public void setMekanKategori(String mekanKategori) {
        this.mekanKategori = mekanKategori;
    }
}
