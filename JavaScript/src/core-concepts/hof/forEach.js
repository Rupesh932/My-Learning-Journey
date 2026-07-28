const array = [10,20,30,40,50,60];
 let sum = 0;
array.forEach((number) =>{
    console.log(number);
})
console.log("***************");
array.forEach((number,index) =>{
    console.log(number,index);
})
console.log("***************");
array.forEach((number,index,arr) =>{
    console.log(number,index,arr);
})
console.log("***************");
array.forEach((number)=>{
      sum += number;
})
console.log(`sum = ${sum}`);
console.log("***************");
//filter in given array
  const newArray = array.filter((number)=> number >  30);
  console.log(newArray);
  console.log("***************");