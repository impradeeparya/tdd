package in.helloroomie.dao.ad;

import in.helloroomie.domain.ad.Ad;
import in.helloroomie.domain.ad.Image;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.dto.ad.AdDto;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */
public interface IAdDao {
	List<AdDto> fetchByZoneId(Long zoneId);

	List<AdDto> fetchByCityId(List<Zone> zones);

	List<AdDto> fetchByLocalityId(Long localityId);

	List<AdDto> fetchCurrentUserAds(Long userId);

	Long uploadAdImage(Image adImage);

	Boolean postAd(String token, Ad ad);

	Boolean updateStatus(Long adId);
}
