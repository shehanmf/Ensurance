app.controller("requestQuotation", function($scope, $http) {
	
	$http.get("http://localhost:8080/rest/masterdata/listvehiclecategories")
	.success(function(data) {
		$scope.vehicalCategories = data;
	});
	
	$http.get("http://localhost:8080/rest/masterdata/listinsuarancetypes")
	.success(function(data) {
		$scope.types = data;
	});
	

	$scope.years = [ '2000', '2001', '2002' ];
	
	$scope.selectedCategory;
	$scope.selectedType;
	
	

	$scope.reset = function() {
		$scope.quotationRequest={
				vehicleCategory : $scope.vehicalCategories[0],
				insuaranceType : $scope.types[0],
				year : null,
				value : 0
			};
	}
	
	$scope.convertToInt = function(id){
	    return parseInt(id, 10);
	};

	$scope.submitQuatation = function() {
		$scope.quotationRequest={
				vehicleCategory : {id:$scope.selectedCategory, name:''},
				insuaranceType : {id:$scope.selectedType, name:''},
				year : null,
				value : 0
			};
		
		alert($scope.quotationRequest.vehicleCategory+" "+$scope.quotationRequest.insuaranceType+" "+$scope.quotationRequest.year+" "+$scope.quotationRequest.value);
		$http.post("http://localhost:8080/rest/quotationrequesteservice/requestquotations",
				$scope.quotationRequest)
//		alert("aaa");
//		$http.get("http://localhost:8080/devday/rest/quotation/test")
//				.success(function(data) {
//					$scope.vehicleCategory = 0;
//				}).error(function(data) {
//					alert("ddd");
//				});
//		// alert("ccc");
//		 $http.post("http://localhost:8080/devday/rest/quotation/create",
//		 $scope.quatation).success(function(data){alert(data);});
	}

	$scope.lastName = "Doe";
});