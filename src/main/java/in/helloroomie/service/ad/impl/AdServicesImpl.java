package in.helloroomie.service.ad.impl;

import in.helloroomie.dao.ad.IAdDao;
import in.helloroomie.domain.ad.Ad;
import in.helloroomie.dto.ad.AdDto;
import in.helloroomie.service.ad.IAdServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Service
public class AdServicesImpl implements IAdServices {

    @Autowired
    private IAdDao adDao;

    @Override
    @Transactional
    public List<AdDto> getByZoneId(Long zoneId) {
        return adDao.getByZoneId(zoneId);
    }

    @Override
    @Transactional
    public Boolean postAd(String token, Ad ad) {
        return adDao.postAd(token, ad);
    }
}
