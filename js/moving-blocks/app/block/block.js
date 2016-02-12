'use strict';

var blocksApp = angular.module('myApp.block', []);

blocksApp.controller('BlockCtrl', function ($scope) {

    $scope.parse = function (input) {
        var str = input.toString();
        var re = /[^\r\n]+/g;
        var m = str.match(re);
        var size = m[0], pos = [], index = 0;
        for (index; index < size; index++) {
            pos[index] = [index];
        };
        var a, b, i = 1, l = m.length, line = '';
        for (i; i < l; i++) {
            line = m[i].split(' ');
            //TODO: VALIDATE LINES USING REGEX.
            a = parseInt(line[1]);
            b = parseInt(line[3]);
            if ($scope.isValid(a, b, size)) {
                // Is a valid move
                var j = 0, e;
                // If there are more values stacked in that position move them back to their original place.
                e = parseInt(pos[a].pop());
                while (e !== a) {
                    pos[e] = [e];
                    e = pos[a].pop();
                }
                pos[a] = [];
                pos[b].push(a);
            }
        };
        var aux = '', result = '', r = 0, s = '', t = 0;
        for (r; r < size; r++) {
            if (!pos[r]) {
                s = '';
            } else {
                s = pos[r];
            }
            aux = r.toString().concat('->').concat(s).concat('\n');
            result = result.concat(aux);

        }

        $scope.output = result;
    };

    $scope.isValid = function (src, dst, size) {
        return (typeof src === 'number' && typeof dst === 'number') && (src !== dst) && (src < size && dst < size);
    };
});