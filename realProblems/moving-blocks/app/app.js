'use strict';

// Declare app level module which depends on views, and components
var blocksApp = angular.module('myApp', [
    'ngRoute',
    'myApp.block'
]);

blocksApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/block', {
            templateUrl: 'block/view.html',
            controller: 'BlockCtrl'
        })
        .otherwise({redirectTo: '/block'});
    ;
}]);
