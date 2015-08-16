/**
 * Created by Pradeep Arya on 7/5/2015.
 */
angular
		.module('hr.ad.controller', [ 'hr.ad.services' ])
		.controller(
				'AdController',
				function($scope, $routeParams, $location, AdServices,
						UtilServices, ngDialog) {
					$scope.adsList = null;
					$scope.myAds = null;
					$scope.zoneId = $routeParams.zoneId;
					$scope.cityId = $routeParams.cityId;

					if ($scope.zoneId) {
						getAllZoneAds();
						getLocalitiesByZone();
					}

					if ($scope.cityId) {
						getAllCityAds();
						getLocaclitiesByCity();
					}

					function getAllZoneAds() {
						AdServices.getAllZoneAds($scope.zoneId).success(
								function(data) {
									$scope.adsList = data;
								})
					}

					function getLocalitiesByZone() {
						UtilServices.getLocalitiesByZone($routeParams.zoneId)
								.success(function(data) {
									$scope.localities = data;
								});
					}

					function getAllCityAds() {
						AdServices.getAllCityAds($scope.cityId).success(
								function(data) {
									$scope.adsList = data;
								})
					}

					function getLocaclitiesByCity() {
						UtilServices.getLocalitiesByCity($scope.cityId)
								.success(function(data) {
									$scope.localities = data;
								});
					}

					$scope.getLocalityAds = function(localityId) {

						if (localityId) {
							AdServices.getLocalityAds(localityId).success(
									function(data) {
										$scope.adsList = data;
									});
						} else {
							if ($scope.zoneId) {
								getAllZoneAds();
								getLocalitiesByZone();
							}

							if ($scope.cityId) {
								getAllCityAds();
								getLocaclitiesByCity();
							}
						}
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

				})
		.controller(
				'MyAdsController',
				function($scope, AdServices) {

					$scope.myAds = [];
					getCurrentUserAds();

					function getCurrentUserAds() {
						AdServices.getCurrentUserAds().success(function(data) {
							$scope.myAds = data;
						});
					}

					$scope.updateAdStatus = function(adId) {
						AdServices
								.updateAdStatus(adId)
								.success(
										function(res) {

											if (true == res) {
												var updatedAds = angular
														.copy($scope.myAds);
												for (var index = 0; index < $scope.myAds.length; index++) {
													if (updatedAds[index].id == adId) {
														updatedAds[index].isActive = !updatedAds[index].isActive;
														break;
													}
												}
												angular.copy(updatedAds,
														$scope.myAds);
											}

										});
					}

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
							UtilServices.getLocalitiesByZone($scope.zone.id)
									.then(function(res) {
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
						console.log($scope.ad)
						var images = new FormData();
						/*
						 * angular.forEach($scope.roomImages, function(image) {
						 * images.append(image.name, image); });
						 * AdServices.uploadRoomImages(images).success(
						 * function(res) { $scope.imageIds = res;
						 * AdServices.postAd($scope.ad, $scope.imageIds)
						 * .success(function(data) { console.log(data); }) });
						 */

					};

				})
