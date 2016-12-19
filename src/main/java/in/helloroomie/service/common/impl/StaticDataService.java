package in.helloroomie.service.common.impl;

import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.city.City;
import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.user.User;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.dto.user.UserDto;
import in.helloroomie.service.common.IStaticDataServices;
import in.helloroomie.util.HelloRoomieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Service
public class StaticDataService implements IStaticDataServices {

    @Autowired
    private ICommonDao commonDao;

    @Override
    @Transactional
    public List<City> fetchAllCities() {
        return commonDao.fetchAllCities();
    }

    @Override
    @Transactional
    public List<Zone> fetchZonesByCity(long cityId) {
        return commonDao.fetchZonesByCity(cityId);
    }

    @Override
    @Transactional
    public List<Locality> fetchLocalitiesByZone(long zoneId) {
        return commonDao.fetchLocalitiesByZone(zoneId);
    }

    @Override
    @Transactional
    public List<Locality> fetchLocalitiesByCity(long cityId) {
        return commonDao.fetchLocalitiesByCity(cityId);
    }

    @Override
    @Transactional
    public UserDto fetchUserByToken(String token) {
        User user = commonDao.fetchUserByToken(token);

        UserDto userDto = null;
        if (null != user) {
            userDto = HelloRoomieUtils.prepareUserDTO(user);
        }
        return userDto;
    }

}
