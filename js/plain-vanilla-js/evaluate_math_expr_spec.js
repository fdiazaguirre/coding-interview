const path = require('path'),
      calc = require(path.resolve(__dirname, 'evaluate_math_expr.js'));

let assert = require("chai").assert;
describe('Challenge', function() {
  it('should recognize single positive numbers', function() {
    assert.equal(calc("123"), 123);
  });
  it('should recognize single negative numbers', function() {
    assert.equal(calc("-123"), -123);
  });
  it('should handle addition', function() {
    assert.equal(calc("1+1"), 2);
  });
  it('should handle subtraction', function() {
    assert.equal(calc("1 - 1"), 0);
  });
  it('should handle multiplication', function() {
    assert.equal(calc("1* 1"), 1);
    assert.equal(calc("12* 123"), 1476);
  });
  it('should handle multiplication of a negative number', function() {
    assert.equal(calc("12*-1"), -12);
    assert.equal(calc("12 * -123"), -1476);
  });
  it('should handle multiplication of two negative numbers', function() {
    assert.equal(calc("-12 * -123"), 1476);
  });
  it('should handle division', function() {
    assert.equal(calc("1 /1"), 1);
  });
  it('should handle complicated expressions without paranthesis', function() {
    assert.equal(calc("2 /2+3 * 4.75- -6"), 21.25);
  });
  it('should handle simple expressions with parenthesis', function() {
    assert.equal(calc("((80 - (19)))"), 61);
    assert.equal(calc("(1 - 2) + -(-(-(-4)))"), 3);
    assert.equal(calc("1 - -(-(-(-4)))"), -3);
  });
  it('should handle negating parantheses', function() {
    assert.equal(calc("12* 123/-(-5 + 2)"), 492);
    assert.equal(calc("12* 123/(-5 + 2)"), -492);
  });
  it('should handle complicated expressions', function() {
    assert.equal(calc("2 / (2 + 3) * 4.33 - -6"), 7.732);
    assert.equal(calc("((2.33 / (2.9+3.5)*4) - -6)"), 7.45625);
    assert.equal(calc("123.45*(678.90 / (-2.5+ 11.5)-(80 -19) *33.25) / 20 + 11"), -12042.760875);
    assert.equal(calc("(123.45*(678.90 / (-2.5+ 11.5)-(((80 -(19))) *33.25)) / 20) - (123.45*(678.90 / (-2.5+ 11.5)-(((80 -(19))) *33.25)) / 20) + (13 - 2)/ -(-11)"), 1);
  });
});