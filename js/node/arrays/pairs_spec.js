'use strict';

var path = require('path'),
    chai = require('chai'),
    expect = chai.expect,
    should = chai.should(),
    Pairs = require(path.resolve(__dirname, 'pairs.js'));


describe('Pairs Test Suite', function () {
  var pairs =  new Pairs();

  describe('Pair not found', function () {
    it('should return an empty array when there are not pairs', function () {
      pairs.getPairsMySolution([1,9], 3).should.have.lengthOf(0);
      pairs.getPairsMySolution([1,2,5,9], 9).should.have.lengthOf(0);
      pairs.getPairsMySolution([], 0).should.have.lengthOf(0);
      expect(pairs.getPairsOptimalSolution([1,2,5,9], 9)).to.be.empty;
      expect(pairs.getPairsOptimalSolution([], 0)).to.be.empty;
    });
  });

  describe('Found a Pair', function () {
    it('should return an array with all the pairs that satisfy the sum', function () {
      expect(pairs.getPairsMySolution([3,2,1,6,8], 8)).to.eql([{"a": 2, "b": 6}]);
      expect(pairs.getPairsMySolution([1,2,5,6,7], 8)).to.eql([{"a": 1, "b": 7}, {"a": 2, "b": 6}]);
      expect(pairs.getPairsOptimalSolution([3,2,1,6,8], 8)).to.eql([{"a": 2, "b": 6}]);
      expect(pairs.getPairsOptimalSolution([1,2,5,6,7], 8)).to.eql([{"a": 2, "b": 6}, {"a": 1, "b": 7}]);
    });
  });

});