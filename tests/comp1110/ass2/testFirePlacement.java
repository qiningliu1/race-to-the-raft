package comp1110.ass2;
import org.junit.jupiter.api.Test;
public class testFirePlacement {
    @Test
    public void testFirePlacement(){
        Board board1= new Board(Utility.RECTANGLE_BOARDS[0][0]);
        Board board2= new Board(Utility.SQUARE_BOARDS[0][0]);
        Board board3= new Board(Utility.RECTANGLE_BOARDS[0][1]);
        Board board4= new Board(Utility.SQUARE_BOARDS[0][1]);
        Board testboard = Island.combine4boards(board1,board2,board3,board4);


        String challengeString = "LNSNLASAF00030006030306030606060909030906C000123000940015R31203";

        Island.applyFireCard(testboard,challengeString);

    }
}
//fffbrgprgyypbrgprg
//fffrbpybybpgrbpyby
//fffpgybrrgbypgybrr
//fffbybgypgrgbybgyp
//fffbrgyggrypbrgygg
//fffybpbrybpgybpbry
//fffgygbyrgbygygbyr
//fffgygpbybrpgygpby
//fffrrbrgpygbrrbrgp
//fffbgypbrbypbgypbr
//fffpbrpgygprpbrpgy
//fffyrygyprbgyrygyp
//fffgbbrpbybygbbrpb
//fffpggbygygrpggbyg
//fffpypgrrbbypypgrr

//F 00,03 00,06 03,03 06,03 06,06 06,09 09,03 09,06

////fffffffffyypbrgprg
////fffffffffbpgrbpyby
////fffffffffgbypgybrr
////ffffffgypgrgbybgyp
////ffffffyggrypbrgygg
////ffffffbrybpgybpbry
////ffffffffffffgygbyr
////ffffffffffffgygpby
////fffrrxffffffrrbrgp
////ffffffpbrbypbgypbr
////fffffffffgprpbrpgy
////fffffffffrbgyrygyp
////fffgbbfffybygbbrpb
////fffpggbygygrpggbyg
////fffpypgrrbbypypgrr

//ffffffffffffbrgprg
//ffffffffffffrbpyby
//ffffffffffffpgybrr
//ffffffffffffbybgyp
//ffffffffffffbrgygg
//ffffffffffffybpbry
//ffffffffffffgygbyr
//ffffffffffffgygpby
//ffffffffffffrrbrgp
//ffffffffffffbgypbr
//ffffffffffffpbrpgy
//ffffffffffffyrygyp
//fffgbbrpbybygbbrpb
//fffpggbygygrpggbyg
//fffpypgrrbbypypgrr