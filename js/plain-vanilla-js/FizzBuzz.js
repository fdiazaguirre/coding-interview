'use strict';

class FizzBuzz {
  const cases = [3,5,7,9,15,36];

  /**
   * @param {Number} int integer that is being used to decide what would be the print.
   */
  answer(int) {
    for (c of cases) {
      if (int % c === 0) { c.print(); }
    }
  }
}