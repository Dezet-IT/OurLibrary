'use strict';

// Creating angular Application with module name "OurLibrary"
var app = angular.module('OurLibrary',[]);

app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}]);