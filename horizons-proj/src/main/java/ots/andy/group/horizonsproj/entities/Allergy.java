package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "allergy")
    private String allergy;

    @ManyToMany(mappedBy = "allergySet",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Child> childSet = new HashSet<>();

    public Set<Child> getChildren() {
        return childSet;
    }

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

    public Allergy() {
    }
}
