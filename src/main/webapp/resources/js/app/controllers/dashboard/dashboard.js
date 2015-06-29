angular.module('hr.dashboard', [
    'hr.dashboard.controller',
    'hr.dashboard.services'
]).config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/dashboard', {
            controller: 'DashBoardController',
            templateUrl: 'dashboard/dashboard.html'
        });
}]);
