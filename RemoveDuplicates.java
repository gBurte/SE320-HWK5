import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> airplaneList = new ArrayList<>();
        airplaneList.add("Boeing 747");
        airplaneList.add("Airbus A380");
        airplaneList.add("Boeing 747");
        airplaneList.add("Embraer E190");

        System.out.println("This is the Original List: " + airplaneList);

        removeDuplicates(airplaneList);
        System.out.println("List after removing duplicates: " + airplaneList);
    }
    public static void removeDuplicates(List<String> lst) {
        if (lst == null || lst.size() == 0) return;


        HashSet<String> uniqueSet = new HashSet<>();
        Iterator<String> iterator = lst.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            if (!uniqueSet.add(element)) {
                iterator.remove();
            }
        }
    }
}
