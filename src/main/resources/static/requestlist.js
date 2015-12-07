app.controller("requestlist", function($scope, $http, $location , $window) {

    $scope.quotationRequest = [
        {   'reqid':'7',
            'car':'Chevrolet Camaro  2015',
            'valuation': 28000000,
            'status': 'Sent',
            'receivedCount' : 0},
        {  'reqid':'8',
            'car':'Kia Picanto  2012',
            'valuation': 2200000,
            'status': 'received'
            ,'receivedCount' : 9},
    ];

    //$scope.addRow = function(){
    //    $scope.companies.push({ 'name':$scope.name, 'employees': $scope.employees, 'headoffice':$scope.headoffice });
    //    $scope.name='';
    //    $scope.employees='';
    //    $scope.headoffice='';
    //};

    $scope.selectRow = function(reqid){

        var index = -1;
        var comArr = eval( $scope.quotationRequest );
        for( var i = 0; i < comArr.length; i++ ) {
            if( comArr[i].reqid === reqid ) {
                index = i;
                break;
            }
        }
        if( index === -1 ) {
            alert( "Something gone wrong" );
        }
        //$http({
        //    method  : 'POST',
        //    url     : '/pricelist',
        //    data    : $scope.quotationRequest[index], //forms user object
        //    headers : {'Content-Type': 'application/x-www-form-urlencoded'}
        //}).submit

        //alert("Selected row :- " + $scope.quotationRequest[index].car.toString())

        ////$location.path('../pricelist')
        if(index == 0)
        {
            $window.location.href = '/showQuotations2';
        }
        else
        {
            $window.location.href = '/showQuotations1';
        }

    };



    //$scope.removeRow = function(name){
    //    var index = -1;
    //    var comArr = eval( $scope.companies );
    //    for( var i = 0; i < comArr.length; i++ ) {
    //        if( comArr[i].name === name ) {
    //            index = i;
    //            break;
    //        }
    //    }
    //    if( index === -1 ) {
    //        alert( "Something gone wrong" );
    //    }
    //    $scope.companies.splice( index, 1 );
    //};


});