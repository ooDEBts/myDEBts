angular.module('hack').service('loginService', function ($http, $q) {
    this.login = function (details) {
        var deft = $q.defer();
        $http.post('/api/login', details).then(function (res) {
            deft.resolve(res.data)
        }, function (err) {
            deft.reject(err);
        });
        return deft.promise;
    };
    this.getProdutcs = function () {
        var deft = $q.defer();
        $http.get('/api/getProducts').then(function (res) {
            deft.resolve(res.data)
        }, function (err) {
            deft.reject(err);
        });
        return deft.promise;
    }; 
    this.findProduct = function (data) {
        var deft = $q.defer();
        $http.get('/api/findProduct?name=' + data).then(function (res) {
            deft.resolve(res.data)
        }, function (err) {
            deft.reject(err);
        });
        return deft.promise;
    };
    this.addNewUser = function (details) {
        var deft = $q.defer();
        $http.post('/api/saveUser', details).then(function (res) {
            deft.resolve(res.data)
        }, function (err) {
            deft.reject(err);
        });
        return deft.promise;
    };
    this.getUserBids = function (data) {
        var deft = $q.defer();
        $http.get('' + data).then(function (res) {
            deft.resolve(res.data)
        }, function (err) {
            deft.reject(err);
        });
        return deft.promise;
    };
    this.updateProduct = function (data) {
        var deft = $q.defer();
        $http.post('/api/updateProduct', data).then(function (res) {
            deft.resolve(res.data)
        }, function (err) {
            deft.reject(err);
        });
        return deft.promise;
    };
    this.saveUpcomingBids = function (data) {
        var deft = $q.defer();
        $http.post('/api/saveBid', data).then(function (res) {
            deft.resolve(res.data)
        }, function (err) {
            deft.reject(err);
        });
        return deft.promise;
    } 
    this.saveUpdatedBid = function (data) {
        var deft = $q.defer();
        $http.post('/api/updateSellerBid', data).then(function (res) {
            deft.resolve(res.data)
        }, function (err) {
            deft.reject(err);
        });
        return deft.promise;
    }
});