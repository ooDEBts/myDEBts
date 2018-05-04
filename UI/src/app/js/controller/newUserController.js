(function () {
    'use strict';
    angular.module('hack').controller('newUserController', newUserFunction);
    newUserFunction.$inject = ['$scope', 'loginService', '$uibModalInstance', 'items'];

    function newUserFunction($scope, loginService, $uibModalInstance, items) {
        var vm = this;
        vm.flag=items.flag;
        vm.title = items.message;
        vm.data = items.data;
        vm.save = function () {
            if (vm.flag == 'Add') {
                loginService.addNewUser(vm.data).then(function (res) {
                    $uibModalInstance.dismiss('close');
                });
            }
            else if (vm.flag == 'Edit') {
                loginService.updateUser({
                    userName: vm.data.userName
                    , password: vm.data.password
                    , name: vm.data.name
                    , email: vm.data.email
                    , contactNo: vm.data.contactNo
                }).then(function () {
                    $uibModalInstance.dismiss('close');
                });
            }
        };
        vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();