angular.module('userService', ['ngResource']).
    factory('Users', function($resource){
  return $resource('rest/users/:userLogin', {});
});