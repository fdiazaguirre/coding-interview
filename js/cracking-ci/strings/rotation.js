'use strict';

module.exports = () => {
  let Rotation = {};


  Rotation.haveSameLetters = (s1, s2) => {
    let m1 = [], m2 = [];

    // Get s1 letters
    for (let i = 0; i < s1.length; i++) {
      if (!m1[s1[i]]) {
        m1[s1[i]] = 1;
      } else {
        m1[s1[i]] += 1;
      }
    }

    // Get s2 letters
    for (let i = 0; i < s2.length; i++) {
      if (!m2[s2[i]]) {
        m2[s2[i]] = 1;
      } else {
        m2[s2[i]] += 1;
      }
    }

    // Compare both maps
    for (let i = 0; i < s1.length; i++) {
      let letter = s1[i];
      if (m1[letter] !== m2[letter]) {
        return false;
      }
    }

    return true;
  },

  Rotation.haveDiffOrder = (s1, s2) => {
    for (let i = 0; i < s1.length; i++) {
      if (s1[i] !== s2[i]) {
        return true;
      }
    }

    return false;
  },

  /**
   * Time complexity: O(n)
   * Extra Space complexity: O(n), due to the use of maps
   * 
   * @param {String} s1
   * @param {String} s2
   * @return {Boolean} true when the strings have the exact match of occurrences of the same letters, false otherwise. 
   */
  Rotation.isRotation = (s1, s2) => {
    if (!s1 || !s2 || s1.length !== s2.length || s1.length < 2 || s2.length < 2) {
      return false;
    } else {
      return Rotation.haveSameLetters(s1, s2) && Rotation.haveDiffOrder(s1, s2);
    }
  }

  return Rotation;
};