package in.helloroomie.service.common.impl;

import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.city.City;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.service.common.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Service
public class CommonServiceImpl implements ICommonService {

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
}
