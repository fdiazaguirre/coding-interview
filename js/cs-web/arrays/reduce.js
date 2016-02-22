/**
 * Created by fdiazaguirre on 2/21/16.
 */
(function () {
    'use strict';

    var nums = [1,2,3,4,5,6,7,8,9,10];

    function add(total, current) {
        return total + current;
    };

    console.log(nums.reduce(add));

})();
