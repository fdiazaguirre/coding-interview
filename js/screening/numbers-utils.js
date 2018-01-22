'use strict';

class NumberUtils {

  /**
   *
   * @param {Array} numbers
   * @returns {Number} max sub-sequence found
   */
  static findLongestConsecutiveSubseq(numbers) {
    let mid = Math.floor(numbers.length / 2);

    console.log(mid);
    //(numbers[mid] + 1) === numbers[mid + 1]
    console.log((numbers[mid - 1] - 1) === numbers[mid]);

    // if () {
    //   return 3;
    // }
    return 3;
  }
}

module.exports = NumberUtils;