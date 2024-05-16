package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */
import java.util.*;

/**
 * This class encodes a certain cartesian coordinate system (row, column).
 * We can use the object in this class to solve coordination related problem.
 * within the class of FireCards, PathwayCards, Hand Cards, and FireTiles.
 */

public class Location implements Comparable<Location>{

    private static newTileType square;

    private int row;
    private int column;

    private int[][] pairCord;

    /**
     * A default "out-of-bounds" coordinate
     */
    static final int OUT = -1;

    /**
     * Initialize a Location that is not on the board
     */
    public Location() {
        this.row = OUT;
        this.column = OUT;
    }

    /**
     * Create a new location, given an x- and y-coordinate.
     * @param row - x coordinate
     * @param column - y coordinate
     */

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }



    /**
     * This constructor can be used to figure out the two coordinates input case
     * ie-> Challenge string of Fire, Cat, Raft all use pair coordinates
     * the string "01" corresponds to the location(0,1).
     *
     * The details may be tricky here because we need to cope with substring wisely
     * like
     *
     * we can make some test to do the experiment
     *
     * @param coordinates
     */

    public Location(String coordinates) {
        if (coordinates.length() >= 4) {
            this.row = Integer.parseInt(coordinates.substring(0, 2));
            this.column = Integer.parseInt(coordinates.substring(2, 4));
        } else {
            //This step is quiet smart which can put illegal Tile out of the board
            this.row = OUT;
            this.column = OUT;
        }
    }

    public  void pathwayCardPlacement(String coordinates){
        if (coordinates.length() >= 6) {
            this.row = Integer.parseInt(coordinates.substring(2, 4));
            this.column = Integer.parseInt(coordinates.substring(4, 6));
        } else {
            //This step is quiet smart which can put illegal Tile out of the board
            this.row = OUT;
            this.column = OUT;
        }

    }






    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }



    public List<Location> locationListFromString(List<String> Cord){

        List<Location> locationList= new ArrayList<>();

        Location location = new Location("");

        for (int i = 0; i < Cord.size(); i++) {
            String temp = Cord.get(i);
            for (int j = 0; j < temp.length(); j++) {
               int locationCode=Integer.parseInt(temp.substring(0));
            }
        }
        return null;
    }

    public Map<newTileType,int[][]> ListCordFromLocation(Map<newTileType, String> TileCord){

        Map<newTileType,int[][]> TileChllengeMap = new HashMap<>();

        int TileSize =  TileCord.size();
        pairCord = new int[TileSize][2];

        for (int i = 0; i < TileSize; i++) {
           newTileType tile = newTileType.valueOf(TileCord.get(i));

           // Fire case
           if(tile.equals(newTileType.Fire)){

             String fireData = TileCord.get(newTileType.Fire);
               if (fireData != null && fireData.length() > 1) { // 确保有坐标数据
                   fireData = fireData.substring(1); // 去掉"F"
                   for (int j = 0; j < fireData.length(); j += 4) {
                       if (j + 4 <= fireData.length()) {
                           int row = Integer.parseInt(fireData.substring(j, j + 2));
                           int col = Integer.parseInt(fireData.substring(j + 2, j + 4));

                       }
                   }
               }

         }

        }
return null;
    }







    /**
     * Use this as object to judge whether the current location is on board or
     * hang out the board
     * @return True on board False out Board
     */
    public boolean isOnBoard(int boardSize){
        return this.row >= 0 && this.row < boardSize && this.column >= 0 && this.column <= boardSize;
    }

    /**
     * Given an orientation, find the Location adjacent to this location
     * in the direction of that orientation.
     * Note: this method does not check whether a Location is on the board.

     * @param newOrientation the given orientation
     * @return the location pointed to by the given orientation.
     */

    public Location getAdjacentLocation(newOrientation newOrientation) {
        switch (newOrientation){
            case NORTH:
                return new Location(row-1,column);
            case SOUTH:
                return new Location(row+1,column);
            case EAST:
                return new Location(row,column+1);
            case WEST:
                return new Location(row,column-1);
            default:
                return new Location();//out of bound

        }

    }

    /**
     * Checks whether this Location is the same as a given other Location.
     * For this to be true,
     * the x and y values of this object must be
     * the same as the x and y values of the other object.
     *
     * @param other card Location
     * @return Ture if overlap, False means freedom put
     */

    public boolean equals(Location other) {
        return this.row == other.row && this.column == other.column;
    }


    public static List<List<Integer>> catLocations(List<Location> catLocationList){

        List<List<Integer>> catPairCord = new ArrayList<>();
        for (int LocationListIndex = 0; LocationListIndex <catLocationList.size(); LocationListIndex++) {
            Location catlocation = catLocationList.get(LocationListIndex);
            List<Integer> singlePairCord = new ArrayList<>();
            int catRowCord = catlocation.row;
            int catColCord = catlocation.column;
            singlePairCord.add(catRowCord);
            singlePairCord.add(catColCord);
            catPairCord.add(singlePairCord);
        }

        return catPairCord;
    }

    /**
     * This method help us to transfer Location data to CoordinateList
     * @param locationMap
     * @return
     */

    public static Map<Integer, List<List<Integer>>> convertLocationMap(Map<Integer, List<Location>> locationMap) {
        Map<Integer, List<List<Integer>>> result = new HashMap<>();
        for (Map.Entry<Integer, List<Location>> entry : locationMap.entrySet()) {
            List<List<Integer>> convertedList = new ArrayList<>();
            for (Location loc : entry.getValue()) {
                List<Integer> pair = Arrays.asList(loc.getRow(), loc.getColumn());
                convertedList.add(pair);
            }
            result.put(entry.getKey(), convertedList);
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return row == location.row && column == location.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + '}';
    }


    /**
     * This method is not implement yet
     * @param other
     * @return
     */
    public int compareTo(Location other) {
        if (this.row == other.row) {
            return Integer.compare(this.column, other.column);
        }
        return Integer.compare(this.row, other.row);
    }




}
