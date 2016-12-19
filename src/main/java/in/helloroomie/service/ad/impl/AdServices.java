package in.helloroomie.service.ad.impl;

import in.helloroomie.dao.ad.IAdDao;
import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.ad.Ad;
import in.helloroomie.domain.ad.Image;
import in.helloroomie.domain.user.User;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.dto.ad.AdDto;
import in.helloroomie.dto.ad.AdImageDto;
import in.helloroomie.service.ad.IAdServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Service
public class AdServices implements IAdServices {

    @Autowired
    private IAdDao adDao;

    @Autowired
    private ICommonDao commonDao;

    @Override
    @Transactional
    public List<AdDto> fetchByZoneId(long zoneId) {
        return adDao.fetchByZoneId(zoneId);
    }

    @Override
    @Transactional
    public List<AdDto> fetchByCityId(long cityId) {
        List<Zone> zones = commonDao.fetchZonesByCity(cityId);
        return adDao.fetchByCityId(zones);
    }

    @Override
    @Transactional
    public Boolean postAd(String token, AdImageDto adImageDto) {
        Ad ad = adImageDto.prepareAd();
        return adDao.postAd(token, ad);
    }

    @Override
    @Transactional
    public List<AdDto> fetchCurrentUserAds(String token) {
        User user = commonDao.fetchUserByToken(token);
        return adDao.fetchCurrentUserAds(user.getId());
    }

    @Override
    @Transactional
    public Boolean updateStatus(long adId, char status) {
        return adDao.updateStatus(adId);
    }

    @Override
    @Transactional
    public long uploadImage(String imageName, byte[] imageData) {
        Image adImage = new Image();
        adImage.setImageName(imageName);
        adImage.setImageData(imageData);
        return adDao.uploadAdImage(adImage);
    }

    @Override
    @Transactional
    public List<AdDto> fetchByLocalityId(long localityId) {
        return adDao.fetchByLocalityId(localityId);
    }
}
