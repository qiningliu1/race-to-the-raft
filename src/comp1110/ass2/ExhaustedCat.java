package comp1110.ass2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class ExhaustedCat {

    String exCat;
    public ExhaustedCat(String exCat){
        this.exCat = exCat;
    }

    private Tiles[][] exhaustedCat;

    // Constructor to initialize the exhaustedCat array
    public ExhaustedCat(int Rows, int Cols) {
        this.exhaustedCat = new Tiles[Rows][Cols];
    }

    /**
     * Add an exhausted cat to the array.
     *
     * @param color  The color of the cat.
     * @param row    The row coordinate of the cat.
     * @param column The column coordinate of the cat.
     */
    public void addExhaustedCat(Tiles color, int row, int column) {
        // Check if the row and column coordinates are within bounds
        if (row >= 0 && row < exhaustedCat.length && column >= 0 && column < exhaustedCat[0].length) {
            exhaustedCat[row][column] = color;
        }
    }

    /**
     * Get the string representation of exhausted cats.
     *
     * @return String representing the exhausted cats.
     */
    public String getExhaustedCat() {
        // Create a StringBuilder to build the string representation of exhausted cats
        StringBuilder sb = new StringBuilder();

        //create a list to store exhausted cat string to sorting below
        List<String> catStrings = new ArrayList<>();

        // Append each exhausted cat string to the list
        for (int i = 0; i < exhaustedCat.length; i++) {
            for (int j = 0; j < exhaustedCat[0].length; j++) {
                if (exhaustedCat[i][j] != null) {
                    catStrings.add(String.format("%c%02d%02d", exhaustedCat[i][j].toChar(), i, j));
                }
            }
        }

        //Sort the list of exhausted cat strings
        Collections.sort(catStrings);

        //Append all exhausted cat string to the StringBuilder
        for (String catString: catStrings){
            sb.append(catString);
        }

        // Return the string representation of exhausted cats
        return sb.toString();
    }








}
