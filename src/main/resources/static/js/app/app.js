var app = angular.module('app', ['ui.bootstrap']);

app.controller('ModalContentCtrl', function ($scope, $uibModalInstance) {

    $scope.ok = function () {
        $uibModalInstance.close("Ok");
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss();
    };

});

app.controller('productController', ['$scope', '$uibModal', '$http', function ($scope, $uibModal, $http) {

        $http({
            method: "GET",
            url: "/get-products",
            headers: {
                'Content-type': 'application/json;charset=utf-8',
                'Accept': 'application/json'
            }
        }).then(function (res) {
            console.log(res);
            $scope.products = res.data;
        }, function (error) {
            console.log(error);
        });
        
        $scope.openModal = function (product) {
            $scope.selectedProduct = product;
            
            var modalInstance = $uibModal.open({
                templateUrl: "product-modal",
                controller: "ModalContentCtrl",
                size: '',
                scope: $scope
            });

        };
    }]);