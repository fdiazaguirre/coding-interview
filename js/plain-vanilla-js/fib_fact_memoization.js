'use strict';

module.exports = () => {
  let Series = {}, memo;

  /**
   * O(n)
   */
  Series.fibonacciLoop = (n) => {
    let result = 0, temp, offset = 1, num = n;

    while (num > 0) {
      temp = offset;
      offset = offset + result;
      result = temp;
      num--;
    }

    return result;
  };

  /**
   * Memoization implementation
   *
   * time complexity: O(n)
   * extra space complexity: O(n)
   *
   * @param {Number} n
   * @param {Array} memo
   * @returns {Number}
   */
  Series.fibonacci = (n, memo) => {
    memo = memo || [0,1,1];

    // Base case
    if (n <= 0) return 0;
    if (memo[n]) return memo[n];

    memo[n] = Series.fibonacci(n - 1, memo) + Series.fibonacci(n - 2, memo);
    return memo[n];
  };

  /**
   * O(n)
   */
  Series.factorialLoop = (n) => {
    let result = 1, i = 1;

    for (i; i < n + 1; i++) {
      result = result * i;
    }

    return result;
  };

  /**
   * Memoization implementation
   *
   * time complexity: O(n)
   * extra space complexity: O(n)
   *
   * @param {Number} n
   * @param {Array} memo
   * @returns {Number}
   */
  Series.factorial = (n, memo) => {
    memo = memo || [1,1,2];

    // Base case
    if (n <= 1) return 1;

    if (memo[n]) return memo[n];

    memo[n] = n * Series.factorial(n - 1, memo);

    return memo[n];
  };


  return Series;
};
