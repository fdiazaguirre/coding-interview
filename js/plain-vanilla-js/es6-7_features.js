// Write a recursive function for summing the yielded values of the following generator:

function * gen() {
  for (let i = 0 ; i < 5 ; i++) yield i;
}
const myGen = gen()


// mine
function recursiveSum(x) {
  let result = 0;
  result += x;
  if (x === 0) {
    return result;
  } else {
    return recursiveSum(myGen.next());
  }
}

recursiveSum();