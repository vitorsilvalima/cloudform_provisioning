function LoginCtrl($scope,Users,$location) 
{
	$scope.login={};
	$scope.logIn=function()
	{
		$scope.login.name="Vitor";
		$scope.login.group="user";
		console.log($scope.login);
		console.log(Users.query());
		Users.save($scope.login, function(data) {
            // Update the list of members
           // $scope.refresh();
            // Clear the form 
         //   $scope.reset();
            // mark success on the registration form
			console.log(data);
            $scope.successMessages = [ 'Member Registered' ];
        }, function(result) {
            if ((result.status == 409) || (result.status == 400)) {
                $scope.errors = result.data;
            } else {
                $scope.errorMessages = [ 'Unknown  server error' ];
            }
        });
	}
}
function MenuCtrl($scope) 
{
	$scope.changeActive=function(menuId)
	{
		if(menuId==2)
		{
			$scope.class2="active";
			$scope.class1="";
			$scope.showDetails = ! $scope.showDetails;
		}
		else
		{
			$scope.class1="active";
			$scope.class2="";
			$scope.showDetails = ! $scope.showDetails;
		}
	}
	$scope.class1="active";
	$scope.showDetails=true;
}