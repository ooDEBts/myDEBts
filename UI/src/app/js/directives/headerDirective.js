"use strict";
angular.module('hack').directive('hackHeader', ['messageService', '$uibModal', '$location', function (messageService, $uibModal, $location) {
    return {
        scope: {}
        , templateUrl: 'app/views/header.html'
        , link: function (scope) {
            scope.logout = function () {
                $location.path('/');
            };
            scope.profile = function () {
                $uibModal.open({
                    animation: true
                    , templateUrl: '/app/views/newUser.html'
                    , controller: 'newUserController'
                    , controllerAs: 'newUserCtrl'
                    , backdrop: 'static'
                    , size: 'md'
                    , resolve: {
                        items: function () {
                            return {
                                flag: 'Edit'
                                , message: 'Profile Details'
                                , data: {}
                            };
                        }
                    }
                });
            }
        }
    };
}]);