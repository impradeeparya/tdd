package in.helloroomie.domain.ad;

import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Entity
@Table(name = "ad")
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String title;
	String description;
	String rent;

	@Column(name = "rooms")
	int numberOfRooms;
	@Column(name = "allowed_to")
	String allowedTo;

	@OneToOne
	@JoinColumn(name = "locality_id", referencedColumnName = "id")
	Locality locality;

	@OneToOne
	@JoinColumn(name = "advertiser_id", referencedColumnName = "id")
	User user;

	@Column(name = "created_on")
	Date createdOn;
	@Column(name = "updated_on")
	Date updatedOn;

	@Column(name = "active")
	Boolean isActive;

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

}
