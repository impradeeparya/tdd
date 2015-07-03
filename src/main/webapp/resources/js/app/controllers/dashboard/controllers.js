/**
 * Created by Pradeep Arya on 7/2/2015.
 */
angular.module('hr.dashboard.controller', [
    'hr.dashboard.services'
])
    .controller('DashBoardController', function ($scope, DashBoardServices) {
        DashBoardServices.getAllCities().success(function (data) {
            $scope.cities = data;
            console.log("Cites : " + $scope.cities);
        });
    });
