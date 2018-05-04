(function () {
    'use strict';
    angular.module('hack').controller('dashboardController', dashboard);
    dashboard.$inject = ['$scope', 'dashboardService', '$uibModal', '$interval'];

    function dashboard($scope, dashService, $uibModal, $interval) {
        var vm = this;
        vm.role = sessionStorage.getItem('role');
        var user = sessionStorage.getItem('username');
        console.log('In the dashboard');
        vm.products = [];
        dashService.getBids().then(function (result) {
            var CurrentBid = []
                , userBid = []
                , upComing = [];
            angular.forEach(result, function (obj) {
                obj.img='../app/resources/images/example.jfif';
                var newDate = new Date().getTime();
                if (newDate >= obj.startDate && newDate <= obj.endDate && user !== obj.biddedBy) {
                    CurrentBid.push(obj);
                }
                else if (user === obj.biddedBy) {
                    userBid.push(obj);
                }
                else if (newDate < obj.startDate) {
                    upComing.push(obj);
                }
            })
            vm.bidArray=CurrentBid;
             vm.biddedArray=userBid;
            vm.products=upComing;
        });
        vm.openBid = function (arg) {
            $uibModal.open({
                animation: true
                , templateUrl: '/app/views/biddingView.html'
                , controller: 'biddingController'
                , controllerAs: 'bid'
                , backdrop: 'static'
                , size: 'md'
                , resolve: {
                    items: function () {
                        return {
                            message: arg ? arg.name + 'Bidding' : null
                            , data: angular.copy(arg)
                        };
                    }
                }
            });
        }
        vm.openSeller = function () {
            $uibModal.open({
                animation: true
                , templateUrl: '/app/views/sellerProfile.html'
                , controller: 'sellerController'
                , controllerAs: 'seller'
                , backdrop: 'static'
                , size: 'md'
                , resolve: {
                    items: function () {
                        return {
                            data: vm.products
                        };
                    }
                }
            });
        };
        vm.openAdmin = function () {
            $uibModal.open({
                animation: true
                , templateUrl: '/app/views/adminView.html'
                , controller: 'adminController'
                , controllerAs: 'admin'
                , backdrop: 'static'
                , size: 'md'
                , resolve: {
                    items: function () {
                        return {
                            message: null
                        };
                    }
                }
            });
        }
    }
})();