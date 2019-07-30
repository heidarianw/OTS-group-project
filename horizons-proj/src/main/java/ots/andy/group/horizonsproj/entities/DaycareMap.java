package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;

@Entity
@Table(name="daycaremap")
public class DaycareMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cid")
    private int cid;

    @Column(name = "did")
    private int did;

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

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public DaycareMap(int cid, int did) {
        this.cid = cid;
        this.did = did;
    }
}
