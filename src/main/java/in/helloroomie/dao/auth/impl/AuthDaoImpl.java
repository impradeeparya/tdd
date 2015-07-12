package in.helloroomie.dao.auth.impl;

import in.helloroomie.dao.auth.IAuthDao;
import in.helloroomie.domain.user.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Pradeep Arya on 7/12/2015.
 */

@Repository
public class AuthDaoImpl implements IAuthDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User authenticateUser(String userName, String password) {
        Criteria criteria = createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", userName));
        criteria.add(Restrictions.eq("password", password));

        if (criteria.list().size() > 0) {
            User user = (User) criteria.list().get(0);
            user.setToken(UUID.randomUUID().toString().toUpperCase() + "-" + userName.toUpperCase() + "-" + new Date().getTime());
            updateUserToken(user);
            return user;
        }
        return null;
    }

    private void updateUserToken(User user) {
        getCurrentSession().saveOrUpdate(user);
    }

    private Criteria createCriteria(Class className) {
        return getCurrentSession().createCriteria(className);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
