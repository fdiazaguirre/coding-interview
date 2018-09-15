'use strict';

const path = require('path'),
    rotation = require(path.resolve(__dirname, 'rotation.js'))();

let assert = require("chai").assert;

describe('Rotation Test Suite', () => {

  it('Should check length', () => {
    assert.isFalse(rotation.isRotation(null, undefined), 'False when s1 is null and s2 undefined');
    assert.isFalse(rotation.isRotation(undefined, null), 'False when s1 is undefined and s2 null');

    assert.isFalse(rotation.isRotation('', 'chau'), 'False when s1 is empty');
    assert.isFalse(rotation.isRotation('h', 'chau'), 'False when s1 is lower than s2');

    assert.isFalse(rotation.isRotation('hola', ''), 'False when s2 is empty');
    assert.isFalse(rotation.isRotation('hola', 'c'), 'False when s2 is lower than s2');

    assert.isFalse(rotation.isRotation('', ''), 'False when length is 0');
    assert.isFalse(rotation.isRotation('a', 'a'), 'False when length is 1');
  });

  it('Should check same letters', () => {
    assert.isFalse(rotation.haveSameLetters('abc', 'def'), 'Must have same letters and in the same occurrences');
    assert.isFalse(rotation.haveSameLetters('abce', 'bdef'), 'Must have same letters and in the same occurrences');

    assert.isTrue(rotation.haveSameLetters('abc', 'cba'), 'Must have same letters and in the same occurrences');
  });

  it('Should have different order', () => {
    assert.isFalse(rotation.haveDiffOrder('abc', 'abc'), 'False whe they are identical');

    assert.isTrue(rotation.haveDiffOrder('acb', 'abc', 'True when difference it is in the middle'));
    assert.isTrue(rotation.haveDiffOrder('abc','bca'), 'True when difference it is in the front');
  });
  
  it('Should validate rotation', () => {
    assert.isFalse(rotation.isRotation('aa','ab'), 'Different letters');

    assert.isFalse(rotation.isRotation('cc','bb'), 'Different letters');
    assert.isFalse(rotation.isRotation('abbccc','abbccd'), 'Different occurrences');
    assert.isTrue(rotation.isRotation('hola','laho'), 'Valid rotation');
    assert.isTrue(rotation.isRotation('waterproof','erproofwat'), 'Valid rotation');
  });

  it('Book solution', () => {
    let s1 = 'waterproof', s2 = 'erproofwat', s1s1 = s1.concat(s1);

    assert.isTrue(s1s1.includes(s2), 'Should include s2');

    s1 = 'abbccc';
    s2 = 'abbccd';
    s1s1 = s1.concat(s1);

    assert.isFalse(s1s1.includes(s2), 'Should include s2');
  });
});