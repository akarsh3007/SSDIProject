angular.module('cuisinerating')
  .config(function ($stateProvider) {
    $stateProvider
      .state('search', {
        url: '/search',
        templateUrl: 'search/search.html'
      });
  });