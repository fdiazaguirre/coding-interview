'use strict';

module.exports = function () {
  var GoogleProblemObject = {};

  /**
   * Time complexity: O(n log n)
   * Space complexity: O(n) - the result array.
   *
   * @param {Array} arr source where to find the pairs.
   * @param {Number} sum that pairs should satisfy.
   *
   * @returns {Array} of {Object} that add up to the sum.
   * this returns all the pairs.
   */
  GoogleProblemObject.getPairsMySolution = function (arr, sum) {
    var result = [],
        i = 0,
        j = arr.length - 1,
        diff;

    // If it's not sorted. O (n log n)
    arr.sort();

    // O(n)
    while ( j > i ) {
      diff = sum - (arr[i] + arr[j]);
      // Found a pair
      if (diff === 0) {
        result.push( {"a":arr[i], "b": arr[j]} );
        i++;
        j--;
      } else if (diff > 0) {
        // Move left pointer to the right.
        i++;
      } else if (diff < 0) {
        // Move right pointer to the left.
        j--;
      }
    }

    return result;
  };

  /**
   * Time complexity: O(n)
   * Space complexity: O(n) - the result array and the complement array.
   * So i
   *
   * @param {Array} arr source where to find the pairs. (unsorted)
   * @param {Number} sum that pairs should satisfy.
   *
   * @returns {Array} of {Object} with pairs that satisfies the sum, otherwise empty Array.
   */
  GoogleProblemObject.getPairsOptimalSolution = function (arr, sum) {
    var comp = {},
        i = 0,
        value,
        diff,
        result = [];

    // O(n)
    for (i; i < arr.length; i++) {
      diff = sum - arr[i];
      value = arr[i];
      // Is the complement
      if (comp[value] === arr[i]) {
        result.push({"a": diff, "b": arr[i]});
      } else {
        comp[diff] = diff;
      }
    }

    return result;
  };

  return GoogleProblemObject;
};
