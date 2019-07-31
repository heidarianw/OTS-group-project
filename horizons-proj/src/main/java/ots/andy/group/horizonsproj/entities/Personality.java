package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="personality")
public class Personality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "personality")
    private String personality;

    @OneToMany(targetEntity=Child.class, mappedBy="personality",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Child> childSet = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public Set<Child> getChildren() {
        return childSet;
    }

    public Personality(String personality) {
        this.personality = personality;
    }

    public Personality() {
    }
}
