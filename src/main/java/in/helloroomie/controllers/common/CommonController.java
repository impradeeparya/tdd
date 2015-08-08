package in.helloroomie.controllers.common;

import in.helloroomie.domain.city.City;
import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.user.User;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.dto.user.UserDto;
import in.helloroomie.service.common.ICommonServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Controller
@RequestMapping(value = "/common")
public class CommonController {

	@Autowired
	private ICommonServices commonServices;

	@RequestMapping(value = "/getAllCities", method = RequestMethod.GET)
	public @ResponseBody List<City> getAllCities() {
		return commonServices.getAllCities();
	}

	@RequestMapping(value = "/getZonesByCity", method = RequestMethod.POST)
	public @ResponseBody List<Zone> getZonesByCity(@RequestBody Long zoneId) {
		return commonServices.getZonesByCity(zoneId);
	}

	@RequestMapping(value = "/getLocalityByZone", method = RequestMethod.POST)
	public @ResponseBody List<Locality> getLocalityByZone(
			@RequestBody Long zoneId) {
		return commonServices.getLocalityByZone(zoneId);
	}

	@RequestMapping(value = "/getLocalityByCity", method = RequestMethod.POST)
	public @ResponseBody List<Locality> getLocalityByCity(
			@RequestBody Long cityId) {
		return commonServices.getLocalityByCity(cityId);
	}

	@RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
	public @ResponseBody UserDto getCurrentUser(
			@RequestHeader(value = "Authorization") String token) {
		return commonServices.getCurrentUser(token);
	}
}
