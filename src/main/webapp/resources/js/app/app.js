/**
 * Created by Pradeep Arya on 7/2/2015.
 */
angular
		.module(
				'hr',
				[ 'ngRoute', 'hr.dashboard', 'hr.ad', 'hr.auth', 'hr.util',
						'ngDialog' ]).config(
				function($httpProvider) {
					$httpProvider.interceptors.push(function(LocalStorage) {
						return {
							request : function(config) {
								config.headers = config.headers || {};
								if (LocalStorage.get('token')) {
									config.headers.Authorization = LocalStorage
											.get('token');
								}
								return config;
							}
						};
					});

				}).run(
				function($rootScope, $location, LocalStorage, UtilServices) {

					$rootScope.$on('$routeChangeStart', function() {
						if (LocalStorage.get('token')
								&& !$rootScope.currentUser) {
							UtilServices.getCurrentUser().then(function(res) {
								if (res.data && (res.data != null)) {
									$rootScope.currentUser = res.data.userName;
								} else {
									LocalStorage.remove('token');
								}
							})
						}

						if ($location.path() == '/ad/post') {
							if (!LocalStorage.get('token')) {
								$location.path('/auth/login');
							}
						} else if ($location.path() == '/logout') {
							$rootScope.currentUser = null;
							LocalStorage.remove('token');
							$location.path('/');
						} else if ($location.path() == '/profile') {
							if (!LocalStorage.get('token')) {
								$location.path('/auth/login');
							}
						}
					})

				})