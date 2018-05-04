(function () {
    'use strict';
    angular.module('hack').controller('productController', product);
    product.$inject = ['$scope', 'loginService', '$uibModalInstance', 'items'];

    function product($scope, loginService, $uibModalInstance, items) {
        var vm = this;
        vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();