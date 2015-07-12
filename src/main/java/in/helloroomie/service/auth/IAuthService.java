package in.helloroomie.service.auth;

import in.helloroomie.domain.user.User;
import in.helloroomie.dto.user.UserDto;

/**
 * Created by Pradeep Arya on 7/12/2015.
 */
public interface IAuthService {

    UserDto authenticateUser(User user);
}
