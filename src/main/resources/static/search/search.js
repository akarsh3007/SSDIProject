angular.module('cuisinerating')
  .config(function ($stateProvider) {
    $stateProvider
      .state('search', {
        url: '/search',
        sp: {
            authenticate: true
          },
        templateUrl: 'search/search.html'
      });
  });