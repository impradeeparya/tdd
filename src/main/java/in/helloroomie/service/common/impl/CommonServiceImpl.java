package in.helloroomie.service.common.impl;

import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.city.CityDTO;
import in.helloroomie.service.common.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Service
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private ICommonDao commonDao;

    @Override
    public List<CityDTO> getAllCities() {
        return commonDao.getAllCities();
    }
}
