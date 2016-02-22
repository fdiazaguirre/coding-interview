/**
 * Created by fdiazaguirre on 2/22/16.
 */
(function () {
    'use strict';

    var nums = [3,1,2,100,4,200];
    var names = ["David","Mike","Cynthia","Clayton","Bryan","Raymond"];

    console.log("sort works well for strings: " + names.sort());
    console.log("... but not quite for numbers, since sorts data lexicographically " + nums.sort());

    function compare(n1, n2) {
        return n1 - n2;
    }

    console.log("So let's try passing the compare method as a criteria " + nums.sort(compare));
})();