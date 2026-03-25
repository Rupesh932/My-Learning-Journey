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
console.log(`sum is ${addNumb1(10, 20)}`);

//create 4(IIFE)
(function test() {
  console.log("hello IIFE");
})();

(() => {
  console.log("hello IIFE");
})();

const myName = ((name) => name)("Rupesh");
console.log(`name: ${myName}`);

const addIIFE = ((n1, n2) => n1 + n2)(10, 20);

console.log(`sum is: ${addIIFE}`);

//create 5(callback function)
//so far we've passed various data type as function argument and here we will pass function itself as argument which is called callback
function love() {
  console.log(
    "life is love, we all need it, first do love and try to get in fuck ",
  );
}
function dance() {
  console.log("dancing after fuck to love");
}
function fuck(callback) {
  console.log(
    "life do fuck almost all the time for all, still its beautiful and need to fucking enjoy, search for love to fuck",
  );
  callback();
}
fuck(love);
fuck(dance); //hera is the dynamic invocation of fuck, if we call love() or dance() within fuck()
// the fuck is only invoking same function all the time but now  callback() is being polymorphic through callback parameter.

//*******************
console.log("*******************");
function pathoHamroBazarOrderPlace() {
  console.log("we've packing  your order");
}
function pathoFoodOrderPlace() {
  console.log("we've preparing your order");
}
function payment(amount, callback) {
  console.log(`${amount} payment has initialized`);
  let success = true;
  //checks related issues and update success ,otherwise
  if (success) {
    console.log("payment is received");
    callback();
  } else {
    console.log("Payment failed,Please try again");
  }
}
payment(500, pathoFoodOrderPlace);
payment(1500, pathoHamroBazarOrderPlace);
//*******************
//callback chain(hell)
console.log("******************************");
function order(callback) {
  console.log("1.order received and passed to kitchen");
  callback();
}
function cook(callback) {
  console.log("2.meal is ready to searve");
  callback();
}

function serve(callback) {
  console.log("3.serving to customer");
  callback();
}

function calculation(total, customerType, callback) {
  console.log("4. Bill is ready. with");
  if (total >= 5000) {
    console.log("   - 10% discount and gift applied");
  } else if (total > 1000 && customerType === "regular") {
    console.log("- 10% discount applied");
  } else {
    console.log("no discount");
  }
  callback();
}
function happyCustomer() {
  console.log("5.happy via quality service in resonable price");
}
order(function () {
  cook(function () {
    serve(function () {
      calculation(2500, "regular", happyCustomer);
    });
  });
});

// arrow callback cahin
console.log("******************************");
order(() => {
  cook(() => {
    serve(() => {
      calculation(3500, "rare", happyCustomer);
    });
  });
});
