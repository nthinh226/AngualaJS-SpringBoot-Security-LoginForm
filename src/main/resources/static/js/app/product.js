angular.module('app', [])
        .controller('productController', function ($scope, $http) {
//            $http.get('/get-products').
//                    then(function (response) {
//                        $scope.products = response.data;
//                    });
            $http({
                method: "GET",
                url: "/sampleLogin/get-products",
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
        });