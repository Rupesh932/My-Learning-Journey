package core.CoreAdvance.enumeration.exploreenum;

public class ConstantSpecificClassBodyEnum {

    public static void main(String[] args) {
        AbstractDirection adn = new NorthDirection();
        adn.move();

        AbstractDirection ads = new SouthDirection();
        ads.move();

        //anonymous inner class
        AbstractDirection ade = new AbstractDirection() {
            @Override
            public void move() {
                System.out.println("EastDirection :  move Right / move x + 1 ");
            }
        };
        AbstractDirection adw = new AbstractDirection() {
            @Override
            public void move() {
                System.out.println("WestDirection :  move left / move x - 1 ");
            }
        };
        ade.move();
        adw.move();

        // from enum
        System.out.println("=======================================");
        System.out.println("Enum starts from here: ");
        MoreAdvanceDirection man = MoreAdvanceDirection.NORTH;
        man.move();

        MoreAdvanceDirection mas = MoreAdvanceDirection.SOUTH;
        mas.move();

        MoreAdvanceDirection mae = MoreAdvanceDirection.EAST;
        mae.move();

        MoreAdvanceDirection maw = MoreAdvanceDirection.WEST;
        maw.move();
    }
}


//use abstract class
abstract class AbstractDirection{
    public abstract void move();
}
class NorthDirection extends AbstractDirection{
    @Override
    public void move() {
        System.out.println("NorthDirection :  move up / move y + 1 ");
    }
}
class SouthDirection extends AbstractDirection{
    @Override
    public void move() {
        System.out.println("SouthDirection :  move down / move y - 1 ");
    }
}
//enum with anonymous inner class
enum MoreAdvanceDirection {
    NORTH{
        @Override
        public void move(){
            System.out.println("NorthDirection :  move up / move y + 1 ");
        }
    },
    EAST{
        @Override
        public void move(){
            System.out.println("EastDirection :  move right / move x + 1 ");
        }

    },
    SOUTH{
        @Override
        public void move(){
            System.out.println("SouthDirection :  move down/ move y - 1 ");
        }

    },
    WEST{
        @Override
        public void move(){
            System.out.println("WestDirection :  move left / move x - 1 ");
        }
    };

   public abstract void move();//each constant object needs to implement.
}
