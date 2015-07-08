package in.helloroomie.service.ad;

import in.helloroomie.dto.ad.AdDto;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */
public interface IAdServices {
    List<AdDto> getByZoneId(Long zoneId);
}
