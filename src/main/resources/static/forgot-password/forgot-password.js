angular.module('cuisinerating')
  .config(function ($stateProvider) {
    $stateProvider
      .state('forgot', {
        url: '/forgot',
        templateUrl: 'forgot-password/forgot-password.html'
      });
  });