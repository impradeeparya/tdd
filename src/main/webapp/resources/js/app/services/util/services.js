/**
 * Created by Pradeep Arya on 7/12/2015.
 */
angular.module('hr.util.services', []).factory('LocalStorage',function () {

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
}).service('UtilServices', function ($http) {
        this.getCurrentUser = function () {
            return $http.get('user');
        }

        this.getAllCities = function () {
            return $http.get("cities");
        }

        this.getZonesByCity = function (cityId) {
            return $http.get("/city/" + cityId + "/zones");
        }

        this.getLocalitiesByZone = function (zoneId) {
            return $http.get("/zone/" + zoneId + "/localities");
        }

        this.getLocalitiesByCity = function (cityId) {
            return $http.get("/city/" + cityId + "/localities");
        }

    })
