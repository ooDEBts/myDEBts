(function () {
    'use strict';
    angular.module('hack').controller('LoginController', LoginController);
    LoginController.$inject = ['$scope', '$location', 'loginService', '$uibModal'];

    function LoginController($scope, $location, loginService, $uibModal) {
        var me = this;
        me.err = false;
        me.login = function () {
            // $location.path('/dashboard');
            me.err = false;
            loginService.login({
                contact: me.username
                , password: me.password
            }).then(function (result) {
                if (result.status === 'User valid') {
                    sessionStorage.setItem('username', result.userName);
                    sessionStorage.setItem('role', result.role);
                    $location.path('/dashboard');
                }
                else {
                    me.err = "Invalid username/password combination";
                }
            }, function (error) {
                me.err = "Something went wrong!!";
            });
        };
        me.signUp = function () {
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
                            flag: 'Add'
                            , message: 'Add New user'
                            , data: {}
                        };
                    }
                }
            });
        };
    }
})();