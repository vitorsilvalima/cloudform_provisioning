function LoginCtrl($scope,Users,$location) 
{
	$scope.login={};
	$scope.logIn=function()
	{
		$scope.login.name="";
		$scope.login.group="";
		console.log($scope.login);
		console.log(Users.query());
		Users.save($scope.login, function(data) 
		{
			console.log(data);
			if(data.status)
			{
				console.log("Successfully logged on the system");
				$location.path("#/requisicao")
			}
			else
			{
				console.log("Login or password is incorrect, try again!!!");
			}
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
function CartCtrl($scope) 
{
    $scope.removeItem = function(index) 
    {
        $scope.cart.items.splice(index, 1);
    };
    $scope.addItem = function() {
        $scope.cart.items.push({
            qtd: "",
            cpu: '',
            memory: "",
            so:""
        });
    };
	$scope.memory = [{ value: 2}, { value: 4}, { value: 8}, { value: 16}, { value: 32}];
	$scope.cpu= [{ value: 1}, { value: 2}, { value: 4}, { value: 8}];	
	$scope.so = [{ value: "RHEL 6"}, { value: "RHEL 7"}, { value: "Microsoft Server 2008"}, { value: "Microsoft Server 2012"}];	
	$scope.cart={
			 items:[{}] 
			};
}