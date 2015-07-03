/**
 * Created by Pradeep Arya on 7/2/2015.
 */
angular.module('hr.dashboard.services', [])
    .service('DashBoardServices', function ($http) {

        this.getAllCities = function () {
            return $http.get("common/getAllCities");
        }
    })