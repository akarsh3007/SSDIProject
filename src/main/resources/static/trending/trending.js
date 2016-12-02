angular.module('cuisinerating')
  .config(function ($stateProvider) {
    $stateProvider
      .state('trending', {
        url: '/trending',
        templateUrl: 'trending/trending.html'
      });
  });