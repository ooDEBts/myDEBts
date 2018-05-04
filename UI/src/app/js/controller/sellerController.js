(function () {
    'use strict';
    angular.module('hack').controller('sellerController', dashboard);
    dashboard.$inject = ['$scope', 'loginService', '$uibModalInstance', 'items'];

    function dashboard($scope, loginService, $uibModalInstance, items) {
        var vm = this;
        vm.products = items.data;
        vm.intervals = [];
        angular.forEach(vm.products, function (obj) {
            var st = new Date(obj.startDate);
            var stFormat = st.getFullYear() + '/' + st.getUTCMonth() + '/' + st.getDay() + ' ' + st.getHours() + ':' + st.getMinutes();
            var end = new Date(obj.endDate);
            var endFormat = end.getFullYear() + '/' + end.getUTCMonth() + '/' + end.getDay() + ' ' + end.getHours() + ':' + end.getMinutes();
            vm.intervals.push({
                productId: obj.productId
                , time: stFormat + ' - ' + endFormat
                , start: obj.startDate
            })
        })
        vm.bid = [{}];
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
            var data = vm.bid;
            angular.forEach(vm.auctions, function (obj) {
                obj.endDate = new Date(obj.endDate).getTime();
                obj.startDate = new Date(obj.startDate).getTime();
            });
            loginService.saveUpdatedBid(data[0]).then(function (res) {
                $uibModalInstance.dismiss('cancel');
                location.reload()
            });
        }
    }
})();