package in.helloroomie.domain.ad;

import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Entity
@Table(name = "AD")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "TITLE")
    private String title;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "RENT")
    private String rent;

    @Column(name = "ROOMS")
    @NotNull
    private int numberOfRooms;

    @NotNull
    @Column(name = "ALLOWED_TO")
    private String allowedTo;

    @OneToOne
    @JoinColumn(name = "LOCALITY_ID", referencedColumnName = "ID")
    @NotNull
    private Locality locality;

    @OneToOne
    @JoinColumn(name = "ADVERTISER_ID", referencedColumnName = "ID")
    @NotNull
    private User user;

    @Column(name = "CREATED_ON")
    @NotNull
    private Date createdOn;
    @NotNull
    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "ACTIVE")
    private Boolean isActive;

    @OneToMany
    @NotNull
    private List<Image> image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getAllowedTo() {
        return allowedTo;
    }

    public void setAllowedTo(String allowedTo) {
        this.allowedTo = allowedTo;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

}
