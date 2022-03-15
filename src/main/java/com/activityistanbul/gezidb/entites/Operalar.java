package com.activityistanbul.gezidb.entites;

import javax.persistence.*;

@Entity
@Table(name = "operalar")
public class Operalar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opera_id")
    private int operaID;

    @Column(name = "opera_name")
    private String operaName;

    public Operalar(){
    }

    public Operalar(int operaID, String operaName) {
        this.operaID = operaID;
        this.operaName = operaName;
    }

    public int getOperaID() {
        return operaID;
    }

    public void setOperaID(int operaID) {
        this.operaID = operaID;
    }

    public String getOperaName() {
        return operaName;
    }

    public void setOperaName(String operaName) {
        this.operaName = operaName;
    }
}