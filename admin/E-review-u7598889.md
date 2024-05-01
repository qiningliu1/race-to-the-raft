## Code Review

Reviewed by: Ishaan Kapoor, u7598889

Reviewing code written by: Qining Liu, u7100555

Component: FireTiles class : created, developed and maintained by Qining

### Comments
Before I start, I would like to appreciate Qining's logical ability and work ethic.
He does fully immerse in the work he does and used great logic to approach the problems. Plus, he tries to document his code
as well as he shows good use of various data structures. The program decomposition is also satisfiable to me, as good the indentation,
loops placement, class structure and so on are as per what we were taught in class.

The only problem I feel he faces is he tends to manipulate strings and characters instead of focusing on Object oriented
programing. In this class for example, we can see he has based the fireTileBag on Strings and fireTiles on ints. 
I would advice him to use TileType.Fire instead to represent individual fire block, and use TileType[][] to represent the
fireTile as whole. He can then use the int locations to manipulate the TileType[][] array. This problem was faced with the Decks class aswell,
because of which we had to re-write the a bunch of methods and constructors again.

Another field where I think he can improve is naming the methods a bit better, like drawFireTileID() is good, but getFireTileID()
makes more sense in that scenerio.In terms of documentation, I would really appreciate if he adds @param and @return lines
to his comments as they are quite confusing sometimes, like for example in the drawFireTileID() method. It is slightly
difficult to understand his implementation and motivation for this method. A bit more explanation via comments would have made it better.

Apart from all this, I am quite happy with him. I am sure he would work upon these suggestions :)




