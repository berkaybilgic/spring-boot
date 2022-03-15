package com.activityistanbul.gezidb.entites;

import javax.persistence.*;

@Entity
@Table(name = "konserler")
public class Konserler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "konser_ıd")
    private int konserId;

    @Column(name = "konser_name")
    private  String konserName;

    public Konserler(){
    }

    public Konserler(int konserId, String konserName) {
        this.konserId = konserId;
        this.konserName = konserName;
    }

    public int getKonserId() {
        return konserId;
    }

    public void setKonserId(int konserId) {
        this.konserId = konserId;
    }

    public String getKonserName() {
        return konserName;
    }

    public void setKonserName(String konserName) {
        this.konserName = konserName;
    }
}
