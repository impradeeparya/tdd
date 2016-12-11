package in.helloroomie.service.common.impl;

import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.city.City;
import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.user.User;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.dto.user.UserDto;
import in.helloroomie.service.common.ICommonServices;
import in.helloroomie.util.HelloRoomieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public UserDto getCurrentUser(String token) {
        User user = commonDao.getCurrentUser(token);

        UserDto userDto = null;
        if (null != user) {
            userDto = HelloRoomieUtils.prepareUserDTO(user);
        }
        return userDto;
    }

}
