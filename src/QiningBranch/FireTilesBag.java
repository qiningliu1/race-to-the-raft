package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */
import comp1110.ass2.Utility;

import java.util.*;

public class FireTilesBag {
    public List<FireTiles> fireTiles;
    private Map<String,String> tileMap;
    public FireTiles drawnTile;

    public FireTilesBag(){
    this.fireTiles = new ArrayList<>();
    tileMap = new HashMap<>();
    }

    private void initializeTileMap(){
        String[] totalTiles =Utility.FIRE_TILES;
        for (String tile : totalTiles){
            tileMap.put(tile.substring(0,1),tile);
        }
    }

    private void initializeTiles(){
        // each id in the ketSet correspond to a value in Map
        for (String id : tileMap.keySet()){
            String tileData = tileMap.get(id);
            if(tileData!=null){
                this.fireTiles.add(new FireTiles(id,parseCoordinates(tileData.substring(1))));
            }
        }
    }


    public static List<String> initialTotal(){
        List<String> totalFireTiles = new ArrayList<>(Arrays.asList(Utility.FIRE_TILES));
        return totalFireTiles;
    }

//    public void initializeTiles(){
//
//        for(String tileData:Utility.FIRE_TILES){
//
//            this.fireTiles.add(new FireTiles(tileData.substring(0,1),parseCoordinates(tileData.substring(1))));
//        }
//    }


    private List<int[]> parseCoordinates(String data){
        List<int[]> position = new ArrayList<>();
        for(int i = 0; i<data.length();i+=2){
            int x = Character.getNumericValue(data.charAt(i));
            int y = Character.getNumericValue(data.charAt(i+1));
            position.add(new int[]{x,y});
        }
        return position;
    }

    public void addTile(FireTiles tiles){
        fireTiles.add(tiles);
    }
    public List<FireTiles> getFireTiles() {
        return fireTiles;
    }
    public void setFireTiles(List<FireTiles> fireTiles) {
        this.fireTiles = fireTiles;
    }
    public FireTiles drawFireTile(){
        if(this.fireTiles.isEmpty()){
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(this.fireTiles.size());
        drawnTile = this.fireTiles.get(index);
        return drawnTile;
    }
    public boolean CheckDrawnTileInfo(){
        this.drawnTile = drawnTile;
        char id = drawnTile.singleID.charAt(0);
        return (id >= 'a' && id <= 'z') || (id >= 'A' && id <= 'E');
    }

    /**
     * Ensure remove the FireTiles you get info
     */
    public void confirmRemoveTile(){
        this.fireTiles.remove(drawnTile);
        //clear the reference to ensure each of drawn process refresh
        drawnTile = null;
    }
    public static void printCoordinates(List<int[]> coordinates){
        for(int[] pairCord : coordinates){
            System.out.println(Arrays.toString(pairCord));
        }

    }

    public class FireTiles{
        private String singleID;
        private List<int[]> coordinates; //Storage original coordinate before rotate and flipped
        public FireTiles(){
        }

        public FireTiles(String singleID, List<int[]> originalCoordinates) {
            this.singleID = singleID;
            this.coordinates = originalCoordinates;
        }

        public  String transferCoordinates(List<int[]> coordinates){
            StringBuilder sb = new StringBuilder();

            for(int[] pairCord : coordinates){
                sb.append(Arrays.toString(pairCord));
            }
            return sb.toString();
        }



        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.singleID);


            return "FireTiles{" +
                    "singleID='" + singleID + '\'' +
                    ", coordinates=" + this.transferCoordinates(coordinates) +
                    '}';
        }

        /**
         * This part is for method of action placement-(rotation,flipped)
         * Fire tile placement strings are defined as follows:
         * {ID}{row}{column}{flipped}{orientation}
         * ie:"l0003TW" tells us that the tile l is placed at (0,3) in the West orientation and has been flipped.
         * @param placementString
         */
        public void placeTile(String placementString){
            char flipped = placementString.charAt(5);
            char orientation = placementString.charAt(6);
            if(flipped =='T'){
                    //flipVertical();
            }

            //rotateToOrientation(orientation);

        }

        private void flipVertical(){
            //ie flip all the coordinates
            for(int[] cord:coordinates){
                cord[1] = -cord[-1];//flip column coordinates
            }
        }


        private void rotateToOrientation(char orientation){
            //rotation based on orientation
            switch (orientation){
                case 'N':// Face North without rotation
                    break;
                case 'E':// rotate clockwise 90 degrees
                    coordinates.forEach(cord ->{
                        int temp = cord[0];
                        cord[0] = -cord[1];
                        cord[1] = temp;
                    });
                    break;

                case'S':// rotate clockwise 180 degrees
                    coordinates.forEach(cord->{
                        cord[0] = -cord[0];
                        cord[1] = -cord[1];
                    });
                    break;

                case'W':// rotate clockwise 270 degrees
                    coordinates.forEach(cord->{
                        int temp = cord[0];
                        cord[0] = cord[1];
                        cord[1] = -temp;
                    });
                    break;
            }
        }


    }

    @Override
    public String toString() {
        return "FireTilesBag{" +
                "fireTiles=" + fireTiles +
                ", tileMap=" + tileMap +
                ", drawnTile=" + drawnTile +
                ", coordinates=" +'}'+ this.drawnTile.transferCoordinates(drawnTile.coordinates);

    }
    /**
     * This Part for test
     * @param args
     */
    public static void main(String[] args) {
       FireTilesBag fireTilesBag1= new FireTilesBag();
        //input data
       fireTilesBag1.initializeTileMap();
       //allocate key
        fireTilesBag1.initializeTiles();

       FireTiles fireTiles1= fireTilesBag1.drawFireTile();
        System.out.println("fireTiles1");
        System.out.println(fireTiles1);
       String key1 = fireTiles1.singleID;

       String value1 = fireTilesBag1.tileMap.get(key1);

       List<int []> position1 =fireTilesBag1.parseCoordinates(value1.substring(1));



        System.out.println(key1);
        System.out.println(value1);
        System.out.println(position1);
        printCoordinates(position1);

        fireTiles1.rotateToOrientation('E');
        System.out.println(fireTiles1.coordinates);

    }


}


