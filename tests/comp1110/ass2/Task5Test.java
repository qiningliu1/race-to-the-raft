package comp1110.ass2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)

/**
 * Author @Qining Liu
 * u7100555
 */

public class Task5Test {
    private boolean isLegitID(char id) {
        id = 'a';

        if(id >='a'&& id <='z'){
            return true;
        } else if (id>='A' && id<='E') {
            return true;
        }
        else return false;
    }



    private boolean comesFromBag(char id, String bag) {
        for (int i = 0; i < bag.length(); i++) {
            if (bag.charAt(i) == id) {
                return true;
            }
        }
        return false;
    }


    private void testIsFireTile(String fireTile, String bag) {
        // Extract the first character from fireTile as the ID
        char tileID = fireTile.charAt(0);

        // Validate that the extracted tileID is a legitimate ID
        if (!isLegitID(tileID)) {
            throw new IllegalArgumentException("comp1110.ass2.Tile ID is not legitimate: " + tileID);
        }

        // Check if the tileID is contained within the provided bag
        if (!comesFromBag(tileID, bag)) {
            throw new IllegalArgumentException("comp1110.ass2.Tile ID is not found in the bag: " + tileID);
        }

        // Uncomment and implement the following if coordinates check is needed
        // String coordinates = fireTile.substring(1);
        // if (!areLegitCoordinates(coordinates)) {
        //     throw new IllegalArgumentException("Coordinates are not legitimate: " + coordinates);
        // }
    }



        private static String callDrawFireTile(String[] gameState) {
            // Manually copy the gameState array into a new array
            String[] gameStateCopy = new String[gameState.length];
            for (int i = 0; i < gameState.length; i++) {
                gameStateCopy[i] = gameState[i];
            }

            // Call the drawFireTile method with the copied game state
            return RaceToTheRaft.drawFireTile(gameStateCopy);
        }



    @Test
    public void testFullBag() {
        final String bag = "abcdefghijklmnopqrstuvwxyzABCDE";

        String[] gameState = new String[]{
                "fffffffffffffffrrf\nfffffffffbBbfffrRf\nfffffffffbbbfffrrf\nffffffpbgggbyrybgp\nffffffpryyyrgbrbgy\nffffffygbggrbpygpp\nffffppbpgypbprgyry\nffffPprybbrgypbbgb\nffffpprgygbybgryyb\nffffffgpbbrpygybgy\nffffffbyrgrbgyrpbg\nffffffpgygyppbyyrp\nffffffbgbybygbrprp\nfffbBbybpgyrpgbbow\nfffbbbyrypbbgrpbyg\n",
                "AabcdefghijklmnopqrstuvwxyBabcdefghijklmnopqrstuvwxyCabcdefghijklmnopqrstuvwxyDabcdefghijklmnopqrstuvwxy",
                "ABCD",
                "",
                "abcdefghijklmnopqrstuvwxyzABCDE"
        };
        String fireTile = callDrawFireTile(gameState);
        testIsFireTile(fireTile, bag);

        gameState = new String[]{
                "ffffffrrfrrffppfff\nffffffrRfrRffPpfff\nffffffrrfrrffppfff\nfffffyggrrrbygpybg\nffffYyypbybypbrgpb\nfffyyyrybgrpgrbpyy\nfffgrybbryrybpgrpb\nfffybgryppbygypgrb\nfffbpbyggbgbrrbygg\nfffyprypypbybygrpy\nfffrygpbbrorgrybrp\nfffbpygyrgwgpgbyyg\n",
                "AabcdefghijklmnopqrstuvwxyBabcdefghijklmnopqrstuvwxyCabcdefghijklmnopqrstuvwxyDabcdefghijklmnopqrstuvwxy",
                "ABCD",
                "",
                "abcdefghijklmnopqrstuvwxyzABCDE"
        };
        fireTile = callDrawFireTile(gameState);
        testIsFireTile(fireTile, bag);

        gameState = new String[]{
                "fffffffffffffffffy\nfffffffffbBbffffYy\nfffffffffbbbfffyyy\nfffrrfpbrbgbygrgyb\nfffrRfpgyyprpbygby\nfffrrfgypprbgrprpg\nfffgbbrpbgpbprpyyb\nfffpggbygryrybgpry\nfffpypgrrggbgpybbg\nffffffprgbbggrygyp\nffffffybygrpybgrow\nffffffbrrpgrbpbbww\nfffffffffgpbfppfff\nfffffffffbygfPpfff\nfffffffffgryfppfff\n",
                "AabcdefghijklmnopqrstuvwxyBabcdefghijklmnopqrstuvwxyCabcdefghijklmnopqrstuvwxyDabcdefghijklmnopqrstuvwxy",
                "ABCD",
                "",
                "abcdefghijklmnopqrstuvwxyzABCDE"
        };
        fireTile = callDrawFireTile(gameState);
        testIsFireTile(fireTile, bag);
    }


