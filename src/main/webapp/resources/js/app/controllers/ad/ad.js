/**
 * Created by Pradeep Arya on 7/5/2015.
 */
angular.module('hr.ad', [
    'hr.ad.controller',
    'hr.ad.services'
]).config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/ad/search', {
            controller: 'AdController',
            templateUrl: 'views/ad/ads.html'
        });
}]);
