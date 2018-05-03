(function () {
    'use strict';
    angular.module('hack').controller('biddingController', bidding);
    bidding.$inject = ['$scope', 'loginService', '$uibModalInstance', 'items'];

    function bidding($scope, loginService, $uibModalInstance, items) {
        var vm = this;
        var user = sessionStorage.getItem('username');
        loginService.findProduct(items.data.productId).then(function (res) {
            vm.data = res;
        });
        // vm.data = items.data;
        vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
        vm.save = function () {
			var aa;
            var data = vm.data;
            var toSave = {
                productId: data.productId
                , biddedAmount: data.biddedAmount
                , biddedBy: user
                , bidDate: new Date().getTime()
                , quantity: data.selQty
                , status: 'Result Awaiting'
            }
            var biddingEndDate = vm.data.endDate;
            var timerDiff = Math.round((biddingEndDate - new Date().getTime()) / 60000);
            loginService.saveUpcomingBids(toSave).then(function (res) {
                if (timerDiff == 5) {
                    vm.data.bidDate = new Date(biddingEndDate).setMinutes(new Date(biddingEndDate).getMinutes() + 5)
                }
                else if (timerDiff == 3) {
                    vm.data.bidDate = new Date(biddingEndDate).setMinutes(new Date(biddingEndDate).getMinutes() + 5)
                }
                else if (timerDiff == 2) {
                    vm.data.bidDate = new Date(biddingEndDate).setMinutes(new Date(biddingEndDate).getMinutes() + 5)
                }
                else if (timerDiff <= 1) {
                    vm.data.bidDate = new Date(biddingEndDate).setMinutes(new Date(biddingEndDate).getMinutes() + 5)
                }
                $uibModalInstance.dismiss('cancel');
                location.reload();
            });
        }
    }
})();