//package comp1110.ass2;
//
//
///**
// * The Island class represents the island in the game.
// * It includes the layout of the island and methods for building pathways.
// */
//import java.util.Random;
//
//public class IslandBoard {
//    private Orientation orientation;
//    private char size;
//    private int height;
//    private int width;
//    public Location[] catLocations;
//    public Card[][] cards;
//    public static IslandBoard[][] squareBoards;
//    public static IslandBoard[][] rectangleBoards;
//
//    // 构造函数，根据给定的字符串初始化岛屿板
//    public IslandBoard(String islandBoard) {
//        initializeIslandBoard(islandBoard);
//    }
//
//    // 根据字符串初始化岛屿板
//    private void initializeIslandBoard(String islandBoard) {
//        String[] boardRows = islandBoard.split("\n");
//        width = boardRows[0].length();
//        height = boardRows.length;
//        if (height == 9 && width == 9) {
//            size = 'L';
//        } else if (height == 6 && width == 9) {
//            size = 'S';
//        } else {
//            size = 'I'; // The string represents the whole island board, not a board.
//        }
//        cards = new Card[height][width];
//        orientation = Orientation.NORTH;
//        if (size == 'I') {
//            catLocations = new Location[5];
//        }
//        int catNumber = 0;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                char character = boardRows[i].charAt(j);
//                if (Character.isUpperCase(character)) {
//                    Location catLocation = new Location(i, j);
//                    character = Character.toLowerCase(character);
//                    catLocations[catNumber] = catLocation;
//                    catNumber++;
//                }
//                cards[i][j] = new Card(Tiles.fromChar(character));
//            }
//        }
//    }
//
//    // 创建正方形板
//    public static IslandBoard[][] createSquareBoards(String[][] squareBoards) {
//        IslandBoard[][] squareBoardsArray = new IslandBoard[4][2];
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 2; j++) {
//                squareBoardsArray[i][j] = new IslandBoard(squareBoards[i][j]);
//            }
//        }
//        return squareBoardsArray;
//    }
//
//    // 创建长方形板
//    public static IslandBoard[][] createRectangleBoards(String[][] rectangleBoards) {
//        IslandBoard[][] rectangleBoardsArray = new IslandBoard[4][2];
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 2; j++) {
//                rectangleBoardsArray[i][j] = new IslandBoard(rectangleBoards[i][j]);
//            }
//        }
//        return rectangleBoardsArray;
//    }
//
//    // 根据尺寸和方向创建新板
//    public static IslandBoard newBoard(char size, Orientation orientation) {
//        Random random = new Random();
//        int randomNumber = random.nextInt(4);
//        boolean fire = false;
//        if (size == 'L' && orientation == Orientation.NONE) {
//            return squareBoards[randomNumber][0];
//        } else if (size == 'S' && orientation == Orientation.NONE) {
//            return rectangleBoards[randomNumber][0];
//        } else if (size == 'L' && orientation != Orientation.NONE) {
//            return squareBoards[randomNumber][1];
//        } else {
//            return rectangleBoards[randomNumber][1];
//        }
//    }
//
//    public static IslandBoard newBoard(char size, int boardNumber, boolean fire) {
//        if (boardNumber < 0 || boardNumber > 3) {
//            throw new IllegalArgumentException("The board number is out of range.");
//        } else if (size == 'L') {
//            return fire ? squareBoards[boardNumber][1] : squareBoards[boardNumber][0];
//        } else if (size == 'S') {
//            return fire ? rectangleBoards[boardNumber][1] : rectangleBoards[boardNumber][0];
//        }
//        return null;
//    }
//
//
//    public int getHeight() {
//        return height;
//    }
//
//    // 获取岛屿板的宽度
//    public int getWidth() {
//        return width;
//    }
//
//    // 设置方向
//    public void setOrientation(Orientation orientation) {
//        this.orientation = orientation;
//    }
//}
//
//
