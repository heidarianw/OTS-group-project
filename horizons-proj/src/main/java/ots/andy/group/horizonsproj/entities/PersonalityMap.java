package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;

@Entity
@Table(name="personalitymap")
public class PersonalityMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "cid")
    private int cid;

    @Column(name = "persid")
    private int persid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPersid() {
        return persid;
    }

    public void setPersid(int persid) {
        this.persid = persid;
    }

    public PersonalityMap(int cid, int persid) {
        this.cid = cid;
        this.persid = persid;
    }
}
