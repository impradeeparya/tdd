package in.helloroomie.domain.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Long id;

    @NotNull
    @Column(name = "FIRST_NAME")
    String fname;


    @NotNull
    @Column(name = "LAST_NAME")
    String lname;


    @NotNull
    @Column(name = "EMAIL")
    String email;


    @NotNull
    @Column(name = "CONTACT_NUMBER")
    String contactNumber;


    @NotNull
    @Column(name = "PASSWORD")
    String password;

    @Column(name = "TOKEN")
    String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
