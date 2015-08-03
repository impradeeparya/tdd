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

	this.postAd = function(ad) {
		return $http.post("ad/post", ad);
	}
})
