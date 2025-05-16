import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Exercise given by Affirm for the technical interview.
// Role: Early Career

public class logs {
    // Log contains the following information:
    // - date of the purchase
    // - type of product bought
    // - id of the product bought
    // - price of the product bought
    private static final String[] log1 = {"01/01/2025,Type 1,id1,1",
                                            "01/01/2025,Type 1,id2,2", 
                                            "01/01/2025,Type 2,id3,3",
                                            "01/01/2025,Type 1,id3,4" 
                                        };
    private static final String[] log2 = {"02/01/2025,Type 1,id1,5",
                                            "02/01/2025,Type 3,id4,6", 
                                            "02/01/2025,Type 3,id1,7",
                                            "02/01/2025,Type 1,id2,8"
                                        };

    // Find id of people who:
    // - Have bought in two different dates
    // - Have bought at least you types of products
    // Note: in this case, result should be [id1]
    public static void main(String[] args) {
        Map<String, Set<String>> idToDates = new HashMap<>();
        Map<String, Set<String>> idToTypes = new HashMap<>();

        processLog(log1, idToDates, idToTypes);
        processLog(log2, idToDates, idToTypes);

        List<String> result = new ArrayList<>();
        for (String id : idToDates.keySet())
            if (idToDates.get(id).size() >= 2 && idToTypes.get(id).size() >= 2)
                result.add(id);

        System.out.println(result);
    }

    private static void processLog(String[] log, Map<String, Set<String>> idToDates, Map<String, Set<String>> idToTypes) {
        for (String entry : log) {
            String[] parts = entry.split(",");
            String date = parts[0];
            String type = parts[1];
            String id = parts[2];

            // Add the date to the set of dates for the ID
            idToDates.computeIfAbsent(id, k -> new HashSet<>()).add(date);

            // Add the type to the set of types for the ID
            idToTypes.computeIfAbsent(id, k -> new HashSet<>()).add(type);
        }
    }
}
