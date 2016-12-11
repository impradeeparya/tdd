package in.helloroomie.dto.user;

/**
 * Created by Pradeep Arya on 7/12/2015.
 */
public class UserDto {

    Long id;
    String userName;
    boolean validUser;
    String userToken;
    String email;
    String contactNumber;
    String password;

    public UserDto(UserDtoBuilder userDtoBuilder) {
        this.userName = userDtoBuilder.userName;
        this.validUser = userDtoBuilder.validUser;
        this.userToken = userDtoBuilder.userToken;
        this.email = userDtoBuilder.email;
        this.contactNumber = userDtoBuilder.contactNumber;
        this.password = userDtoBuilder.password;
    }

    public UserDto(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isValidUser() {
        return validUser;
    }

    public void setValidUser(boolean validUser) {
        this.validUser = validUser;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class UserDtoBuilder {

        String userName;
        boolean validUser;
        String userToken;
        String email;
        String contactNumber;
        String password;


        public UserDtoBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserDtoBuilder setValidUser(boolean validUser) {
            this.validUser = validUser;
            return this;
        }

        public UserDtoBuilder setUserToken(String userToken) {
            this.userToken = userToken;
            return this;
        }

        public UserDtoBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDtoBuilder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public UserDtoBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }


    }
}
