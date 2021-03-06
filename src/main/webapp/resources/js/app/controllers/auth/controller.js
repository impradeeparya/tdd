/**
 * Created by Pradeep Arya on 7/11/2015.
 */

angular
		.module('hr.auth.controller',
				[ 'hr.auth.services', 'hr.util.services' ]).controller(
				'AuthController',
				function($scope, $location, $rootScope, AuthServices,
						LocalStorage) {

					$scope.user = {};
					$scope.validUser = false;

					$scope.authenticateUser = function() {
						AuthServices.authenticateUser($scope.user).success(
								function(data) {
									$scope.validUser = data.isValidUser;
									if ($scope.validUser == true) {
										LocalStorage.set('token',
												data.userToken);
										$rootScope.currentUser = data.userName;
										$location.path('/');
									} else {
										LocalStorage.remove('token');
										$rootScope.currentUser = "";
									}
								});
					}

				}).controller(
				'SignUpController',
				function($scope, $location, AuthServices) {
					$scope.user = {}

					$scope.signUp = function() {
						AuthServices.registerUser($scope.user).then(
								function(data) {
									if (data == true) {
										$location.path('/');
									}
								});
					};

				}).controller(
				'UserController',
				function($scope, $location, UtilServices, AuthServices) {
					$scope.passwords = {};
					UtilServices.getCurrentUser().success(function(data) {
						$scope.user = data;
					});

					$scope.updatePassword = function() {
						AuthServices.updatePassword($scope.passwords).success(
								function(res) {
									console.log(res);
								});
					}
				})
