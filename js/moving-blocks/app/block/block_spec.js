describe('BlockCtrl', function(){
    beforeEach(module('csWeb'));

    var $controller, controller;

    beforeEach(inject(function(_$controller_){
        // The injector unwraps the underscores (_) from around the parameter names when matching
        $controller = _$controller_;
    }));

    it('ignore illegal movements', function() {
        var $scope = {};
        controller = $controller('BlockCtrl', { $scope: $scope });

        // Fails due to type checking.
        expect($scope.isValid('2', 1, 3)).toBeFalsy();
        // Fails due to src equals dst.
        expect($scope.isValid(2, 2, 3)).toBeFalsy();
        // Fails due to size checking.
        expect($scope.isValid(2, 4, 2)).toBeFalsy();
    });

    it('pile block for legal moves', function() {
        // Given.
        var $scope = {},
            input = "4\nmove 0 to 1\nmove 2 to 1\nmove 3 to 1\n",
            expectedOutput = "0->\n1->1,0,2,3\n2->\n3->\n";
        controller = $controller('BlockCtrl', { $scope: $scope });

        // When.
        $scope.parse(input);

        // Then.
        expect($scope.output).toEqual(expectedOutput);
    });

    it('unpile before move block', function () {
        // Given.
        var $scope = {},
            input = "4\nmove 0 to 1\nmove 1 to 3\n",
        // block zero is move back to it's original position.
            expectedOutput = "0->0\n1->\n2->2\n3->3,1\n";
        controller = $controller('BlockCtrl', { $scope: $scope });

        // When.
        $scope.parse(input);

        // Then.
        expect($scope.output).toEqual(expectedOutput);
    });
});