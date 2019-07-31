package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="daycare")
public class Daycare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "daycare")
    private String daycare;

    @OneToMany(targetEntity=Child.class, mappedBy="daycare",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Child> childSet = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDaycare() {
        return daycare;
    }

    public void setDaycare(String daycare) {
        this.daycare = daycare;
    }

    public Set<Child> getChildren() {
        return childSet;
    }

    public Daycare(String daycare) {
        this.daycare = daycare;
    }

    public Daycare() {
    }
}
