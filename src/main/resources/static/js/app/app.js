angular.module('app', []).controller('BookController', function($http) {
	var vm = this;
	function refreshData() {
		$http({
			method : 'GET',
			url : 'book'
		}).then(function success(response) {
			vm.books = response.data;
			console.log(vm.books);
		}, function error(response) {
			console.log('API error ' + response.status);
		});
	}

	vm.addBook = function(book) {
		$http({
			method : 'POST',
			url : 'book/add',
			data : book
		}).then(function success(response) {
			refreshData();
			vm.book = {};
		}, function error(response) {
			console.log('Data not saved ' + book);
		});
	}

	vm.appName = 'Book Manager';
	refreshData();
});