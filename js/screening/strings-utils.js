'use strict';

//Reverse a string, reverse only words of a string, inline implementation of reverse words in a string?
/**
 * Use ECMAScript 6 Features to solve strings related problems
 */
class StringUtils {

  /**
   * Time complexity: O(n)
   * Space complexity: O(n) an additional space (array) is needed, the tmp variable could be omited using XOR.
   *
   * @param {String} s
   * @returns {String} s reversed
   */
  static reverseString(s) {
    let i = 0, tmp = '', arr = s.split(''), j = arr.length - 1;
    while (i < j) {
      tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
      ++i;
      --j;
    }

    return arr.join('');
  }


  /**
   * Time complexity: O(n)
   * Space complexity: O(n) additional space is needed for maps, and array representation.
   *
   * @param {String} s1
   * @param {String} s2
   * @returns {boolean} true if s1 and s2 are anagrams, false otherwise.
   */
  static areAnagrams(s1, s2) {
    // fail fast
    if (s1.length !== s2.length) {
      return false;
    }

    let m1 = {}, m2 = {}, arr1 = s1.toLowerCase().split(''), arr2 = s2.toLowerCase().split(''), l;

    // populate map1 with s1
    for (let i = 0; i < arr1.length; i++) {
      l = arr1[i];
      if (m1[l]) {
        m1[l] +=  1;
      } else {
        m1[l] = 1;
      }
    }

    // populate map2 with s2
    for (let i = 0; i < arr2.length; i++) {
      l = arr2[i];
      if (m2[l]) {
        m2[l] +=  1;
      } else {
        m2[l] = 1;
      }
    }

    // compare values between maps
    for (let i = 0; i < arr1.length; i++) {
      l = arr1[i];
      if (m1[l] !== m2[l]) {
        return false;
      }
    }

    return true;
  }

}

module.exports = StringUtils;