/**
 * Created by Pradeep Arya on 7/5/2015.
 */
angular.module('hr.ad.controller', [ 'hr.ad.services' ]).controller(
		'AdController',
		function($scope, $routeParams, $location, AdServices, UtilServices,
				ngDialog) {
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
			$scope.updateAdStatus = function(adId) {
				AdServices.updateAdStatus(adId).success(function(res) {
					if (true == res) {
						currentUserAds();
					}
				});
			}

			$scope.contactInformationPopup = function(advertiser) {
				$scope.popupInfo = advertiser;
				ngDialog.open({
					template : 'views/ad/_contactInfoPopup.html',
					className : 'ngdialog-theme-default',
					showClose : true,
					closeByEscape : true,
					closeByDocument : true,
					name : 'Contact Information',
					scope : $scope
				});
			}

		}).controller('MyAdsController', function($scope, AdServices) {

	AdServices.getCurrentUserAds().success(function(data) {
		$scope.myAds = data;
	})
}).controller(
		'PostAdController',
		function($scope, UtilServices, AdServices) {

			$scope.ad = {};
			$scope.roomImages;

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

			$scope.postAd = function() {
				$scope.ad.locality = $scope.locality;
				var images = new FormData();
				angular.forEach($scope.roomImages, function(image) {
					images.append(image.name, image);
				});
				AdServices.uploadRoomImages(images).success(
						function(res) {
							$scope.imageIds = res;
							AdServices.postAd($scope.ad, $scope.imageIds)
									.success(function(data) {
										console.log(data);
									})
						});

			};

		})
