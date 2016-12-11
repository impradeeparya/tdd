package in.helloroomie.service.auth.impl;

import in.helloroomie.dao.auth.IAuthDao;
import in.helloroomie.domain.user.User;
import in.helloroomie.dto.user.ChangePasswordDto;
import in.helloroomie.dto.user.UserDto;
import in.helloroomie.service.auth.IAuthService;
import in.helloroomie.util.HelloRoomieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Pradeep Arya on 7/12/2015.
 */

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IAuthDao authDao;

    @Override
    @Transactional
    public UserDto authenticateUser(UserDto user) {
        String userName = user.getEmail();
        String password = user.getPassword();
        return HelloRoomieUtils.prepareUserDTO(authDao.authenticateUser(userName, password));
    }

    @Override
    @Transactional
    public Boolean signupUser(User user) {
        return authDao.signupUser(user);
    }

    @Override
    @Transactional
    public Boolean updatePassword(String token,
                                  ChangePasswordDto changePasswordDto) {
        return authDao.updatePassword(token, changePasswordDto);
    }
}
