/**
 * Created by Pradeep Arya on 7/5/2015.
 */
angular.module('hr.ad.services', []).service('AdServices', function ($http) {

    this.getAllZoneAds = function (zoneId) {
        return $http.get("ad/zone/" + zoneId);
    }

    this.getAllCityAds = function (cityId) {
        return $http.get("ad/city/" + cityId);
    }

    this.getLocalityAds = function (localityId) {
        return $http.get("ad/locality/" + localityId);
    }

    this.postAd = function (ad, imageIds) {
        return $http.post("ad", {
            ad: ad,
            imageIds: imageIds
        });
    }

    this.uploadRoomImages = function (roomImages) {
        return $http.post('ad/uploadRoomImages', roomImages, {

            withCredentials: false,

            headers: {
                'Content-Type': undefined
            },
            transformRequest: angular.identity

        });
    }

    this.getCurrentUserAds = function () {
        return $http.get("ad");
    }

    this.updateAdStatus = function (adId, status) {
        return $http.post("ad/" + adId + "/" + status);
    }
})
