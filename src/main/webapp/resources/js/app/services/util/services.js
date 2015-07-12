/**
 * Created by Pradeep Arya on 7/12/2015.
 */
angular.module('hr.util.services', [])
    .factory('LocalStorage', function () {

        return {
            set: function (key, val) {
                localStorage.setItem(key, val);
            },
            get: function (key) {
                return localStorage.getItem(key);
            },
            remove: function (key) {
                localStorage.removeItem(key);
            }
        }
    })
    .service('UtilServices', function ($http) {
        this.getCurrentUser = function (token) {
            return $http.get('/auth/getCurrentUser');
        }

        this.getAllCities = function () {
            return $http.get("common/getAllCities");
        }

        this.getCityZones = function (cityId) {
            return $http.post("common/getCityZones", cityId);
        }

        this.getLocalitiesByZone = function (zoneId) {
            return $http.post('common/getLocalityByZone', zoneId);
        };

    })
