'use strict';

const isPalindrome = (word) => {
  const arr = word.split('');
  let i = 0, j = arr.length - 1;
  while ( i < j ) {
    if (arr[i] !== arr[j]) {
      return false;
    }
    i++;
    j--;
  }
  return true;
}

// console.log(isPalindrome('madam'));
// console.log(isPalindrome('anna'));
//
// console.log(isPalindrome('car'));
// console.log(isPalindrome('anni'));

function isPalindromeToptal(str) {
  // Regex to replace non words characters with empty
  str = str.replace(/\W/g, '').toLowerCase();
  return (str == str.split('').reverse().join(''));
}

console.log(isPalindromeToptal('madam'));
console.log(isPalindromeToptal('anna'));

console.log(isPalindromeToptal('car'));
console.log(isPalindromeToptal('anni'));