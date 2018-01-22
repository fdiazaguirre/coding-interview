'use strict';
/**
 * @resources:
 * {URI} https://scotch.io/tutorials/understanding-hoisting-in-javascript
 * {URI} https://www.sitepoint.com/5-typical-javascript-interview-exercises/
 * {URI} https://www.thatjsdude.com/interview/js2.html
 */

var fullname = 'A';
var obj = {
  fullname: 'B',
  prop: {
    fullname: 'C',
    getFullname: function() {
      return this.fullname;
    }
  }
};

// 'C' -> this is prop object
console.log(obj.prop.getFullname());

var test = obj.prop.getFullname;

// 'A' -> this is global (window for browsers)
console.log(test());

// 'B' -> passing obj object
console.log(obj.prop.getFullname.call(obj));