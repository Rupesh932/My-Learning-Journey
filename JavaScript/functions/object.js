//------------------------
const greeting = () => {
  let user = {
    name: "Rupesh",
    age: 33,
  };
  return user;
};
console.log(greeting());
//------------------------
const greeting1 = () => {
  return {
    name: "Rupesh",
    age: 33,
  };
};
console.log(greeting1());

//------------------------
const greeting2 = () => ({ name: "Rupesh", age: 33 });
console.log(greeting2());
