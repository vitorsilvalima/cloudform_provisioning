function LoginCtrl($scope,Users) 
{
	$scope.logIn=function()
	{
		console.log($scope.login);
		console.log(Users.query());
	}
}