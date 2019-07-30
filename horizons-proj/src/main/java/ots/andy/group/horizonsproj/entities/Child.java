package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;

@Entity
@Table(name="child")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @Column(name = "statusid")
    private int sid;

    @Column(name = "photo")
    private String photo;

    public Child() {
    }

    public Child(String first, String last, int age, boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, int status, String photo) {
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
        this.sid = status;
        this.photo = photo;
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

    public int getStatus() {
        return sid;
    }

    public void setStatus(int sid) {
        this.sid = sid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
                ", status=" + sid +
                ", photo='" + photo + '\'' +
                '}';
    }
}
