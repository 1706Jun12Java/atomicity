var timeApp = angular.module('timeApp', []);

timeApp.controller('TimeCtrl', function TimeCtrl($scope, $timeout) {
	var tick = function() {
		$scope.clock = Date.now()
		$timeout(tick, $scope.tickInterval);
	}
	$timeout(tick, 1000);
})