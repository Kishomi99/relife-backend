package com.Employee.RegisterLogin.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",   length = 50)
    private int userid;

    @Column(name="full_name",   length = 250)
    private String fullname;

    @Column(name="email",   length = 250)
    private  String email;

    @Column(name="password",   length = 250)
    private  String password;

    public User() {
    }

    public User(int userid, String fullname, String email, String password) {
        this.userid = userid;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }
   

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
