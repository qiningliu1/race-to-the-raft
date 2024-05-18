package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChallengeParser {

    public static void main(String[] args) {

        String challenge = "SASNSNSAF0000001206090903C2000630300R20015";
        Map<newTileType, String> parsedData = parseChallenge(challenge);
        Map<Integer, List<Integer>> parseFireLocations = parseFireLocations(challenge);
        List<Integer> row1=parseFireLocations.get(0);
        List<Integer> row3=parseFireLocations.get(9);
        for (int i = 0; i < 18; i++) {
            if(parseFireLocations.containsKey(i)){
               List<Integer> column= parseFireLocations.get(i);
                for (int j = 0; j < column.size(); j++) {
                    int columnTemp = column.get(j);
                    //添加图片
                }
            }
        }

        System.out.println(parseFireLocations);
        Map<Integer,List<Location>> parseCatLocations = parseCatLocations(challenge);
        Map<Integer, List<List<Integer>>> pairCord = Location.convertLocationMap(parseCatLocations);

        System.out.println(pairCord);
        System.out.println(pairCord.size());

        System.out.println(parseCatLocations);
        System.out.println(parseRaftLocations(challenge));

      List<Location> test1=  parseCatLocations.get(2);
     List<List<Integer>> test1transfer = Location.catLocations(test1);
        System.out.println(test1transfer);


        System.out.println("Board: " + parsedData.get(newTileType.None));
        System.out.println("Fire: " + parsedData.get(newTileType.Fire));
        System.out.println("Cat: " + parsedData.get(newTileType.Cat));
        System.out.println("Raft: " + parsedData.get(newTileType.Object));

    }

//    public static Map<TileType, String> parseChallenge(String challenge) {
//        String[] splitData = challenge.split("F|C|R");
//        Map<TileType, String> challengeMap = new HashMap<>();
//
//        // 根据实际情况调整枚举的使用
//        challengeMap.put(TileType.None, splitData[0]);
//        if (splitData.length > 1) challengeMap.put(TileType.Fire, "F" + splitData[1]);
//        if (splitData.length > 2) challengeMap.put(TileType.Cat, "C" + splitData[2]); // 假设使用BLUE_CAT代表Cat
//        if (splitData.length > 3) challengeMap.put(TileType.Object, "R" + splitData[3]); // 假设使用None代表Raft
//
//        return challengeMap;
//    }

   public static String getFireString(String challenge ){
       Map<newTileType, String> parsedData = parseChallenge(challenge);
       String fireString = parsedData.get(newTileType.Fire);
       return fireString;
   }



    public static Map<newTileType, String> parseChallenge(String challenge) {
        String[] splitData = challenge.split("F|C|R");
        Map<newTileType, String> challengeMap = new HashMap<>();

        // 添加拆分后的数据到 map 中
        challengeMap.put(newTileType.None, splitData[0]);
        if (splitData.length > 1) challengeMap.put(newTileType.Fire, "F" + splitData[1]);
        if (splitData.length > 2) challengeMap.put(newTileType.Cat, "C" + splitData[2]);
        if (splitData.length > 3) challengeMap.put(newTileType.Object, "R" + splitData[3]);

        return challengeMap;
    }


//    private static Map<Integer, Integer> parseFireLocations(String fireData) {
//        Map<Integer, Integer> locations = new HashMap<>();
//        if (fireData.length() > 1) { // 确保除了"F"外还有坐标数据
//            fireData = fireData.substring(1); // 去掉"F"
//            for (int i = 0; i < fireData.length(); i += 4) {
//                if (i + 4 <= fireData.length()) {
//                    int row = Integer.parseInt(fireData.substring(i, i + 2));
//                    int col = Integer.parseInt(fireData.substring(i + 2, i + 4));
//                    locations.put(row, col);
//                }
//            }
//        }
//        return locations;
//    }

    public static Map<Integer, List<Integer>> parseFireLocations(String challenge) {
       String fireData = getFireString(challenge);
        Map<Integer, List<Integer>> locations = new HashMap<>();
        if (fireData.length() > 1) { // 确保除了"F"外还有坐标数据
            fireData = fireData.substring(1); // 去掉"F"
            for (int i = 0; i < fireData.length(); i += 4) {
                if (i + 4 <= fireData.length()) {
                    int row = Integer.parseInt(fireData.substring(i, i + 2));
                    int col = Integer.parseInt(fireData.substring(i + 2, i + 4));
                    locations.computeIfAbsent(row, k -> new ArrayList<>()).add(col);
                }
            }
        }
        return locations;
    }

    public static Map<Integer,List<Location>> parseCatLocations(String challenge){
        Map<newTileType, String> parsedData = parseChallenge(challenge);
        String catData = parsedData.get(newTileType.Cat);
        Map<Integer, List<Location>> catLocations = new HashMap<>();
        if (catData != null &&catData.length() > 1) {
            catData = catData.substring(1); // 去掉"C"
            for (int i = 0; i < catData.length(); i += 5) {
                if (i + 5 <= catData.length()) {
                    int id = Integer.parseInt(catData.substring(i, i + 1));
                    int row = Integer.parseInt(catData.substring(i + 1, i + 3));
                    int col = Integer.parseInt(catData.substring(i + 3, i + 5));
                    catLocations.computeIfAbsent(id, k -> new ArrayList<>()).add(new Location(row, col));
                }
            }
        }
        return catLocations;
    }

    public static Map<Integer, List<Location>> parseRaftLocations(String challenge) {
        Map<newTileType, String> parsedData = parseChallenge(challenge);
        String raftData = parsedData.get(newTileType.Object);
        Map<Integer, List<Location>> raftLocations = new HashMap<>();
        System.out.println("Raft data: " + raftData); // 调试输出
        if (raftData != null && raftData.length() > 1) {
            raftData = raftData.substring(1); // 去掉 "R"
            System.out.println("Processed Raft data: " + raftData); // 调试输出
            for (int i = 0; i < raftData.length(); i += 5) {
                if (i + 5 <= raftData.length()) {
                    int id = Integer.parseInt(raftData.substring(i, i + 1));
                    int row = Integer.parseInt(raftData.substring(i + 1, i + 3));
                    int col = Integer.parseInt(raftData.substring(i + 3, i + 5));
                    System.out.printf("Raft ID: %d, Row: %d, Col: %d%n", id, row, col); // 调试输出
                    raftLocations.computeIfAbsent(id, k -> new ArrayList<>()).add(new Location(row, col));
                }
            }
        }
        return raftLocations;
    }

















}
