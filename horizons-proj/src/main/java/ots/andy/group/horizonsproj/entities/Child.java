package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="child")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 1;

    @Column(name = "first")
    private String first;

    @Column(name = "last")
    private String last;

    @Column(name = "age")
    private int age;

    @Column(name = "sunday")
    private boolean sunday;

    @Column(name = "monday")
    private boolean monday;

    @Column(name = "tuesday")
    private boolean tuesday;

    @Column(name = "wednesday")
    private boolean wednesday;

    @Column(name = "thursday")
    private boolean thursday;

    @Column(name = "friday")
    private boolean friday;

    @Column(name = "saturday")
    private boolean saturday;

    @Column(name = "photo")
    private String photo;

    @ManyToMany(cascade = {
            CascadeType.PERSIST
    },fetch = FetchType.LAZY)
    @JoinTable(name = "allergymap",
            joinColumns = @JoinColumn(name = "cid"),
            inverseJoinColumns = @JoinColumn(name = "aid"))
    private Set<Allergy> allergySet = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST
    },fetch = FetchType.LAZY)
    @JoinTable(name = "parentmap",
            joinColumns = @JoinColumn(name = "cid"),
            inverseJoinColumns = @JoinColumn(name = "pid"))
    private Set<Parent> parentSet = new HashSet<>();

    @ManyToOne()
    @JoinColumn(name = "personalityid")
    private Personality personality;

    @ManyToOne()
    @JoinColumn(name = "daycareid")
    private Daycare daycare;

    @ManyToOne()
    @JoinColumn(name = "statusid")
    private Status status;

    public Child() {

    }

    public Child(String first, String last, int age, boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, String photo) {
        this.first = first;
        this.last = last;
        this.age = age;
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.photo = photo;
    }

    public Child(int id, String first, String last, int age) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.age = age;
    }

    public Child(String first, String last, int age) {
        this.first = first;
        this.last = last;
        this.age = age;
    }

    public void addAllergy(Allergy allergy) {
        allergySet.add(allergy);
        allergy.getChildren().add(this);
    }

    public void removeAllergy(Allergy allergy) {
        allergySet.remove(allergy);
        allergy.getChildren().remove(this);
    }

    public void addAllergies(List<Allergy> allergyList){
        for(Allergy a : allergyList){
            this.addAllergy(a);
        }
    }

    public void addParent(Parent parent) {
        parentSet.add(parent);
        parent.getChildren().add(this);
    }

    public void removeParent(Parent parent) {
        parentSet.remove(parent);
        parent.getChildren().remove(this);
    }

    public void setPersonality(Personality personality) {
        personality.getChildren().remove(this);
        this.personality = personality;
        personality.getChildren().add(this);
    }

    public void setDaycare(Daycare daycare) {
        daycare.getChildren().remove(this);
        this.daycare = daycare;
        daycare.getChildren().add(this);
    }

    public void setStatus(Status status) {
        status.getChildren().remove(this);
        this.status = status;
        status.getChildren().add(this);
    }
    
    public Set<Allergy> getAllergySet() {
        return allergySet;
    }

    public Set<Parent> getParentSet() {
        return parentSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSunday() {
        return sunday;
    }

    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }

    public boolean isMonday() {
        return monday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status.getStatus();
    }

    public String getDaycare() {
        return daycare.getDaycare();
    }

    public String getPersonality() {
        return personality.getPersonality();
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", age=" + age +
                ", sunday=" + sunday +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                ", photo='" + photo + '\'' +
                ", personality=" + personality +
                ", daycare=" + daycare +
                ", status=" + status +
                '}';
    }
}
