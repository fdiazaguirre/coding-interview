/**
 *
 * Closures, Scope, and Execution Context

 Challenge 1
 Create a function createFunction that creates and returns a function. When that created function is called, it should print "hello".
 var function1 = createFunction();
 // now we'll call the function we just created
 function1(); //should console.log('hello');

 When you think you completed createFunction, un-comment out those lines in the code and run it to see if it works.
 Challenge 2
 Create a function createFunctionPrinter that accepts one input and returns a function. When that created function is called, it should print out the input that was used when the function was created.
 var printSample = createFunctionPrinter('sample');
 var printHello = createFunctionPrinter('hello')
 // now we'll call the functions we just created
 printSample(); //should console.log('sample');
 printHello(); //should console.log('hello');
 Challenge 3
 Examine the code for the outer function. Notice that we are returning a function and that function is using variables that are outside of its scope.
 Uncomment those lines of code. Try to deduce the output before executing.
 Challenge 4
 Now we are going to create a function addByX that returns a function that will add an input by x.
 var addByTwo = addByX(2);
 addByTwo(1); //should return 3
 addByTwo(2); //should return 4
 addByTwo(3); //should return 5

 var addByThree = addByX(3);
 addByThree(1); //should return 4
 addByThree(2); //should return 5

 var addByFour = addByX(4);
 addByFour(4); //should return 8
 addByFour(10); //should return 14
 Extension: Challenge 5
 Write a function once that accepts a callback as input and returns a function. When the returned function is called the first time, it should call the callback and return that output. If it is called any additional times, instead of calling the callback again it will simply return the output value from the first time it was called.
 Extension: Challenge 6
 Write a function after that takes the number of times the callback needs to be called before being executed as the first parameter and the callback as the second parameter.
 Extension: Challenge 7
 Write a function delay that accepts a callback as the first parameter and the wait in milliseconds before allowing the callback to be invoked as the second parameter. Any additional arguments after wait are provided to func when it is invoked. HINT: research setTimeout();
 *
 * */


function createFunction() {
  function createFunctionPrinter() {
    console.log('hello');
  }
  return createFunctionPrinter;
}

// UNCOMMENT THESE TO TEST YOUR WORK!
var function1 = createFunction();
function1();



function createFunctionPrinter(input) {
  var i = input;
  function print() {
    console.log(i);
  }

  return print;
}

// UNCOMMENT THESE TO TEST YOUR WORK!
var printSample = createFunctionPrinter('sample');
printSample();
var printHello = createFunctionPrinter('hello');
printHello();



function outer() {
  var counter = 0; // this variable is outside incrementCounter's scope
  function incrementCounter () {
    counter ++;
    console.log('counter', counter);
  }
  return incrementCounter;
}

var willCounter = outer();
var jasCounter = outer();

// Uncomment each of these lines one by one.
// Before your do, guess what will be logged from each function call.

willCounter();
willCounter();
willCounter();

jasCounter();
willCounter();



function addByX(x) {
  var persistentX = x;
  function sum(y) {
    return persistentX + y;
  }
  return sum;
}

var addByTwo = addByX(2);
console.log(addByTwo(1));
console.log(addByTwo(2));

// now call addByTwo with an input of 1
var addByThree = addByX(3);
console.log(addByThree(1)); //should return 4

// now call addByTwo with an input of 2



//--------------------------------------------------
// Extension
//--------------------------------------------------
/*

 
*/
function once(func) {
  var counter = 0, result;
  function f(y) {
    var z = y;
    if (counter === 0) {
      result = func(z);
      counter++;
    }

    return result;
  }
  return f;
}

var onceFunc = once(addByTwo);

// UNCOMMENT THESE TO TEST YOUR WORK!
console.log(onceFunc(4));  //should log 6
console.log(onceFunc(10));  //should log 6
console.log(onceFunc(9001));  //should log 6


function after(count, func) {
  var counter = 1;

  function fn() {
    if(count === counter) {
      func();
    } else {
      counter++;
    }
  }

  return fn;
}

var called = function() { console.log('hello') };
var afterCalled = after(3, called);

afterCalled(); // -> nothing is printed
afterCalled(); // -> nothing is printed
afterCalled(); // -> 'hello' is printed


function delay(func, wait, ...args) {
  return setTimeout(() => { console.log(func(args)); }, wait);
}

function fn (args) {
  return args.reduce( (accum, x) => {
    return accum + x;
  }, 0);
}

delay(fn, 5000, 1, 2, 5);

/*A closure is an inner function that has access to the variables in the outer (enclosing) function’s scope chain.
The closure has access to variables in three scopes; specifically:
(1) variable in its own scope,
(2) variables in the enclosing function’s scope, and
(3) global variables.*/

var globalVar = "xyz";

(function outerFunc(outerArg) {
  var outerVar = 'a';

  (function innerFunc(innerArg) {
    var innerVar = 'b';

    console.log(
    "outerArg = " + outerArg + "\n" +
    "innerArg = " + innerArg + "\n" +
    "outerVar = " + outerVar + "\n" +
    "innerVar = " + innerVar + "\n" +
    "globalVar = " + globalVar);

  })(456);
})(123);

