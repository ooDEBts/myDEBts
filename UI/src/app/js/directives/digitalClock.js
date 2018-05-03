angular.module('hack').directive("digitalClock", function ($timeout, dateFilter) {
    return function (scope, element, attrs) {
        element.addClass('clock');
        scope.updateClock = function () {
            // if (!scope.data.isBidded) {
            $timeout(function () {
                element.text(dateFilter(new Date(scope.data.endDate - new Date().getTime()), 'hh:mm:ss'));
                scope.updateClock();
            }, 1000);
        };
        scope.updateClock();
    };
});