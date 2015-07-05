package in.helloroomie.dao.common.impl;

import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.city.City;
import in.helloroomie.domain.zone.Zone;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Repository
public class CommonDaoImpl implements ICommonDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<City> getAllCities() {

        Criteria criteria = createCriteria(City.class);
        return criteria.list();
    }

    @Override
    public List<Zone> getCityZones(Long cityId) {
        Criteria criteria = createCriteria(Zone.class);
        criteria.createAlias("city", "c");
        criteria.add(Restrictions.eq("c.id", cityId));
        return criteria.list();
    }

    private Criteria createCriteria(Class className) {
        return sessionFactory.getCurrentSession().createCriteria(className);
    }
}
