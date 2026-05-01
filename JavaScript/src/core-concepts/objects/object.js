//create
const user = {
  name: "Rupesh",
  address: "PepsiCola",
  language: "Java, Html, Css, JavaScript",
  family: {
    father: "Ramkrishna",
    mother: "Saradha",
    brother: "Bhushan,Shyam",
    sister: "None",
    occupation: "Farmer & Business",
  },
  phoneNo: "9841-XXX XXX",
};

//read
console.log(user);
console.log(user.family);
console.log(user.family.brother);

console.log(user["name"]);

//update or add
user.language = "Java,Html,Css,JavaScript,Python,SpringFrameWrok"; //update
//add
user.family.address = "Kavre";
user.bloodGroup = "B+";
user.delete = "delete";
console.log(user);

//delete
delete user.delete;
console.log(user);

//loop
for (let keys in user) {
  console.log(keys, user[keys]);
}
console.log("**********************");
for (let entries of Object.entries(user)) {
  console.log(entries);
}
console.log("**********************");
for (let [keys, values] of Object.entries(user)) {
  console.log(keys, values);
}

//method inside object
console.log("*********************");
const user2 = {
  name: "Hari",
  age: 22,
  greeting: function () {
    console.log(
      `This is function inside of user2 object and calling from ${this.name}`,
    );
  },
};

console.log(user2);
const user3 = {
  name: "Kanxa",
  age: 33,
};
user3.greeting = user2.greeting; // assigning to user3
console.log(user3);
user2.greeting();
user3.greeting();

//spread operator
const arr1 = [1, 2, 3, 4, 5];
const arr2 = [...arr1, 6, 7, 8, 9];
const arr3 = [
  ...arr2,
  "b",
  "c",
  [2.2, 3.3, 4.4, [100, 200, 300]],
  ["x", "y", "z"],
  { name: "Rupesh", age: 22, address: "ktm" },
];
console.log(arr3);
const arr4 = [...arr3];
console.log(arr4);
arr4[0] = 11; //not mutate
console.log("array 2");
console.table(arr2);
console.log("arrary 4");
console.table(arr4);
//those are mutate on both
arr4[11][2] = 6.6;
arr4[12][0] = "X";
arr4[13].name = "kanxa";
arr4[13].address = "kavre";
console.table("array 3");
console.table(arr3);
console.table("array 4");
console.table(arr4);

const users = [
  { id: 1, name: "Rupesh", role: "Dev" },
  { id: 2, name: "Kanxa", role: "Designer" },
  { id: 3, name: "Hari", role: "Tester" },
];
console.table("Users");
console.table(users);
//sallow  copy
const oldObj = {
  name: "Rice",
  details: { price: 120 },
};
const sallowObj = {
  ...oldObj,
};
sallowObj.details.price = 200;
console.log("oldObj price: ", oldObj.details.price);
console.log("Sallow Object price: ", sallowObj.details.price);
