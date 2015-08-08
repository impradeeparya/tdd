package in.helloroomie.dto.user;

/**
 * Created by Pradeep Arya on 7/12/2015.
 */
public class UserDto {

	Long id;
	String userName;
	Boolean isValidUser;
	String userToken;
	String email;
	String contactNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getIsValidUser() {
		return isValidUser;
	}

	public void setIsValidUser(Boolean isValidUser) {
		this.isValidUser = isValidUser;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
