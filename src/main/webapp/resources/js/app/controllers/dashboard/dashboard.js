/**
 * Created by Pradeep Arya on 7/2/2015.
 */
angular.module('hr.dashboard', [
    'hr.dashboard.controller',
    'hr.dashboard.services'
]).config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            controller: 'DashBoardController',
            templateUrl: 'views/dashboard/dashboard.html'
        });
}]);
