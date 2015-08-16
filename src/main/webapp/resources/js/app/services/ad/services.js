/**
 * Created by Pradeep Arya on 7/5/2015.
 */
angular.module('hr.ad.services', []).service('AdServices', function($http) {

	this.getAllZoneAds = function(zoneId) {
		return $http.post("ad/getByZoneId", zoneId);
	}

	this.getAllCityAds = function(cityId) {
		return $http.post("ad/getByCityId", cityId);
	}

	this.getLocalityAds = function(localityId) {
		return $http.post("ad/getByLocalityId", localityId);
	}

	this.postAd = function(ad, imageIds) {
		return $http.post("ad/post", {
			ad : ad,
			imageIds : imageIds
		});
	}

	this.uploadRoomImages = function(roomImages) {
		return $http.post('ad/uploadRoomImages', roomImages, {

			withCredentials : false,

			headers : {
				'Content-Type' : undefined
			},
			transformRequest : angular.identity

		});
	}

	this.getCurrentUserAds = function() {
		return $http.get("ad/getCurrentUserAds");
	}

	this.updateAdStatus = function(adId) {
		return $http.post("ad/updateAdStatus", adId);
	}
})
