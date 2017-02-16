angular.module('microservicesSampleApp', [ 'ngRoute', 'ngResource' ]).config(
		function($routeProvider, $locationProvider) {

			$routeProvider.when('/', {
				templateUrl : 'partials/home.html',
				controller : 'MicroservicesSampleController'
			}).when('/one/', {
				templateUrl : 'partials/home.html',
				controller : 'MicroservicesSampleController'
			}).when('/two/', {
				templateUrl : 'partials/home.html',
				controller : 'MicroservicesSampleController'
			}).when('/three/', {
				templateUrl : 'partials/home.html',
				controller : 'MicroservicesSampleController'
			}).otherwise({
				redirectTo : '/'
			});

			// use the HTML5 History API
			$locationProvider.html5Mode(true);
		});
