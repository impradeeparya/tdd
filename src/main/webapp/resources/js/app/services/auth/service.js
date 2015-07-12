/**
 * Created by Pradeep Arya on 7/11/2015.
 */

angular.module('hr.auth.services', [])
    .service('AuthServices', function ($http) {

        this.authenticateUser = function (user) {
            return $http.post("auth/login", user);
        }

        this.registerUser = function (user) {
            return $http.post("auth/signup", user);
        }
    })

