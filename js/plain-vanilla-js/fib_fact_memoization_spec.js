'use strict';

const path = require('path'),
chai = require('chai'),
expect = chai.expect,
series = require(path.resolve(__dirname, 'fib_fact_memoization.js'))();

describe('Fibonacci Test Suite', function () {
  describe('Correctness', function () {
    it('should return undefined for negative inputs', function () {
      expect(series.fibonacci(-99)).to.equal(0);
      expect(series.fibonacci(-5)).to.equal(0);
      expect(series.fibonacci(-1)).to.equal(0);
      expect(series.fibonacciLoop(-99)).to.equal(0);
      expect(series.fibonacciLoop(-5)).to.equal(0);
      expect(series.fibonacciLoop(-1)).to.equal(0);
    });

    it('should return expected value', function () {
      expect(series.fibonacci(0)).to.equal(0);
      expect(series.fibonacci(1)).to.equal(1);
      expect(series.fibonacci(2)).to.equal(1);
      expect(series.fibonacci(8)).to.equal(21);
      expect(series.fibonacciLoop(0)).to.equal(0);
      expect(series.fibonacciLoop(1)).to.equal(1);
      expect(series.fibonacciLoop(2)).to.equal(1);
      expect(series.fibonacciLoop(8)).to.equal(21);
    });
  });

  describe('Performance', function () {
    it('should finish', function () {
      expect(series.fibonacci(30)).to.equal(832040);
      expect(series.fibonacci(70)).to.equal(190392490709135);
      expect(series.fibonacci(97)).to.equal(83621143489848422977);
      expect(series.fibonacci(5000)).to.equal(Infinity);
      expect(series.fibonacciLoop(30)).to.equal(832040);
      expect(series.fibonacciLoop(70)).to.equal(190392490709135);
      expect(series.fibonacciLoop(97)).to.equal(83621143489848422977);
      expect(series.fibonacciLoop(5000)).to.equal(Infinity);
    });
  });
});

describe('Factorial Test Suite', function () {
  describe('Correctness', function () {
    it('should return undefined for negative inputs', function () {
      expect(series.factorial(-99)).to.equal(1);
      expect(series.factorial(-5)).to.equal(1);
      expect(series.factorial(-1)).to.equal(1);
      expect(series.factorialLoop(-99)).to.equal(1);
      expect(series.factorialLoop(-5)).to.equal(1);
      expect(series.factorialLoop(-1)).to.equal(1);
    });

    it('should return expected value', function () {
      expect(series.factorial(3)).to.equal(6);
      expect(series.factorial(5)).to.equal(120);
      expect(series.factorial(6)).to.equal(720);
      expect(series.factorial(8)).to.equal(40320);
      expect(series.factorialLoop(3)).to.equal(6);
      expect(series.factorialLoop(5)).to.equal(120);
      expect(series.factorialLoop(6)).to.equal(720);
      expect(series.factorialLoop(8)).to.equal(40320);
    });
  });

  describe('Performance', function () {
    it('should finish', function () {
      expect(series.factorial(15)).to.equal(1307674368000);
      expect(series.factorial(20)).to.equal(2432902008176640000);
      expect(series.factorial(5000)).to.equal(Infinity);
      expect(series.factorialLoop(15)).to.equal(1307674368000);
      expect(series.factorialLoop(20)).to.equal(2432902008176640000);
      expect(series.factorialLoop(5000)).to.equal(Infinity);
    });
  });

});
