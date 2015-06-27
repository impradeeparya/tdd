angular.module('hr.dashboard', [
    'hr.dashboard.controller',
    'hr.dashboard.services'
]).config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            controller: 'DashBoardController',
            templateUrl: 'dashboard'
        });
}]);
