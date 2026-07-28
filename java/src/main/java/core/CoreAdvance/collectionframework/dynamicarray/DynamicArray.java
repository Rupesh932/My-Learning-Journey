package core.CoreAdvance.collectionframework.dynamicarray;

public class DynamicArray {
    private int[] arr;
    public DynamicArray(int size){
        arr = new int[size];
    }
    public boolean add(int element){
       return true;
    }
    public int get(int index){
        return arr[index];
    }
    public boolean insert(int index,int element){
        return true;
    }
    public boolean replace(int index,int element){
        return true;
    }
    public boolean delete(int index){
        return true;
    }
}
