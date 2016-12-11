package in.helloroomies.commons;

import in.helloroomie.dto.user.UserDto;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 8/12/16
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestDataUtil {

    private TestDataUtil() {

    }

    public static UserDto getUserDto() {

        UserDto.UserDtoBuilder userDtoBuilder = new UserDto.UserDtoBuilder();
        UserDto userDto = userDtoBuilder.setValidUser(true).
                setContactNumber("9999710381").
                setEmail("impradeeparya@gmail.com").
                setUserName("impradeeparya@gmail.com").
                setUserToken("token").
                build();

        return userDto;
    }
}
