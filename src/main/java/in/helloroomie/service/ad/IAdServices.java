package in.helloroomie.service.ad;

import in.helloroomie.dto.ad.AdDto;
import in.helloroomie.dto.ad.AdImageDto;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */
public interface IAdServices {
    List<AdDto> fetchByZoneId(long zoneId);

    List<AdDto> fetchByCityId(long cityId);

    List<AdDto> fetchByLocalityId(long localityId);

    List<AdDto> fetchCurrentUserAds(String token);

    long uploadImage(String imageName, byte[] imageData);

    Boolean postAd(String token, AdImageDto adImageDto);

    Boolean updateStatus(long adId, char status);
}
