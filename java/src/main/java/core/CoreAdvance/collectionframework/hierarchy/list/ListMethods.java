package core.CoreAdvance.collectionframework.hierarchy.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListMethods {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(33);list.add(44);list.add(55);list.add(66);list.add(77);list.add(88);

        System.out.println("Initial list : "+list);
        //get element
        System.out.println("list.get(2): "+list.get(2));

        //set element
        System.out.println("List before list.set(1,22): "+list);
        list.set(1,22);
        System.out.println("List after list.set(1,22): "+list);

        //immutable list
        List<String> ramkrishna = List.of("Shyam","Bhushan","Rupesh");
        List<String> shivanath = List.of("Ram","Balaram","Samjhana");
        List<String> chimauriya = List.of("Yadav","Nirmala","Kanxi","Surendra");
        List<String> naral = List.of("Santoshi","Suyas","Bijaya","Rishav");
        List<String> uprety = List.of("Gita","Shova","Shasi","Pawan");

        List<String> worker = List.of("Ruchal","Mime","Birbahadur","Shivaraj","Sarki","Bichar");

        //mutable list
        List<String> brotherhoodUmbrella = new ArrayList<>(ramkrishna);

        brotherhoodUmbrella.addAll(shivanath);
        brotherhoodUmbrella.addAll(chimauriya);
        brotherhoodUmbrella.addAll(naral);
        brotherhoodUmbrella.addAll(uprety);
        brotherhoodUmbrella.addAll(worker);// by mistake

        //removeAll()
        brotherhoodUmbrella.removeAll(worker);

        System.out.println("Grandchild of mr.Bhavanath: " +brotherhoodUmbrella);

        //indexOf(Object obj)
        System.out.println("naral.indexOf(\"Bijaya\"): "+naral.indexOf("Bijaya"));
        System.out.println("brotherhoodUmbrella.indexOf(\"Bijaya\"): "+brotherhoodUmbrella.indexOf("Bijaya"));

        //ListIterator
        ListIterator<String> sitr = brotherhoodUmbrella.listIterator();
        System.out.println("-------------List Iterator ----------------");
        while(sitr.hasNext()){
            System.out.println(sitr.next());
        }
        System.out.println("------------- finished  ----------------");

        System.out.println("current position of itr: "+sitr.nextIndex());
        //sitr.next();//moves sitr pointer to next -> NoSuchElementException

        //reverse
        System.out.println("------------- Reverse List Iterator ----------------");
        while(sitr.hasPrevious()){
            System.out.println(sitr.previous());
        }
        System.out.println("------------- finished  ----------------");
    }
}
