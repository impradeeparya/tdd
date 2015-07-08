/**
 * Created by Pradeep Arya on 7/5/2015.
 */
angular.module('hr.ad.services', [])
    .service('AdServices', function ($http) {

        this.getAllZoneAds = function (zoneId) {
            return $http.post("ad/getByZoneId", zoneId);
        }
        this.getAllLocalityOfZone = function(zoneId){
            return $http.post("common/getLocalityByZone", zoneId);
        }
    })
