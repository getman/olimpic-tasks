import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by ArtemParfenov on 31.01.2018.
 */
public class Banners {
    private static TreeMap<Integer, String> elements;
    public static void main(String [] args) {
        int n = 10000000;
        init();
        Random r = new Random();
        TreeMap<String, Integer> counts = new TreeMap<String, Integer>();
        Integer maxWeight = elements.lastKey();
        for (int i = 0; i < n; i++) {
            Integer rnd = r.nextInt(maxWeight);
            String bannerName = getElement(rnd);

            if (counts.containsKey(bannerName)) {
                Integer cnt = (Integer)counts.get(bannerName);
                counts.put(bannerName, cnt + 1);
            } else {
                counts.put(bannerName, 1);
            }
        }

        for (Map.Entry nextEntry: counts.entrySet()) {
            DecimalFormat myFormatter = new DecimalFormat("0.0000000");
            System.out.println(nextEntry.getKey() + "=" +
                    nextEntry.getValue() + "["
                    + myFormatter.format((double)counts.lastEntry().getValue()/(double)((Integer)nextEntry.getValue()).intValue())
                    + "]"
            );
        }
    }

    private static void init() {
        elements = new TreeMap<Integer, String>();
        addElement(1, "Banner1");
        addElement(2, "Banner2");
        addElement(3, "Banner3");
        addElement(4, "Banner4");
        addElement(5, "Banner5");
        addElement(6, "Banner6");
        addElement(7, "Banner7");
        addElement(8, "Banner8");
        addElement(9, "Banner9");
    }

    private static void addElement(Integer weight, String bannerName) {
        int maxWeight = 0;
        if (elements.size() > 0) {
            maxWeight = elements.lastKey();
        }
        elements.put(maxWeight + weight, bannerName);
    }

    private static String getElement(Integer rnd) {
        Map.Entry<Integer, String> ceilingEntry = elements.ceilingEntry(rnd);
        if (ceilingEntry == null) {
            return elements.firstEntry().getValue();
        }
        //avoiding equal keys, only rnd less then "weight" key
        if (ceilingEntry.getKey().equals(rnd)) {
            return elements.higherEntry(ceilingEntry.getKey()).getValue();
        } else {
            return ceilingEntry.getValue();
        }
    }
}
