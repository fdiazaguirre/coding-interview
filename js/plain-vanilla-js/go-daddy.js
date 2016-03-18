/**
 * Created by fdiazaguirre on 3/18/16.
 */
// Multiply using closures
function multiply(a) {
    return function (b) {
        return a * b;
    }
}
// Iterate over Object properties
function countProperties(object) {
    var keys = Object.keys(object), count = 0, i = 0;
    for(i; i < keys.length; i++) {
        if (object.hasOwnProperty(key)) {
            count++;
        }
    }
    return count;
}

//Arrays
var arr1 = "josh".split('');
var arr2 = "john".split('').reverse();
arr1.push(arr2);// arr1 = ["j","o","s","h",[n,h,o,j]]
arr2.splice(-1); // arr2 = [n,h,o,]

// Parse vs runtime functions
// This is because behind the scenes JavaScript has hoisted the function to the top of the current scope.
// => Hi, I'm a function declaration!
declaration();

function declaration() {
    console.log("Hi, I'm a function declaration!");
}

//The function expression is not evaluated until it is assigned to a variable; therefore it is still undefined when invoked.
// => Uncaught TypeError: undefined is not a function
expression();

var expression = function () {
    console.log("Hi, I'm a function expression!");
}
// Okay: since was assigned
expression();