package in.helloroomie.dao.ad;

import in.helloroomie.dto.ad.AdDto;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */
public interface IAdDao {
    List<AdDto> getByZoneId(Long zoneId);
}
