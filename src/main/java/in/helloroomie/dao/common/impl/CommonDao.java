package in.helloroomie.dao.common.impl;

import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.city.City;
import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.user.User;
import in.helloroomie.domain.zone.Zone;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Repository
public class CommonDao implements ICommonDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<City> fetchAllCities() {

		Criteria criteria = createCriteria(City.class);
		return criteria.list();
	}

	@Override
	public List<Zone> fetchZonesByCity(Long cityId) {
		Criteria criteria = createCriteria(Zone.class);
		criteria.createAlias("city", "c");
		criteria.add(Restrictions.eq("c.id", cityId));
		return criteria.list();
	}

	@Override
	public List<Locality> fetchLocalitiesByZone(Long zoneId) {
		Criteria criteria = createCriteria(Locality.class);
		criteria.createAlias("zone", "z");
		criteria.add(Restrictions.eq("z.id", zoneId));
		return criteria.list();
	}

	@Override
	public List<Locality> fetchLocalitiesByCity(Long cityId) {
		Criteria criteria = createCriteria(Locality.class);
		criteria.createAlias("zone", "z");
		criteria.add(Restrictions.eq("z.city.id", cityId));
		return criteria.list();
	}

	@Override
	public User fetchUserByToken(String token) {
		Criteria userCriteria = createCriteria(User.class);
		userCriteria.add(Restrictions.eq("token", token));
		User user = (User) userCriteria.uniqueResult();
		return user;
	}

	private Criteria createCriteria(Class className) {
		return sessionFactory.getCurrentSession().createCriteria(className);
	}

}
