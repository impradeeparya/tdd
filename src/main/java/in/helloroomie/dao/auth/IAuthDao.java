package in.helloroomie.dao.auth;

import in.helloroomie.domain.user.User;

/**
 * Created by Pradeep Arya on 7/12/2015.
 */
public interface IAuthDao {

    User authenticateUser(String userName, String passoword);
}
