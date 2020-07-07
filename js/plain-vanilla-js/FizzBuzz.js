'use strict';

// Paul Irish ternary solution
function fizzBuzzTernary(n) {
  for (let i = 1; i <= n; i++) {
    let f = i % 3 === 0, b = i % 5 === 0;
    console.log(f ? b ? 'FizzBuzz' : 'Fizz' : b ? 'Buzz' : i);
  }
}

function fizzBuzzIterative(n) {
  for (let i = 0; i <= n; i++) {
    if (i % 15 === 0)
      console.log("FizzBuzz");
    else if (i % 3 === 0)
      console.log("Fizz");
    else if (i % 5 === 0)
      console.log("Buzz");
    else
      console.log(i);
  }
}

module.exports = {
  fizzBuzzTernary,
  fizzBuzzIterative
}