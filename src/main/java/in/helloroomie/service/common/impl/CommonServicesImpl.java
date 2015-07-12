package in.helloroomie.service.common.impl;

import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.city.City;
import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.service.common.ICommonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<Zone> getCityZones(Long cityId) {
        return commonDao.getCityZones(cityId);
    }

    @Override
    @Transactional
    public List<Locality> getLocalityByZone(Long zoneId) {
        return commonDao.getLocalityByZone(zoneId);
    }

    @Override
    @Transactional
    public String getCurrentUser(String token) {
        return commonDao.getCurrentUser(token);
    }
}
