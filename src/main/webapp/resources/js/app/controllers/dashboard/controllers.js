/**
 * Created by Pradeep Arya on 7/2/2015.
 */
angular.module('hr.dashboard.controller', [
    'hr.dashboard.services'
])
    .controller('DashBoardController', function ($scope, $location, DashBoardServices) {
        $scope.selectedCity = "";
        $scope.selectedZone = "";
        $scope.isCitySelected = false;


        DashBoardServices.getAllCities().success(function (data) {
            $scope.cities = data;
        });

        $scope.loadZones = function () {
            $scope.isCitySelected = true
            DashBoardServices.getCityZones($scope.selectedCity.id).success(function (data) {
                $scope.zones = data;
            })
        }

        $scope.searchRoom = function () {
            $location.path('/ad/search')
        }

    });
