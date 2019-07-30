package ots.andy.group.horizonsproj.entities;

import javax.persistence.*;

@Entity
@Table(name="parent")
public class Parent {

    @Id
    @GeneratedValue
    private int id;

    @Column (name = "first")
    private String first;

    @Column (name = "last")
    private String last;

    @Column (name = "email")
    private String email;

    @Column (name = "password")
    private String password;

    @Column (name = "phone")
    private String phone;

    Parent() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
