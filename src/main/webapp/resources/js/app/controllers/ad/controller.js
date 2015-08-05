/**
 * Created by Pradeep Arya on 7/5/2015.
 */
angular.module('hr.ad.controller', [ 'hr.ad.services' ]).controller(
		'AdController',
		function($scope, $routeParams, $location, AdServices, UtilServices) {
			$scope.adsList = null;
			$scope.myAds = null;
			if ($routeParams.zoneId) {
				AdServices.getAllZoneAds($routeParams.zoneId).success(
						function(data) {
							$scope.adsList = data;
						})

				UtilServices.getLocalitiesByZone($routeParams.zoneId).success(
						function(data) {
							$scope.localities = data;
						});
			}

			if ($routeParams.cityId) {
				AdServices.getAllCityAds($routeParams.cityId).success(
						function(data) {
							$scope.adsList = data;
						})

				UtilServices.getLocalitiesByCity($routeParams.cityId).success(
						function(data) {
							$scope.localities = data;
						});
			}
			currentUserAds();
			$scope.updateAdStatus = function(adId) {
				AdServices.updateAdStatus(adId).success(function(res) {
					if (true == res) {
						currentUserAds();
					}
				});
			}

			function currentUserAds() {
				AdServices.getCurrentUserAds().success(function(data) {
					$scope.myAds = data;
				})
			}

		}).controller(
		'PostAdController',
		function($scope, UtilServices, AdServices) {

			$scope.ad = {};

			$scope.city = {};
			$scope.zone = {};
			$scope.locality = {};

			$scope.showLocation = false;
			$scope.showZone = false;

			UtilServices.getAllCities().then(function(res) {
				$scope.cities = res.data;
			});

			$scope.loadZones = function() {
				if (!$scope.showZone) {
					$scope.showZone = true;
				}
				if ($scope.city) {
					UtilServices.getZonesByCity($scope.city.id).then(
							function(res) {
								$scope.zones = res.data
							})
				} else {
					$scope.zones = {};
					$scope.showZone = false;
				}
				$scope.zone = {};
				$scope.localities = {};
				$scope.locality = {};
				$scope.showLocation = false;
			};

			$scope.loadLocalities = function() {
				if (!$scope.showLocation) {
					$scope.showLocation = true;
				}
				if ($scope.zone) {
					UtilServices.getLocalitiesByZone($scope.zone.id).then(
							function(res) {
								$scope.localities = res.data
							})
				} else {
					$scope.localities = {};
					$scope.showLocation = false;
				}
				$scope.locality = {};
			};

			/*
			 * function uploadFile(adId) { var file = $scope.myFile;
			 * console.log('file is ' + JSON.stringify(file)); var uploadUrl =
			 * "/ad/upload/" + adId; fileUpload.uploadFileToUrl(file,
			 * uploadUrl); };
			 */

			$scope.postAd = function() {
				$scope.ad.locality = $scope.locality;
				console.log($scope.ad);
				AdServices.postAd($scope.ad).success(function(data) {
					console.log(data);
				})
			};

		})
