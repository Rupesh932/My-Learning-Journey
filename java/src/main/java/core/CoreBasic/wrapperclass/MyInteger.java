package core.CoreBasic.wrapperclass;

public final class MyInteger extends Number implements Comparable<MyInteger> {
    private final int value;

    public MyInteger(int value){
        this.value = value;
    }
    public MyInteger(String value){
        this.value = Integer.parseInt(value);
    }




    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float)value;
    }

    @Override
    public double doubleValue() {
        return (double)value;
    }

    @Override
    public int compareTo(MyInteger anotherInteger) {
        return compare(this.value,anotherInteger.value);
    }
    public static int compare(int x,int y){
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof MyInteger i){
            return value == i.intValue();
        }
        return false;
    }
    @Override
    public int hashCode(){
        return MyInteger.hashCode(value);
    }


    public static int hashCode(int value){
        return value;
    }
}