    @Test
    public void testNotFullBag() {
        String[] gameState = new String[]{
                "ffffffffffffffffff\nfffffffffffffffbBb\nfffffffffffffffbbb\nfffffffbggybgbrggy\nfffffffffgygrpyyrb\nfffffffgbyprbpbbpy\nffffffygybgyrrgggr\nfffbbbbgbbBgprrgyb\nfffbbbbbbgrybrrRpg\nffffffbbryyprrfprg\nffffffrfpbpgrrfyby\nffffffffggbyrrfbrr\nfffffffpggrgbybprp\nffffffpppgypbrgbow\nffffffffppPgybpbyg\n",
                "AabcdefghijklmnpqstuvxyBabcdefghijklmnopqrstuvwxyCabcdefghijklmopqrstuvwxyDabcdefghjklmopqrstuvwxy",
                "ABCD",
                "",
                "abcdefgijklmnopqrstuvwxyzABC"
        };



        String fireTile = callDrawFireTile(gameState);
        testIsFireTile(fireTile, gameState[4]);

        // Additional game state setups and tests...
        gameState = new String[]{
                "fffffffff\nfffffffff\nffffffgfg\nfffffffff\nffbfffbGy\nfgbfbfggb\nfffByyggb\nfrgypyggb\nfbybgygyb\ngyyyyyprp\nprbygybow\nyprygybYg\nggybryyyb\nbrgpybyrp\nbprgpbyry\n",
                "AbcdefghijkmnoqrstuvwxyBabcdefgijkmnopqrstuvwxyCbcdefgijlmnoptuvwxDabcdefghijklmnopqrstuvwxy",
                "ABCD",
                "",
                "bdefgiklmoqrsuvwxyzABCDE"
        };

        // Empty fire tile bag
        gameState = new String[]{
                "ffffffffffffffffff\nffffffffffffffffff\nffffffffffffffffff\nfffffffrpffffffprp\nfffffffffffffffbow\nfffffffbfffffggbyG\nfffffffrfffgfffggg\nfffffffffffyfffgrr\nffffffppfffffffgrr\nfffffypyggyfffggyr\nffffYyyyyyyfgfpgfr\nfffyyybrrypggbbBfy\nfffffffffffyfrffff\nffffffffffrffffybf\nfffffffffffffffyrf\n",
                "AabcdefghijlmnpqrsvwxyBbcdefghjkmnopqrstuvxyCacdeglnopqrsuvwxyDabcdeghijklmnopqrtuvwxy",
                "ABCD",
                "",
                ""
        };
        fireTile = callDrawFireTile(gameState);
        if (!"".equals(fireTile)) {
            throw new IllegalStateException("Expected an empty fireTile, but got: " + fireTile);
        }
    }

    @Test
    //This is the test for our updateBag status after draw the fireTile from it

    public void testFireTileBagUpdateAfterDraw() {
        // Initialize FireTile state assuming it contains all  fire tile
        String initialBagState = "abcdefghijklmnopqrstuvwxyzABCDE";

        String[] gameState = new String[]{
                "ffffffffffffffffff\nfffffffffffffffbBb\nfffffffffffffffbbb\nfffffffbggybgbrggy\nfffffffffgygrpyyrb\nfffffffgbyprbpbbpy\nffffffygybgyrrgggr\nfffbbbbgbbBgprrgyb\nfffbbbbbbgrybrrRpg\nffffffbbryyprrfprg\nffffffrfpbpgrrfyby\nffffffffggbyrrfbrr\nfffffffpggrgbybprp\nffffffpppgypbrgbow\nffffffffppPgybpbyg\n",
                "AabcdefghijklmnpqstuvxyBabcdefghijklmnopqrstuvwxyCabcdefghijklmopqrstuvwxyDabcdefghjklmopqrstuvwxy",
                "ABCD",
                "",
                initialBagState};

        // Use method to draw fire tile
        String drawnTile = RaceToTheRaft.drawFireTile(gameState);

        // Update bag length after draw the tile from the bag
        String updatedBagState = gameState[gameState.length - 1]; // 假设火焰瓦片袋状态总是在数组的最后一个位置

        // Assert draw fireTile no longer in the list of updated fireTile bag
        Assertions.assertFalse(updatedBagState.contains(drawnTile), "The drawn tile should be removed from the fire tile bag.");

        // Assert Length is less than before with 1
        Assertions.assertEquals(initialBagState.length() - 1, updatedBagState.length(), "The fire tile bag should have one less tile after drawing.");
    }

}
