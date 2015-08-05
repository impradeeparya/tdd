package in.helloroomie.service.common.impl;

import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.city.City;
import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.user.User;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.service.common.ICommonServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Service
public class CommonServicesImpl implements ICommonServices {

	@Autowired
	private ICommonDao commonDao;

	@Override
	@Transactional
	public List<City> getAllCities() {
		return commonDao.getAllCities();
	}

	@Override
	@Transactional
	public List<Zone> getZonesByCity(Long cityId) {
		return commonDao.getZonesByCity(cityId);
	}

	@Override
	@Transactional
	public List<Locality> getLocalityByZone(Long zoneId) {
		return commonDao.getLocalityByZone(zoneId);
	}

	@Override
	@Transactional
	public List<Locality> getLocalityByCity(Long cityId) {
		return commonDao.getLocalityByCity(cityId);
	}

	@Override
	@Transactional
	public String getCurrentUser(String token) {
		User user = commonDao.getCurrentUser(token);
		if (null == user) {
			return null;
		}
		return StringUtils.capitalize(user.getFname()) + " "
				+ StringUtils.capitalize(user.getLname());
	}

}
