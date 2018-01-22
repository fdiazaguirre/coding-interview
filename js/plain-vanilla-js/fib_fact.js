'use strict';

module.exports = function () {
  var Series = {};

  Series.fibonacci = function (n) {
    var memo = [0,1,1];

    // Fail fast
    if (n < 0) return undefined;


    if (memo[n] === undefined) {
      for (var i = 3; i < n + 1; i++) {
        memo[i] = memo[i-1] + memo[i-2];
      }
    }

    return memo[n];
  };

  Series.factorial = function (n) {
    var memo = [1,1,2];

    // Fail fast
    if (n < 0) return undefined;

    if (memo[n] === undefined) {
      for (let i = 3; i < n + 1; i++) {
        memo[i] = memo[i-1] * i;
      }
    }

    return memo[n];

  };

  return Series;
};
