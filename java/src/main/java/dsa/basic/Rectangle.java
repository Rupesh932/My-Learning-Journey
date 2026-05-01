package dsa.basic;

public class Rectangle {

    public static void main(String[] args) {
        System.out.println(isRectangle(2,3,2,3));
        System.out.println(isRectangle(2,3,3,3));
        System.out.println(isRectangle(-2,3,2,3));
        System.out.println(isRectangle(0,0,0,0));
        System.out.println(isRectangle(2,2,2,2));
        System.out.println(isRectangle(2,0,2,2));

    }
    public static boolean isRectangle(int sideA,int sideB,int sideC,int sideD){
        if((sideA <= 0 || sideB <= 0 || sideC <= 0 ||sideD <= 0)){
            return false;
        }

        return (sideA == sideB && sideC == sideD) || (sideA == sideC && sideB == sideD) || (sideA == sideD && sideB == sideC);

    }
}
