angular.module('cuisinerating')
  .config(function ($stateProvider) {
    $stateProvider
      .state('profile', {
        url: '/profile',
        templateUrl: 'profile/profile.html',
        controller: 'ProfileCtrl',
        /**
         * The Stormpath Angular SDK provides a configuration block that informs
         * UI router about protected routes.  When we use `authenticate: true`,
         * the user will be redirected to the login page if they try to access
         * this view but are not logged in.
         */
        sp: {
          authenticate: true
        }
      });
  })
  .controller('ProfileCtrl', function ($scope, $http, $timeout, $user) {
   $scope.user = $scope.$root.user;
  });