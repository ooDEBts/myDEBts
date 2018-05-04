(function () {
    'use strict';
    angular.module('hack').config(routeConfig);

    function routeConfig($locationProvider, $routeProvider) {
        $routeProvider.when('/dashboard', {
            esolve: {
                "check": function ($location) {
                    if (!sessionStorage.getItem('username')) {
                        $location.path('/');
                    }
                }
            }
            , templateUrl: 'app/views/dashboard.html'
            , controller: 'dashboardController'
            , controllerAs: 'dash'
        }).when('/bid', {
            resolve: {
                "check": function ($location) {
                    if (!sessionStorage.getItem('username')) {
                        $location.path('/');
                    }
                }
            }
            , templateUrl: ''
            , controller: ''
            , controllerAs: ''
        }).when('/', {
            templateUrl: 'app/views/login.html'
            , controller: 'LoginController'
            , controllerAs: 'login'
        }).otherwise({
            redirectTo: '/'
        });
        $locationProvider.html5Mode(true);
    }
})();