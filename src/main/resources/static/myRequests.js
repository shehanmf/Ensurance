app.controller("myRequests", function($scope, $http) {
	$http.get("http://localhost:8080/rest/quotationrequest/findbycurrentuser")
	.success(function(data) {
		$scope.requests = data;
		alert($scope.requests);
	});
	
});