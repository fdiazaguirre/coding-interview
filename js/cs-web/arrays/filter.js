/**
 * Created by fdiazaguirre on 2/21/16.
 */
(function () {
    'use strict';
    var nums = [], i = 0, evens, odds;

    for (; i < 20; ++i) {
        nums[i] = i+1;
    }

    function isEven(num) {
        return num % 2 === 0;
    }

    function isOdd(num) {
        return num % 2 !== 0;
    }

    evens = nums.filter(isEven);
    odds = nums.filter(isOdd);
    console.log("Even numbers: " + evens);
    console.log("Odd numbers: " + odds);
    console.log("Are some of the numbers of nums array even? -> " + nums.some(isEven));
    console.log("Are some of the numbers of nums array odd? -> " + nums.some(isOdd));
    console.log("Are all the numbers of evens array really even? -> " + evens.every(isEven));
    console.log("Are all the numbers of odds array really odd? -> " + odds.every(isOdd));
})();