package in.helloroomie.controllers.ad;

import in.helloroomie.domain.ad.Ad;
import in.helloroomie.dto.ad.AdDto;
import in.helloroomie.dto.ad.AdImageDto;
import in.helloroomie.service.ad.IAdServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Controller
@RequestMapping(value = "/ad")
public class AdController {

	@Autowired
	private IAdServices adServices;

	@RequestMapping(value = "/getByZoneId", method = RequestMethod.POST)
	public @ResponseBody List<AdDto> getByZoneId(@RequestBody Long zoneId) {
		return adServices.getByZoneId(zoneId);
	}

	@RequestMapping(value = "/getByCityId", method = RequestMethod.POST)
	public @ResponseBody List<AdDto> getByCityId(@RequestBody Long cityId) {
		return adServices.getByCityId(cityId);
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean postAd(
			@RequestHeader("Authorization") String token,
			@RequestBody AdImageDto adImageDto) {
		System.out.println(adImageDto);
		Ad ad = adImageDto.prepareAd();
		return adServices.postAd(token, ad);
	}

	@RequestMapping(value = "/uploadRoomImages", method = RequestMethod.POST)
	public @ResponseBody List<Long> uploadRoomImages(
			MultipartHttpServletRequest request) {
		List<Long> uploadFileIds = new ArrayList<Long>();
		Iterator<String> itr = request.getFileNames();

		while (itr.hasNext()) {
			MultipartFile multipartFile = request.getFile(itr.next());
			try {
				multipartFile.getBytes();
				uploadFileIds.add(adServices.postAdImage(
						multipartFile.getOriginalFilename(),
						multipartFile.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return uploadFileIds;
	}

	@RequestMapping(value = "/getCurrentUserAds", method = RequestMethod.GET)
	public @ResponseBody List<AdDto> getCurrentUserAds(
			@RequestHeader("Authorization") String token) {
		return adServices.getCurrentUserAds(token);
	}

	@RequestMapping(value = "/updateAdStatus", method = RequestMethod.POST)
	public @ResponseBody Boolean updateAdStatus(@RequestBody Long adId) {
		return adServices.updateAdStatus(adId);
	}

}
