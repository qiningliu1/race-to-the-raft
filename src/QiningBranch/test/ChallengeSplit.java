package QiningBranch.test;

import QiningBranch.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChallengeSplit {

    public static void main(String[] args) {

        String challenge = "SNSNSASAFC1000930003300154000650012R30909";
        Map<String, String> parsedChallenge = parseChallengeString(challenge);

        List<String> challengeList=challengeList(challenge);

        System.out.println(challengeList);

        String fire=parsedChallenge.get("F");
        Map<String,String> fireMap= parseFireLocations(parsedChallenge.get("F"));

        System.out.println(fireMap);

        List<String > keys = new ArrayList<>();
       for(Map.Entry<String,String> entry : fireMap.entrySet()){

           String key = entry.getKey();
           String value = entry.getValue();
           keys.add(key);
       }
        System.out.println(keys);


        System.out.println(keys.get(0));

        String[] parts = keys.get(0).split(",");
        int row = Integer.parseInt(parts[0]);
        int column = Integer.parseInt(parts[1]);

        System.out.println(row);
        System.out.println(column);

        System.out.println("Island substring: " + parsedChallenge.get("L"));
        System.out.println("Fire substring: " + parsedChallenge.get("F"));
        System.out.println("Cat substring: " + parsedChallenge.get("C"));
        System.out.println("Raft substring: " + parsedChallenge.get("R"));

    }


    public static Map<String, String> parseChallengeString(String challenge) {
        Map<String, String> parts = new HashMap<>();

        // 正则表达式匹配F、C、R字符
        Matcher matcher = Pattern.compile("([FCR])").matcher(challenge);
        int lastPosition = 0;
        String lastKey = "L";  // 假设 "L" 为 "Island" 部分的标识符

        // 检查是否有匹配，并确保最初的部分被正确记录
        if (matcher.find()) {
            // 第一部分始终为 "Island" 部分
            parts.put(lastKey, challenge.substring(0, matcher.start()));
            lastPosition = matcher.start();
            lastKey = matcher.group(1); // 获取当前匹配到的字符(F, C, 或 R)

            // 遍历后续匹配
            while (matcher.find()) {
                parts.put(lastKey, challenge.substring(lastPosition + 1, matcher.start()));
                lastKey = matcher.group(1);
                lastPosition = matcher.start();
            }

            // 添加最后一部分
            if (!lastKey.isEmpty() && lastPosition < challenge.length()) {
                parts.put(lastKey, challenge.substring(lastPosition + 1));
            }
        }

        return parts;
    }


    // 根据类型解析不同的子串
    private static Object parseSubstring(String type, String data) {
        if (type.equals("F")) {
            return parseFireLocations(data);
        } else {
            return data;
        }
    }

    // 解析火卡的位置，注意同一个横坐标由于哈希表，一个键只能有一个值，所以后续会被覆盖
    private static Map<String, String> parseFireLocations(String fireData) {
        Map<String, String> locations = new HashMap<>();

        List<Location[][]> fireCord = new ArrayList<>();


        for (int i = 0; i < fireData.length(); i += 4) {
            int row = Integer.parseInt(fireData.substring(i, i + 2));
            int col = Integer.parseInt(fireData.substring(i + 2, i + 4));

            Location[][] temp = new Location[row][col];

            String a=temp.toString();

            fireCord.add(temp);


            // 使用行和列组合作为键
            String key = row + "," + col;
            locations.put(key, "F");  // 1 作为占位符，表示该位置有火卡
        }
        System.out.println(fireCord);
        return locations;
    }



    public static  List<String > fireLocationKeys(String challenge){
        Map<String, String> parsedChallenge = parseChallengeString(challenge);
        String fire=parsedChallenge.get("F");
        Map<String,String> fireMap= parseFireLocations(fire);
        System.out.println(fireMap);
        List<String > keys = new ArrayList<>();
        for(Map.Entry<String,String> entry : fireMap.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            keys.add(key);
        }
        System.out.println(keys);
        return keys;
    }



    public static List<String> challengeList(String challenge){
        String[] challengeArray = challenge.split("F|C|R");
        List<String> challengeList = new ArrayList<>();
        challengeList.add(challengeArray[0]);
        challengeList.add(challengeArray[1]);
        challengeList.add(challengeArray[2]);
        challengeList.add(challengeArray[3]);
        return challengeList;
    }








//    private static Location[][] parseFireCoordinates(List<String> fireCord) {
//
//        fireCord = fireLocationKeys();
//
//
//
//
//
//        String[] parts = key.split(",");
//        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
//    }





}
