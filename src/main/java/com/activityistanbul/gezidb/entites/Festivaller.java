package com.activityistanbul.gezidb.entites;

import javax.persistence.*;

@Entity
@Table(name = "festivaller")
public class Festivaller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "festival_id")
    private int festivalId;

    @Column(name = "festival_name")
    private String festivalName;

    public Festivaller() {
    }

    public Festivaller(int festivalId, String festivalName) {
        this.festivalId = festivalId;
        this.festivalName = festivalName;
    }

    public int getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(int festivalId) {
        this.festivalId = festivalId;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }
}
