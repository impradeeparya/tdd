package in.helloroomie.dao.auth.impl;

import in.helloroomie.dao.auth.IAuthDao;
import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.user.User;
import in.helloroomie.dto.user.ChangePasswordDto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ICommonDao commonDao;

    private static SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

    @Override
    public Boolean signupUser(User user) {
        Boolean result = false;
        Criteria criteria = createCriteria(User.class);
        criteria.add(Restrictions.eq("email", user.getEmail()));
        Boolean isUserPresent = criteria.uniqueResult() != null ? true : false;
        if (!isUserPresent) {
            user.setPassword(generatePassword(user));
            saveUser(user);
            sendMail(user);
            result = true;
        }

        return result;
    }

    private String generatePassword(User user) {
        String pwd = UUID.randomUUID().toString();
        return pwd.substring(pwd.length() - 6, pwd.length());
    }

    private void sendMail(User user) {
        simpleMailMessage.setFrom("helloroomiemail@gmail.com");
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject("Welcome To HelloRoomie");
        simpleMailMessage.setText("Hello " + user.getEmail()
                + ",\n\nYour UserName : " + user.getEmail() + " Password : "
                + user.getPassword() + "\n\nCheers, \nHelloRoomie Team");
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public User authenticateUser(String userName, String password) {
        Criteria criteria = createCriteria(User.class);
        criteria.add(Restrictions.eq("email", userName));
        criteria.add(Restrictions.eq("password", password));

        if (criteria.list().size() > 0) {
            User user = (User) criteria.list().get(0);
            user.setToken(UUID.randomUUID().toString().toUpperCase() + "-"
                    + userName.toUpperCase() + "-" + new Date().getTime());
            updateUser(user);
            return user;
        }
        return null;
    }

    @Override
    public Boolean updatePassword(String token,
                                  ChangePasswordDto changePasswordDto) {

        Boolean result = false;
        User user = commonDao.fetchUserByToken(token);

        if (null != user) {
            if (user.getPassword().equals(changePasswordDto.getOld())) {
                user.setPassword(changePasswordDto.getUpdated());
                updateUser(user);
                result = true;
            }
        }
        return result;
    }

    private void updateUser(User user) {
        getCurrentSession().saveOrUpdate(user);
    }

    private void saveUser(User user) {
        getCurrentSession().save(user);
    }

    private Criteria createCriteria(Class className) {
        return getCurrentSession().createCriteria(className);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
