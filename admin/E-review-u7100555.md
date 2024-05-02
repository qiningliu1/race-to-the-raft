## Code Review

Reviewed by: Qining, u7100555

Reviewing code written by: Lujin u7897414

Component: the ExaustedCat component being reviewed

### Comments 

Qining's comment: <write your comments here>

What are the best features of this code?
I think Lujin has good aplly list to store catstring, and also It's good idea to
sort the list of exhausted catstring by using collection.

Is the code well-documented?
Most of the text is in good syntax, but some text as sb of StringBuilder is not a good type.
Method name I think is good for me to read, and quick to capture the logic behind.
For addExhaustedCat Method, I think it didn't return a case when not satisfy the check condition.
Also, the same problem in get ExhaustedCat method and it didn't return an empty string case.

Is the program decomposition (class and method structure) appropriate?
Yes, I thought following on call property->build constructor ->add,get, sort exhausted cat method is
easy to understand for me.

Does it follow Java code conventions (for example, are methods and variables properly named), and is the style consistent throughout?

I think it follows most of the convention, but some method parameter applied and return value is not quiet clear,
But the two demensions array which recieve value in TileType is a good application with in OOP programming,
which has private properties to work each class individually.

If you suspect an error in the code, suggest a particular situation in which the program will not function correctly.
In this part, I think one important base logic should be mentioned is that exhausted cat should be behalf
the cat which already moved in this round. So statically, I think Lujin build contact link to add, get and sort cat,
but the really fundemental logic is the cat movement link to the card you draw or not, because if the cat is exhausted it can move
twice but if it's in the new round it can move without drawing card. So base on this point, I think this class should have some link
with drawhand cards method, also he can think about use inherit to extends exhausted cats in the class of cats, which also a good 
application design in JAVA.
