import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneralizedSecondPrice {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int numberOfBids = scan.nextInt();
        int scanCounter = 0;

        SortedMap<Integer, List<String>> bids = new TreeMap<>(Comparator.reverseOrder());

        while (scanCounter<numberOfBids){
           String name = scan.next();
           int bid = scan.nextInt();
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
        // this for mark last user(this loser made write all of this for him :D)  in the list as lost
        AtomicInteger lastIndex = new AtomicInteger(1);
        bids.entrySet().forEach(x-> {x.getValue().sort(String::compareTo);
            x.getValue().forEach(u->{
                if(lastIndex.get()==numberOfBids)
                    System.out.println(u+"  "+"Lost");
               else
                   System.out.println(u+"  "+x.getKey());

                lastIndex.getAndIncrement();

            });

        }
        );
    }
}
