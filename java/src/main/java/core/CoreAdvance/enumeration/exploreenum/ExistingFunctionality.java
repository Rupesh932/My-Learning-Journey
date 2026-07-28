package core.CoreAdvance.enumeration.exploreenum;

import java.util.Arrays;

public class ExistingFunctionality {
    public static void main(String[] args) {
        System.out.println("values(): ");
        //1.values(): return array of constants. allows us to iterate enum(menus)
        Direction[] allDirections = Direction.values();

        System.out.println(Arrays.toString(allDirections));

        for (Direction direction : allDirections) {
            System.out.println(direction);
        }

        //2. valueOf(String): converts a string into enum constant
       //Direction north = Direction.valueOf("North");// IllegalArgumentException
        System.out.println("valueOf(NORTH): ");
        Direction north = Direction.valueOf("NORTH");
        System.out.println(north);

        //3. name(): exact name of enum object.
        // 3.1 toString() : you can override it, but name() couldn't.
        System.out.println("name()/toString()/reference(internally toString()): ");
        System.out.println(north.name());
        System.out.println(north.toString());
        System.out.println(north);//println() also execute toString()

        //4.ordinal(): each enum has index given, if you want to see that index , use it
        System.out.println("ordinal(): ");
        for (Direction direction : allDirections) {
            System.out.println(direction.name()+" Index/ordinal: " + direction.ordinal());
        }

    }
}
enum Direction{
    NORTH,
    SOUTH,
    EAST,
    WEST;

    @Override
    public String toString() {
        return this.name()+" Direction";
    }
}