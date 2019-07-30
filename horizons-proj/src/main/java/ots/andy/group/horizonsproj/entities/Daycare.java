package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;

@Entity
@Table(name="daycare")
public class Daycare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "daycare")
    private String daycare;

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

    public Daycare(String daycare) {
        this.daycare = daycare;
    }
}
