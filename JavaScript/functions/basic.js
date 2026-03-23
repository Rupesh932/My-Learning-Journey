//create 1
function add(n1, n2, n3 = 0, n4 = 0) {
  return n1 + n2 + n3 + n4;
}
let result = add(44, 10);
console.log(`sum is ${result}`);
console.log(`sum is ${add(33, 44, 55)}`);

//rest operator
function add1(...nums) {
  let sum = 0;
  for (let value of nums) {
    sum += value;
  }
  return sum;
}
let result1 = add1(33, 44, 55, 66);
console.log(`sum is ${result1}`);
result1 = add1(333, 445);
console.log(`sum is ${result1}`);

//create 2(as expression)
const addNumber = function (...nums) {
  let sum = 0;
  for (let n of nums) {
    sum += n;
  }
  return sum;
};
console.log(`sum is ${addNumber(2, 4, 6)}`);

//create 3(arrow function most used)
const greeting = () => {
  console.log("hello form arrow");
};
greeting();

const addNumb = (n1, n2) => {
  return n1 + n2;
};
console.log(`sum is ${addNumb(10, 20)}`);
//short hand
const addNumb1 = (n1, n2) => n1 + n2;
console.log(`sum is ${addNumb(10, 20)}`);
