// Online Java Compiler
// Use this editor to write, compile and run your Java code online


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
class TEST
{
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int numberOfBids = scan.nextInt();
        int scanCounter = 0;

        SortedMap<Integer, List<String>> bids = new TreeMap<>(Comparator.reverseOrder());
        if(numberOfBids==0)System.out.println("no bids found");
        while (scanCounter<numberOfBids){
            String name = scan.next();
            int bid = scan.nextInt();

            if(numberOfBids==1){
                System.out.println(name +"  "+bid);
                return;
            }
            if (bids.containsKey(bid))
            {
                List<String > updated=bids.get(bid);
                updated.add(name);
                bids.put(bid,updated);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(name);
                bids.put(bid, list);
            }
            scanCounter++;
        }
        Map<Integer, List<String>> result = new TreeMap<>(Comparator.reverseOrder());
        boolean flag=true;
        List<String> valueBefore = null;
        Map.Entry<Integer,List<String>> lastEle;
        for (Map.Entry<Integer,List<String>> e:bids.entrySet()){
            if(flag){
                valueBefore=e.getValue();
                flag=false;
                continue;
            }
            result.put(e.getKey(),valueBefore);
            valueBefore=e.getValue();
        }
        result.put(Integer.MIN_VALUE,valueBefore);
        // this for mark last user(this loser made write all of this for him :D)  in the list as lost
        result.entrySet().forEach(x-> {x.getValue().sort(String::compareTo);
                    x.getValue().forEach(u->{
                            if (x.getKey()==Integer.MIN_VALUE)
                                System.out.println(u+"  "+"lose the auction");
                            else
                            System.out.println(u+"  "+x.getKey());
                    });

                }
        );
    }
}
