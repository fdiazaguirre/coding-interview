'use strict';

'use strict';

const path = require('path'),
      chai = require('chai'),
      expect = chai.expect,
      should = chai.should(),
      StringUtils = require(path.resolve(__dirname, 'numbers-utils.js'));

describe('StringUtils Test Suite', function () {
  describe('Reverse the given string', function () {
    it('should return an empty array when there are not pairs', function () {
      expect(StringUtils.findLongestConsecutiveSubseq([1, 2, 3])).to.be.equal(3);
    });
  });

});
  