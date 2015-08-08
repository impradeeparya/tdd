/**
 * Created by Pradeep Arya on 7/5/2015.
 */
angular.module('hr.ad',
		[ 'hr.ad.controller', 'hr.ad.services', 'hr.ad.directives' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/ad/search', {
				controller : 'AdController',
				templateUrl : 'views/ad/ads.html'
			}).when('/ad/post', {
				controller : 'PostAdController',
				templateUrl : 'views/ad/postAd.html'
			}).when('/ad/my', {
				controller : 'AdController',
				templateUrl : 'views/ad/myAds.html'
			})
		} ]);
