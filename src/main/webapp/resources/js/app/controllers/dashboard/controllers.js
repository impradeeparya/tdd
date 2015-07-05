/**
 * Created by Pradeep Arya on 7/2/2015.
 */
angular.module('hr.dashboard.controller', [
    'hr.dashboard.services'
])
    .controller('DashBoardController', function ($scope, DashBoardServices) {
        $scope.selectedCity = "";
        $scope.selectedZone = "";


        DashBoardServices.getAllCities().success(function (data) {
            $scope.cities = data;
        });

        $scope.loadZones = function () {
            DashBoardServices.getCityZones($scope.selectedCity.id).success(function (data) {
                $scope.zones = data;
            })
        }

    });
