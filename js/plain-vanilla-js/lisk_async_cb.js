'use strict';

/**
 * Synchronous version of taskA and taskB are given.
 * Please rewrite them to asynchronous version - every function receives a callback as the last argument.
 */

/**
 * Accepts a number and returns a number
 * @param {number} a
 * @param {Function} cb
 * @returns {number}
 */
function foo (a, cb) {
  // ...
}

/**
 * Accepts a number and returns a number
 * @param {number} a
 * @param {number} b
 * @param {Function} cb
 * @returns {number}
 */
function bar (a, b, cb) {

}

/**
 * Synchronous version of task A
 * @param {number} input
 * @returns {number}
 */
function taskA (input) {
  return foo(input) / bar(input, 0);
}

function taskAsync (input, cb) {
  return cb(foo(input) / bar(input, 0));
}