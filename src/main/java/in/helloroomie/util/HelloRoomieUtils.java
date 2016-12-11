package in.helloroomie.util;

import in.helloroomie.domain.user.User;
import in.helloroomie.dto.user.UserDto;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 8/12/16
 * Time: 8:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloRoomieUtils {

    private HelloRoomieUtils() {

    }

    public static UserDto prepareUserDTO(User user) {

        UserDto userDto;
        UserDto.UserDtoBuilder userDtoBuilder = new UserDto.UserDtoBuilder();
        if (null != user) {

            userDto = userDtoBuilder.setValidUser(true).
                    setContactNumber(user.getContactNumber()).
                    setEmail(user.getEmail()).
                    setUserName(StringUtils.capitalize(user.getFname()) + " "
                            + StringUtils.capitalize(user.getLname())).
                    setUserToken(user.getToken()).
                    build();


        } else {
            userDto = userDtoBuilder.setValidUser(true).build();
        }
        return userDto;
    }
}
