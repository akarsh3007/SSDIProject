angular.module('cuisinerating')
  .config(function ($stateProvider) {
    $stateProvider
      .state('verify', {
        url: '/verify?sptoken',
        templateUrl: 'verify-email/verify-email.html'
      });
  });