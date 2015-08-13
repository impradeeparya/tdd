package in.helloroomie.dao.ad.impl;

import in.helloroomie.dao.ad.IAdDao;
import in.helloroomie.domain.ad.Ad;
import in.helloroomie.domain.ad.Image;
import in.helloroomie.domain.user.User;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.dto.ad.AdDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Repository
public class AdDaoImpl implements IAdDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<AdDto> getByZoneId(Long zoneId) {
		Criteria criteria = createCriteria(Ad.class);
		criteria.createAlias("locality", "l");
		criteria.add(Restrictions.eq("l.zone.id", zoneId));
		criteria.add(Restrictions.eq("isActive", true));
		return prepareAdDtoList(criteria.list());
	}

	@Override
	public List<AdDto> getByCityId(List<Zone> zones) {
		Criteria criteria = createCriteria(Ad.class);
		criteria.createAlias("locality", "l");
		criteria.add(Restrictions.in("l.zone", zones));
		criteria.add(Restrictions.eq("isActive", true));
		return prepareAdDtoList(criteria.list());
	}

	@Override
	public Boolean postAd(String token, Ad ad) {

		Boolean result = false;

		Criteria userCriteria = createCriteria(User.class);
		userCriteria.add(Restrictions.eq("token", token));
		User user = (User) userCriteria.uniqueResult();

		if (null != user) {
			if (null != ad.getLocality()) {
				ad.setUser(user);
				Date currentDate = new Date();
				ad.setCreatedOn(currentDate);
				ad.setUpdatedOn(currentDate);
				ad.setIsActive(true);
				saveAd(ad);
				result = true;
			}
		}

		return result;
	}

	@Override
	public List<AdDto> getCurrentUserAds(Long userId) {
		Criteria criteria = createCriteria(Ad.class);
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.id", userId));
		return prepareAdDtoList(criteria.list());
	}

	@Override
	public Boolean updateAdStatus(Long adId) {
		Criteria criteria = createCriteria(Ad.class);
		criteria.add(Restrictions.eq("id", adId));
		Ad ad = (Ad) criteria.uniqueResult();
		if (null != ad) {
			if (ad.getIsActive()) {
				ad.setIsActive(false);
			} else {
				ad.setIsActive(true);
			}
		}
		updateAd(ad);
		return true;
	}

	@Override
	public Long postAdImage(Image adImage) {
		return saveAdImage(adImage);
	}

	private void saveAd(Ad ad) {
		getCurrentSession().save(ad);
	}

	private Long saveAdImage(Image adImage) {
		return (Long) getCurrentSession().save(adImage);
	}

	private void updateAd(Ad ad) {
		getCurrentSession().saveOrUpdate(ad);
	}

	private Criteria createCriteria(Class className) {
		return getCurrentSession().createCriteria(className);
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	private List<AdDto> prepareAdDtoList(List<Ad> ads) {
		List<AdDto> adDtoList = new ArrayList<AdDto>();

		for (Ad ad : ads) {
			AdDto adDto = new AdDto();
			adDto.setId(ad.getId());
			adDto.setTitle(ad.getTitle());
			adDto.setDescription(ad.getDescription());
			adDto.setLocalityName(ad.getLocality().getName());
			adDto.setZoneName(ad.getLocality().getZone().getName());
			adDto.setCityName(ad.getLocality().getZone().getCity().getName());
			adDto.setRent(ad.getRent());
			adDto.setRoom(String.valueOf(ad.getNumberOfRooms()));
			adDto.setPostedOn(ad.getUpdatedOn());
			adDto.setAllowedTo(ad.getAllowedTo());
			adDto.setIsActive(ad.getIsActive());
			adDto.setAdvertiser(ad.getUser());

			List<byte[]> images = new ArrayList<byte[]>();
			for (Image image : ad.getImage()) {
				images.add(image.getImageData());
			}
			adDto.setImages(images);
			adDtoList.add(adDto);
		}
		return adDtoList;
	}

}
