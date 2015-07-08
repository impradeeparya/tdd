/**
 * Created by Pradeep Arya on 7/5/2015.
 */
angular.module('hr.ad.controller', [
    'hr.ad.services'
])
    .controller('AdController', function ($scope, $routeParams, $location, AdServices) {

        $scope.adsList = null;
        AdServices.getAllZoneAds($routeParams.zoneId).success(function (data) {
            $scope.adsList = data;
        })

        AdServices.getAllLocalityOfZone($routeParams.zoneId).success(function (data) {
            $scope.localities = data;
        });

    });

