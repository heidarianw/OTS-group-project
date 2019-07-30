package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;

@Entity
@Table(name="allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "allergy")
    private String allergy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public Allergy(String allergy) {
        this.allergy = allergy;
    }
}
