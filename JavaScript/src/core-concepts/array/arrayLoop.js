let array = [10,20,30,40,50,"Rupesh","M"];
//1. old approach
  for(let i = 0;i<array.length;i++){
    console.log(array[i]);
  }

  //2. new approach
  for(let value of array){
    console.log(value);
  }