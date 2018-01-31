import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by ArtemParfenov on 31.01.2018.
 */
public class Banners {
    private static TreeMap<Integer, String> elements;
    public static void main(String [] args) {
        int n = 1000000;
        init();
        Random r = new Random();
        TreeMap<String, Integer> counts = new TreeMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            Integer maxWeight = elements.lastKey();
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
            System.out.println(nextEntry.getKey() + "=" + nextEntry.getValue());
        }
    }

    private static void init() {
        elements = new TreeMap<Integer, String>();
        addElement(elements, 1, "Banner1");
        addElement(elements,2, "Banner2");
        addElement(elements,3, "Banner3");
        addElement(elements,4, "Banner4");
        addElement(elements,5, "Banner5");
        addElement(elements,6, "Banner6");
        addElement(elements,7, "Banner7");
        addElement(elements,8, "Banner8");
        addElement(elements,9, "Banner9");
    }

    private static void addElement(TreeMap tm, Integer weight, String bannerName) {
        int maxWeight = 0;
        if (elements.size() > 0) {
            maxWeight = elements.lastKey();
        }
        elements.put(maxWeight + weight, bannerName);
    }

    private static String getElement(Integer rnd) {
        Map.Entry<Integer, String> ceilingEntry = elements.ceilingEntry(rnd);
        return ceilingEntry.getValue();
    }
}
