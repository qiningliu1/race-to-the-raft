package comp1110.ass2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FireTiles {
    private static String fireTileBag;
    private static int length;
    private List<Character> fireTileIDs;


    /**
     *The main requirements are:
     *
     * 1.Randomly selects an ID from a string containing the flame tile ID.
     * 2.Make sure this ID is valid.
     * 3.Update the string storing the ID to reflect that an ID has been extracted.
     *
     */
    public static final String[] FIRE_TILES = {
            "a000110111221",
            "b000102102021",
            "c000102031121",
            "d000102121314",
            "e000111122021",
            "f000102101120",
            "g000102111213",
            "h0001021121",
            "i011011121321",
            "j001011121322",
            "k0001021020",
            "l000111121322",
            "m00011112",
            "n0001112021",
            "o000102101121",
            "p0001111213",
            "q000102031112",
            "r0001111222",
            "s000110111222",
            "t0001020310",
            "u000102101213",
            "v000102031012",
            "w0010111222",
            "x0110111221",
            "y0001111221",
            "z00101120",
            "A0001020311",
            "B000102112122",
            "C0001021011",
            "D000102031011",
            "E000102121323",
    };

    /**
     *  Build a constructor
     *  use for-each loop to add every element ID in to the list
     *  In constructor it's the initial full fireTile bag from a-z and A-E
     */
    public FireTiles(){
        fireTileIDs = new ArrayList<>();
        for (String tile: FIRE_TILES){
            fireTileIDs.add(tile.charAt(0));
        }
    }

    /**
     * This construct method is for receive a string of fire tile bag
     *
     */

    public FireTiles(String initialFireTileBag) {
        fireTileIDs = new ArrayList<>();
        for (char ID : initialFireTileBag.toCharArray()) {
            fireTileIDs.add(ID);
        }
    }

    /**
     * If empty return""
     * select random number than index to remove that index character;
     */

    public String drawFireTileID() {
        if (fireTileIDs.isEmpty()) {
            //throw new IllegalStateException("No more tiles available.");
            return "";
        }

        Random random = new Random();
        int index = random.nextInt(fireTileIDs.size());
        return String.valueOf(fireTileIDs.remove(index));
    }

    /**
     * update Bag element after random draw
     *
     */
    public String getUpdateFireBagState(){
        //Method1-StringBuilder
        //        StringBuilder newString = new StringBuilder();
        //        for(Character ID: fireTileIDs){
        //            newString.append(newString);
        //        }
        //        return  newString.toString();

        //Method2-regular
        String result = "";
        for(Character ID : fireTileIDs){
            result += ID;
        }
        return result;
    }







}
