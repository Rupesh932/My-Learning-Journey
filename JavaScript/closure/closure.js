//scope and closure, HOF

//global scope
let a = 10;
const b = 20;
// global accessing of a and b
function add() {
  return a + b;
}
console.log(add());
if (true) {
  console.log(a);
} else {
  console.log(b);
}

// block or local or functionl scope
function harami() {
  let d = 20;
}
//console.log(d); //ReferenceError: d is not defined  at Object.<anonymous>

/* 
we've three types of scopes
1.GLOBAL -> accessible to all
2.FUNCTIONAL(function block) 
3.BLOCK LEVEL( inside {} bracket)
*/
var e = 10; //global scope
function test() {
  var f = 22; //funtional scope
}
if (true) {
  var x = 44; //var is not blocked scoped
}
console.log(x); //keyword 'var' doesn't respect block scope

let global = "global";
function test1() {
  let global = "local";
  let local = "from test1";
  console.log(global); // priority for functional level global
  function test() {
    console.log(global); // searching global var inside itself, then parent then out side.
    let local = "from test";
    console.log(local);
  }
  test();
}
test1();

//
console.log("*******************");
function createCounter() {
  let count = 0;
  function increment() {
    return count++;
  }
  return increment;
  // return increment()-> invoke ta function which is not returing anyvalue so it will return undefined
}
const counter = createCounter();
console.log(counter); //[Function: increment]
//counter has referenc(via return increment) of increment() so we can directly execute  here.
console.log(counter());
console.log(counter());
console.log(counter());
/* counter has reference of increment but how it can accessing count after execution of createCounter()?
    its because of Closure. Closure  = A function that remembers variables its outer scope even after the outer 
    function has finished executing. yani closure function aafno outer scope variable lai yad gardaxa even after
    outer function ko execution sakiyako vaya pani.
*/

//real time use case
let balance = 5550; //shomehow balance updated to inconsistent value, or can access by unauthorized scope, block or function.
// we are giving the balance to access directly, so it may have undesired value through update or unauthorized access.
// so we need to prevent direct access of this balance
// so we have to use function to use this balance or function only can access this balance and we can validate this
// balance during creation as well as updation .

const user = {
  name: "Kanxa",
  userBalance: 5000,
  deposite: function (amount) {
    if (typeof amount === "number" && amount > 0) {
      this.userBalance += amount;
      return `Rs. ${amount} deposite successful`;
    }
  },
  withdraw: function (amount) {
    if (
      typeof amount === "number" &&
      amount > 0 &&
      this.userBalance >= amount
    ) {
      this.userBalance -= amount;
      return `Rs. ${amount} withdraw successful`;
    }
  },
  getBalance: function () {
    return this.userBalance;
  },
};
console.log(`${user.name}:`, user.deposite(555));
console.log(`${user.name}:`, user.withdraw(55));
console.log(`${user.name}: new balance ${user.getBalance()}`);
// now again we have direct accessof userBalance via user.userBalance
// so still we've chance of unauthorized access of userBalance. so we need to make this userbalance private

function crateBankAccount(name, balance) {
  let userBalance = balance;
  const user = {
    name: name,
    deposite: function (amount) {
      if (typeof amount === "number" && amount > 0) {
        userBalance += amount;
        return `${this.name} has deposited  Rs. ${amount}  successfully`;
      }
    },
    withdraw: function (amount) {
      if (typeof amount === "number" && amount > 0 && userBalance >= amount) {
        userBalance -= amount;
        return `${this.name} has withdrew Rs. ${amount}  successfully`;
      }
    },
    getBalance: function () {
      return `${this.name} has balenced of ${userBalance}`;
    },
  };
  return user;
}
// now userBalance is private variable of function createBankAccount() and there is no way to direct access of this variable
// out side the function. so now userBalance is prevented from unauthorized/accendital access/changes .
      //userBalance is closure to hari 
const hari = crateBankAccount("Hari", 5000);
console.log(hari.getBalance());
console.log(hari.deposite(6000));
console.log(hari.getBalance());
console.log(hari.withdraw(1000));
console.log(hari.getBalance());

     //userBalance is closure to rupesh
const rupesh = crateBankAccount("Rupesh", 10000);
console.log(rupesh.getBalance());
console.log(rupesh.deposite(6000));
console.log(rupesh.getBalance());
console.log(rupesh.withdraw(1000));
console.log(rupesh.getBalance());
//all inner function can have userBalance as closure scope(persistence in heap) but
// hari.balance or rupesh.balance is undefined for return object of createBankAccount().
