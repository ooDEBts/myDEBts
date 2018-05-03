angular.module('hack').directive('dateTimePicker', function () {
    return {
        restrict: 'E'
        , replace: true
        , scope: {
            ngModel: '='
        }
        , template: '<div class="control-group input-append date form_datetime">' + '<input type="text" class="form-control" readonly data-date-format="yyyy-mm-dd hh:ii" name="transactionDate" ng-model="ngModel" data-date-time required>' + '<span class="add-on"><em class="icon-remove"></em></span>' + '<span class="add-on"><em class="icon-th"></em></span>' + '</div>'
        , link: function (scope, element, attrs, ngModel) {
            var input = element.find('input');
            element.datetimepicker({
                format: "yyyy-mm-ddThh:ii:ssZ"
                , showMeridian: true
                , autoclose: true
                , todayBtn: true
                , pickerPosition: 'bottom-left'
            });
            element.bind('blur keyup change', function () {
                scope.$apply(read);
            });

            function read() {
                scope.ngModel = input.val();
            }
        }
    }
});