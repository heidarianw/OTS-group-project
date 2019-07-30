package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;

@Entity
@Table(name="parentmap")
public class ParentMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cid")
    private int cid;

    @Column(name = "pid")
    private int pid;

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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public ParentMap(int cid, int pid) {
        this.cid = cid;
        this.pid = pid;
    }
}
