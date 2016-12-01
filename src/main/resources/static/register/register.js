angular.module('cuisinerating')
  .config(function ($stateProvider) {
    $stateProvider
      .state('register', {
        url: '/register',
        templateUrl: 'register/register.html'
      });
  });