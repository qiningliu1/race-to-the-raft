Classes in our design that needs to be tested are :

1) Board

method getGameBoard should be tested in isolation, to test if the correct expected board (Tile[][])
is returned after providing the board string from the challenge string.


2) Tiles

method toChar and fromChar needs to be tested by providing various char and Tile elements. These 
methods should also be tested by splitting strings into char, then feeding these char to fromChar,
and then comparing them to the given boards in the assignment specification.


3) FireTiles

method to check if the FireTile ID matched the ID of FIRE_TILE from 'a-z' and 'A to E'; method to check
the length of updated Fire bag and also check if the draw Fire Tile ID matched the Tile draw from the bag

4) GameState

we are yet to build this class. As for our plan, we are thinking of making this a class where we store
current hand, decks, state of board and cats. All these can be tested effectively by manually comparing
to expected states after playing some moves. These will be sorted in the future.

5) Island

Same for Island class, which is still very new. We want to make a larger board called Island using, smaller
boards as per the challenge string. The challenge string is different from the boardString so we have made a
new class for Islands. We will need an orientation class to implement this class and we will
concurrently test both. After changing the orientation of the boards, the Islands would change
and thus the methods of this class cant be tested on its own.