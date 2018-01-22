'use strict';

var items = [
  {name: 'stationary' , category: null},
  {name: 'books' , category: 'stationary'},
  {name: 'digital' , category: 'books'},
];

function makeTree(list) {
  let tree = {};

  for (let i = 0; i < items.length; i++) {
    if (items[i].category === null) {
      tree[items[i].name] = {};
    } else {
      //instanceof Object
      if (!tree[items[i].category]) {
        console.log('if: ' + items[i].category);
        tree[items[i].category] = {};
      }
      // console.log('for all: ' + JSON.stringify(tree));
      tree[items[i].category][items[i].name] = {};
    }
  }

  return tree;
}

console.log(makeTree(items));