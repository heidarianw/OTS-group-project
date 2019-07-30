package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;

@Entity
@Table(name="status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Status(String status) {
        this.status = status;
    }
}
