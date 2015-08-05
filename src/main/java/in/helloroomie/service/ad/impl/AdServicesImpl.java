package in.helloroomie.service.ad.impl;

import in.helloroomie.dao.ad.IAdDao;
import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.ad.Ad;
import in.helloroomie.domain.user.User;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.dto.ad.AdDto;
import in.helloroomie.service.ad.IAdServices;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Service
public class AdServicesImpl implements IAdServices {

	@Autowired
	private IAdDao adDao;

	@Autowired
	private ICommonDao commonDao;

	@Override
	@Transactional
	public List<AdDto> getByZoneId(Long zoneId) {
		return adDao.getByZoneId(zoneId);
	}

	@Override
	@Transactional
	public List<AdDto> getByCityId(Long cityId) {
		List<Zone> zones = commonDao.getZonesByCity(cityId);
		return adDao.getByCityId(zones);
	}

	@Override
	@Transactional
	public Boolean postAd(String token, Ad ad) {
		return adDao.postAd(token, ad);
	}

	@Override
	@Transactional
	public List<AdDto> getCurrentUserAds(String token) {
		User user = commonDao.getCurrentUser(token);
		return adDao.getCurrentUserAds(user.getId());
	}
}
