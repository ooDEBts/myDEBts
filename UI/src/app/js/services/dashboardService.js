angular.module('hack').service('dashboardService', function ($http, $q) {   
    this.getBids=function(){
        var deft = $q.defer();
        $http.get('/api/getAllBid').then(function (res) {
            deft.resolve(res.data)
        }, function (err) {
            deft.reject(err);
        });
        return deft.promise;
    }
    
});