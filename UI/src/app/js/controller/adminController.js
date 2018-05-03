(function () {
    'use strict';
    angular.module('hack').controller('adminController', dashboard);
    dashboard.$inject = ['$scope', 'loginService', '$uibModalInstance'];

    function dashboard($scope, loginService, $uibModalInstance) {
        var vm = this;
        loginService.getProdutcs().then(function (result) {
            vm.products = result;
        });
        vm.auctions = [{
            productId: null
            , minPrice: 0
            , startDate: null
            , endDate: null
        }];
        var raw = {
            selectedProduct: null
            , quantity: null
            , startDate: null
            , availableQuality: null
        }
        vm.addRows = function () {
            vm.bid.push(angular.copy(raw));
        };
        vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        }
        vm.save = function () {
            var data = vm.auctions[0];
            var product = null;
            angular.forEach(vm.products, function (obj) {
                if (obj.productId === data.productId) {
                    product = obj;
                }
            })
            product.miniIncPrice = data.miniIncPrice;
            product.bidMinPrice = data.bidMinPrice;
            data.endDate = new Date(data.endDate).getTime();
            data.startDate = new Date(data.startDate).getTime();
            data.minPrice = data.bidMinPrice;
            delete data.bidMinPrice
            delete data.miniIncPrice
            loginService.saveUpcomingBids(data).then(function (res) {
                loginService.updateProduct(product).then(function (result) {
                    $uibModalInstance.dismiss('cancel');
                    location.reload();
                });
            })
        }
    }
})();