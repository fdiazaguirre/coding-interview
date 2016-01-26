describe('Blocks world', function () {
    var controller;

    beforeEach(function() {
        controller = new BlocksController();
    });

    describe('when a movement is being validated', function () {
        it('ignore illegal movements', function() {
            expect(controller.isValid(2,2)).toBeFalsy();
        });

        it('accept legal movements', function() {
            expect(controller.isValid(3,7)).toBeTruthy();
        });
    });

   describe('when the positions are created', function () {
        it('should create exact 25 positions as default , with one stack each', function () {
            var i = 0;
            var pos = controller.getAllPositions();
            expect(pos.length).toEqual(25);
            for (; i < 25; i++) {
             expect(pos[i]).toBeDefined();
            }
        });
        it('should use the constructor value when it is specified', function () {
            controller = new BlocksController(8);
            var pos = controller.getAllPositions();
            expect(pos.length).toEqual(8);
        });
    });

   describe('when move from a to b', function () {
       it('should succeed when the move is valid', function () {
            // Given.
            controller = new BlocksController(3);
            var a = 0, b = 1;            
            // When.
            controller.move(a,b);
            // Then.
            expect(controller.move(0,1)).toBeTruthy();
        });
   });
});
