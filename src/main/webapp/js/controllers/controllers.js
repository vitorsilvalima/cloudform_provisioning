function LoginCtrl($scope,Users,$location,UserData)
{
	$scope.login={};
	$scope.logIn=function()
	{
		//$scope.login.name="";
		//$scope.login.group="";
		Users.save($scope.login, function(data) 
		{
			if(data.status)
			{
				UserData.setLogin($scope.login.login);
				UserData.setName(data.name);
				UserData.setPwd($scope.login.pwd);
				UserData.setGroup(data.group);
				console.log(UserData.getName() + " is now logged on the system"+UserData.getLogin());
				$location.path("#/requisicao");
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
function InboxCtrl($scope,Task,UserData)
{
	Task.getTasks().save(UserData.getUser(), function(data)
											{
												$scope.tasks=data.tasks;
												// $scope.$apply();
											}, function(result) {
												   if ((result.status == 409) || (result.status == 400)) {
													   $scope.errors = result.data;
												   } else {
													   $scope.errorMessages = [ 'Unknown  server error' ];
												   }
											});
	var completeTask=function(index)
	{
		Task.completeTask().save($scope.tasks[index], function(data)
        											{
        												console.log(data);
        											}, function(result) {
        												   if ((result.status == 409) || (result.status == 400)) {
        													   $scope.errors = result.data;
        												   } else {
        													   $scope.errorMessages = [ 'Unknown  server error' ];
        												   }
        											});
         $scope.tasks.splice(index, 1);
	};
	$scope.aceitarItem=function(index)
	{
		console.log($scope.tasks[index]);
		$scope.tasks[index].approval=true;
		completeTask(index);
	}
	$scope.rejeitarItem=function(index)
	{
		console.log($scope.tasks[index]);
		$scope.tasks[index].approval=false;
		completeTask(index);
	}
}
function CartCtrl($scope,Process,UserData)
{
    console.log(UserData.getName());
    $scope.removeItem = function(index) 
    {
        $scope.cart.items.splice(index, 1);
    };
    $scope.addItem = function() {
        $scope.cart.items.push({
            quantidade_vm: "",
            numero_vcpus: '',
            quantidade_ram: "",
            so:""
        });
    };
    $scope.requisitar=function()
    {
    	console.log($scope.cart.items);
    	console.log(UserData.getUser());
    	var RequisicaoData={};
            RequisicaoData.listRequisicao=$scope.cart.items;
            RequisicaoData.numero_projeto=$scope.cart.numeroProjeto;
            RequisicaoData.extra_info=$scope.cart.extraInfo;
            RequisicaoData.cliente=UserData.getName();
     	var ProcessRequest={};
     	    ProcessRequest.user=UserData.getUser();
     	    ProcessRequest.requisicaoData=RequisicaoData;
    	Process.save(ProcessRequest, function(data)
        		{
        			console.log(data);
                }, function(result) {
                    if ((result.status == 409) || (result.status == 400)) {
                        $scope.errors = result.data;
                    } else {
                        $scope.errorMessages = [ 'Unknown  server error' ];
                    }
                });
    };
	$scope.quantidade_ram = [{ value: 2}, { value: 4}, { value: 8}, { value: 16}, { value: 32}];
	$scope.numero_vcpus = [{ value: 1}, { value: 2}, { value: 4}, { value: 8}];
	$scope.so = [{ value: "RHEL 6"}, { value: "RHEL 7"}, { value: "Microsoft Server 2008"}, { value: "Microsoft Server 2012"}];	
	$scope.cart={
			 items:[{}]
			};
}