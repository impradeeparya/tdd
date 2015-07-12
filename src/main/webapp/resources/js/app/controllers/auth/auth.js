/**
 * Created by Pradeep Arya on 7/11/2015.
 */

angular.module('hr.auth', [
    'hr.auth.controller',
    'hr.auth.services'
]).config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/auth/login', {
            controller: 'AuthController',
            templateUrl: 'views/auth/login.html'
        });
}]);
