package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    private String status;

    @OneToMany(targetEntity=Child.class, mappedBy="status",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Child> childSet = new HashSet<>();

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

    public Set<Child> getChildren() {
        return childSet;
    }

    public Status(String status) {
        this.status = status;
    }

    public Status() {
    }
}
