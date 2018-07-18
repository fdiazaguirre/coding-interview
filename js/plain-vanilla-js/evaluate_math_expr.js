module.exports = (expression) => {
  const operations = ['+','-','*','/'];

  function sum(a, b) {
    return (+a) + (+b);
  }
  
  function substract(a, b) {
    return (+a) - (+b);
  }
  
  function multiply(a, b) {
    return (+a) * (+b);
  }
  
  function divide(a, b) {
    return (+a) / (+b);
  }

  function compute(a, b, op) {
    switch (op) {
      case '+':
        return sum(a,b);
      case '-':
        return substract(a,b);
      case '*':
        return multiply(a,b);
      case '/':
        return divide(a,b);
    }
  }


  function getOperationsInOrder(arr) {
    let terms = [], openParentheses = [], closingParentheses = [];

    let i = arr.indexOf('(');
    while (i > 0 && i < arr.length) {
      openParentheses.push(i);
      i = arr.indexOf('(', i);
    }

    i = arr.indexOf(')');
    while (i > 0 && i < arr.length) {
      closingParentheses.push(i);
      i = arr.indexOf(')', i);
    }

    while (openParentheses.length > 0) {
      terms.push(arr.slice(openParentheses.pop(), closingParentheses.shift()));
    }

    i = 0;
    while (arr[i]) {

    }
  }



  function calc(expression) {
    const arr = expression.replace(/\s+/g,'').split('');

    // Parse
  }
  
  
  return calc(expression);
}

