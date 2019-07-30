package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;

@Entity
@Table(name="personality")
public class Personality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "personality")
    private String personality;

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

    public Personality(String personality) {
        this.personality = personality;
    }
}
