package core.CoreAdvance.enumeration.exploreenum;

public class ParameterizedEnum {
    public static void main(String[] args) {
        char degreeSymbol = 176;//\u00B0
        AdvanceDirection n = AdvanceDirection.NORTH;
        System.out.println(n.name()+": "+n.getDegree()+degreeSymbol);

        AdvanceDirection s = AdvanceDirection.SOUTH;
        System.out.println(s.name()+": "+s.getDegree()+degreeSymbol);
    }
}
enum AdvanceDirection {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    //instance variable
    private int degree;
    //constructor to initialize instance field, and gives degree to constant,i.e. NORTH(0)
    AdvanceDirection(int degree) {
        this.degree = degree;
    }
    public int getDegree() {
        return this.degree;
    }
}

