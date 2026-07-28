package core.CoreAdvance.collectionframework.IteratorDemo;


import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        String[] names = {"roshani","rashmi","rajani","rabina","mamata","sambridhi","samragyee","aavyashree"};
        Iterator<String> itr = new NameContainer(names).iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
class NameContainer implements Iterable<String>{
    private String[] names ;
    private int size;

    NameContainer(String [] names){
        this.names = names;
        this.size = this.names.length;
    }

    @Override
    public Iterator<String> iterator() {
        //return new NameContainerIterator();
        //use anonymous class
        return new Iterator<String>(){
            private int pos;
            @Override
            public boolean hasNext(){
                return pos < size;
            }
            @Override
            public String next(){
                return names[pos++];
            }

        };
    }

//    private class NameContainerIterator implements Iterator<String>{
//        private int pos;
//        @Override
//        public boolean hasNext(){
//            return pos < size;
//        }
//        @Override
//        public String next(){
//            return names[pos++];
//        }
//    }
}
