package dsa.arrays.searching;

public class KthMissingInteger {
    public static void main(String[] args) {
        int[] array = {2,3,4,7,11,12};
        System.out.println(kthMissingBruteForce(1,array));
       System.out.println(kthMissingBruteForce(2,array));
        System.out.println(kthMissingBruteForce(3,array));
//        System.out.println(kthMissingBruteForce(4,array));
//        System.out.println(kthMissingBruteForce(5,array));
//        System.out.println(kthMissingBruteForce(6,array));
//        System.out.println(kthMissingBruteForce(9,array));
    }

    public static int kthMissingBruteForce(int k,int[] array){

        if(k < 0 || array == null ){
            //constraint : positive integer
            return -1;
        }
        if( array.length < 2){
            return array[0]; 
        }
     
       //2,3,4,7,11,12
     int missed =  array[array.length-1] - array.length;
        if(k > missed){
             return (k - missed) + array[array.length-1];
        }


        int start = 1;
        int[] ansArray = new int[missed];
        for(int i = 0;i<array.length;i++){


        }
    return ansArray[k];

    }
}