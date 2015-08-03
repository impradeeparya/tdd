/**
 * Created by Pradeep Arya on 7/2/2015.
 */
angular.module('hr.dashboard.controller', [ 'hr.dashboard.services' ])
		.controller(
				'DashBoardController',
				function($scope, $location, DashBoardServices, UtilServices) {
					$scope.selectedCity = null;
					$scope.selectedZone = null;
					$scope.isCitySelected = false;

					UtilServices.getAllCities().success(function(data) {
						$scope.cities = data;
					});

					$scope.loadZones = function() {
						$scope.isCitySelected = false
						$scope.selectedZone = null;
						$scope.zones = null;
						UtilServices.getZonesByCity($scope.selectedCity.id)
								.success(function(data) {
									$scope.zones = data;
									$scope.isCitySelected = true
								})
					}

					$scope.searchRoom = function() {

						if (null != $scope.selectedZone) {
							$location.path("/ad/search").search({
								zoneId : $scope.selectedZone.id
							});
						} else if (null != $scope.selectedCity) {
							$location.path("/ad/search").search({
								cityId : $scope.selectedCity.id
							});
						}
					}

				});
