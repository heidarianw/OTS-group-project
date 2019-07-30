package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;

@Entity
@Table(name="allergymap")
public class AllergyMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cid")
    private int cid;

    @Column(name = "aid")
    private int aid;

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

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public AllergyMap() {}

    public AllergyMap(int cid, int aid) {
        this.cid = cid;
        this.aid = aid;
    }
}
