//need
let mark1 = 100;
let mark2 = 99;
let mark3 = 97;
let mark4 = 94;
let mark5 = 92;
let mark6 = 77;
let mark7 = 61;
let mark8 = 69;
let mark9 = 88;
let mark10 = 100;
// messy looks and stores in memory 
let marks = [100,99,97,94,92,77,61,69,88,100];
//print array
console.log(marks);


//length of array 
 marks.length;
 
 // access element
 marks[0] //100
 
 //typeof(array) -> object(mutable)
 // we can chage element of array.
 
 //add element at end
  marks.push(79);
  
  //delete or remove last element
  marks.pop();
  
  //add and delete element from first index
  marks.unshift(54) //add element at first index
  marks.shift() // remove starting element
  // shift and unshift is reason to reduce performance of system so its not
  // recommand to use .
  