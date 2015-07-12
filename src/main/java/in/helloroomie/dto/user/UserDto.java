package in.helloroomie.dto.user;

/**
 * Created by Pradeep Arya on 7/12/2015.
 */
public class UserDto {
    String userName;
    Boolean isValidUser;
    String userToken;

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
}
