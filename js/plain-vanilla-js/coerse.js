
const a = {
  num: 0,
  valueOf: function () {
    return this.num += 1;
  }
};

const equality = (a == 1 && a == 2 && a == 3);

console.log(equality);

const equality2 = (1 == new Boolean(true) == '1');

console.log(equality);