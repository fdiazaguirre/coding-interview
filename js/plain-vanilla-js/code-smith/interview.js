// declare a variable called "numArr" which is an array containing the numbers 1, 2, and 3. then print it to the console

var numArr = [1,2,3]

// console.log(numArr);

// define a function "multiplyBy2" that takes one number, multiplies it by 2, and returns that value

function multiplyBy2(number) {
  return number * 2;
}

// console.log(multiplyBy2(3));

// define a function "distanceFrom10" that takes one number and returns its distance from 10. the output should be greater than or equal to zero (e.g. passing 8 or 12 should both return a positive 2)

function distanceFrom10(x) {
  return Math.abs(10-x);
}

// console.log(distanceFrom10(12));

// define a function "map" which takes two arguments, an array and a callback function. "map" will iterate/loop through the array and pass each array element to the callback as an argument. Each output from the callback is pushed to a new array. "map" will return this new array. Please do not use the native .map() method.

function map(arr, callback) {
  let resultArr = [];
  for (let i = 0; i < arr.length; i++) {
    resultArr.push(callback(arr[i]));
  }

  return resultArr;
}

// use your "map" to find the distance from 10 of each number in numArr

// console.log(map(numArr, distanceFrom10));

// define a function called "every" which takes two arguments, an array and a callback function. this callback can be considered a "test", as it will return true or false. "every" will iterate/loop through the array and pass each array element to the callback as an argument. if all outputs from the callback/test are true, every will return true. if any of the outputs is false, every will return false. Please do not use the native .every() method.


function every(arr, callback) {
  for (let i = 0; i < arr.length; i++) {
    if (callback(arr[i]) === false) {
      return false;
    }
  }

  return true;
}

// use your "every" to determine if every number in numArr is greater than 0. Then, run a second test with the array [1, -2, 3]
function isPositive(num) {
  return num > 0;
}

// console.log(every(numArr, isPositive));
// console.log(every([1, -2, 3], isPositive));

// refactor your "every" function so that it uses the built-in "reduce" method.

function everyRefactored(arr, callback) {

  return arr.reduce(function (result, value) { return result && callback(value); } , true);
}

// console.log(everyRefactored(numArr, isPositive));
// console.log(everyRefactored([1, -2, 3], isPositive));

// define a function "fastCache" that takes one argument, a function, and returns a function. When invoked, fastCache creates a cache that tracks calls to the returned function, where each input is associated with its output. Every subsequent call to that returned function with the same argument will return the output directly from the cache, instead of invoking the original function again.

// define a function "fastCache" that takes one argument, a function, and returns a function. When invoked, fastCache creates a cache that tracks calls to the returned function, where each input is associated with its output. Every subsequent call to that returned function with the same argument will return the output directly from the cache, instead of invoking the original function again.

function fastCache (fn) {
  let m = {};

  const innerFn = (arg) => {
    if (!m[arg]) {
      console.log('Not cached!');
      m[arg] = fn(arg);
    } else {
      console.log('caching the call!');
    }

    return m[arg];
  }

  return innerFn;
}

const fnBody = fastCache(multiplyBy2);
const run1 = fnBody(3);
const run2 = fnBody(3);

console.log(run1);
console.log(run2);