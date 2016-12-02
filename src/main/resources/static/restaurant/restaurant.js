angular.module('cuisinerating')
  .config(function ($stateProvider) {
    $stateProvider
      .state('restaurant', {
        url: '/restaurant/:restId',
        templateUrl: 'html/RestaurantDetails.html',
        controller: 'cuisineController',
        resolve:{
        	restaurant: function($stateParams,cuisineService)
        		{
        			return cuisineService.getCuisinesDishes($stateParams.restId);
        	
        		}
        }
      });
  });