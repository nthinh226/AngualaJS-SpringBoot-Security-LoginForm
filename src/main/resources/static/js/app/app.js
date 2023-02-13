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
//            $http.get('/get-products').
//                    then(function (response) {
//                        $scope.products = response.data;
//                    });

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
//                let closeLoader = setTimeout(function () {
//                    document.getElementById("loaderInnerList").style.display = "none";
//                    clearTimeout(closeLoader);
//                }, 100);

        }, function (error) {
            console.log(error);
        });
//            $scope.selectRow = function (item) {
//                console.log('Selected item: ' + item);
//            };

//        $scope.openModal = function (product) {
//            $scope.selectedProduct = product;
//            console.log(product);
////
//            $("#productModal").modal("show");
////                    var modalInstance = $uibModal.open({
////                        templateUrl: '/products.html',
////                        scope: $scope
////                    });
//
//        };

        $scope.openModal = function (product) {
            console.log(product)
            $scope.selectedProduct = product;
            
            var modalInstance = $uibModal.open({
                templateUrl: "product-modal",
                controller: "ModalContentCtrl",
                size: '',
                scope: $scope
            });

            modalInstance.result.then(function (response) {
                $scope.result = `${response} button hitted`;
            });

        };
    }]);