'use strict';

const path = require('path'),
    chai = require('chai'),
    expect = chai.expect,
    should = chai.should(),
    StringUtils = require(path.resolve(__dirname, 'strings-utils.js'));

describe('StringUtils Test Suite', function () {
  describe('Reverse the given string', function () {
    it('should return an empty array when there are not pairs', function () {
      expect(StringUtils.reverseString("hola")).to.be.equal("aloh");
    });
  });

  describe('Anagram checker', function () {
    it('should return true when the given words are anagram, false otherwise', function () {
      expect(StringUtils.areAnagrams("PAN", "nap")).to.be.true;
      expect(StringUtils.areAnagrams("saw", "WAS")).to.be.true;
      expect(StringUtils.areAnagrams("abracadabra", "abracabrada")).to.be.true;

      expect(StringUtils.areAnagrams("hola", "aloha")).to.be.false;
      expect(StringUtils.areAnagrams("PETER", "petra")).to.be.false;
      expect(StringUtils.areAnagrams("aabbccc", "abbbccc")).to.be.false;
    });
  });

});