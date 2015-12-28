angular.module('userService', ['ngResource']).
    factory('Users', function($resource)
    {
    	return $resource('rest/users/:userLogin', {});
    }
 );
 angular.module('taskService', ['ngResource']).
     factory('Task', function($resource)
     {
     	return{
     		getTasks:function()
     		{
     			return $resource('rest/task/tasks/:taskID',{},{'save':  {method:'POST', isArray:false}});
            },
            completeTask:function()
            {
                return $resource('rest/task/complete/:taskID',{},{'save':  {method:'POST', isArray:true}})
            }
     	};
     }
  );
   angular.module('processService', ['ngResource']).
       factory('Process', function($resource)
       {
       	return $resource('rest/process/:user:requisicaoVMs',{},{'query':  {method:'GET', isArray:false}});
       }
    );
  angular.module('dataService',[]).
     factory('UserData', function()
     {
        var login=
        {
            login:'',
            pwd:'',
            name:'',
            group:''
        };
     	return {
     	    getLogin:function() {
     	        return login.login;
     	    },
     	    setLogin:function(l){
     	        login.login=l;
     	    },
     	    setPwd:function(p){
     	        login.pwd=p;
     	    },
     	    getPwd:function(){
     	        return login.pwd;
     	    },
     	    setName:function(n){
     	        login.name=n;
     	    },
     	    getName:function(){
     	        return login.name;
     	    },
     	    setGroup:function(g){
     	        login.group=g;
     	    },
     	    getGroup:function(){
     	        return login.group;
     	    },
     	    getUser:function(){ return {"login":login.login,"pwd":login.pwd,"name":login.name,"group":login.group};}
     	};
     }
  );