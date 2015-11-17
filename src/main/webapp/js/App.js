var app = angular.module("VivoApp",['ngRoute','userService']).config(
        [ '$httpProvider', '$routeProvider', '$locationProvider', function($httpProvider, $routeProvider, $locationProvider) {
            /*
             * Use a HTTP interceptor to add a nonce to every request to prevent MSIE from caching responses.
             */
            $httpProvider.interceptors.push('ajaxNonceInterceptor');
            $routeProvider.
            // if URL fragment is /home, then load the home partial, with the
            // MembersCtrl controller
            when('/login', {
                templateUrl : 'templates/login.html',
                controller : LoginCtrl
            // Add a default route
            }).otherwise({
                redirectTo : '/login'
            });
        } ]);
    app.factory('ajaxNonceInterceptor', function() {
        // This interceptor is equivalent to the behavior induced by $.ajaxSetup({cache:false});

        var param_start = /\?/;

        return {

            request : function(config) {
                if (config.method == 'GET') {
                    // Add a query parameter named '_' to the URL, with a value equal to the current timestamp
                    config.url += (param_start.test(config.url) ? "&" : "?") + '_=' + new Date().getTime();
                }
                return config;
            }
        }
    });