# KWIC-Assignment

# Summary
Regarding the first design, decomposition was fairly broad. The first design had everything encompassed in the main method and there was almost no way to unit test the design. My initial thought was "how do I break this up into smaller pieces?". First, I looked at the objects involved in the process. The "things" that came to mind were the "Line" object itself, the container or data structure that is "holding" the Lines, and the UI.

Regarding the second design, decomposition had already taken place as I built it. I took the items identified in the previous section and tried to abstract and encapsulate them. I created a WordList object which was probably poorly named as we will not always be reading in words. Another object I created was a Line object. This object was responsible for handling a line of some types as a whole. Internally it used a LinkedList of type Object to provide some level of flexibility. Generics or another implementation may have been a better idea. Internally, the wordlist has a collection of Lines and the Lines have a collection of Objects.

Regarding change resilience, I would be comfortable stating that both of the designs are not completely resilient to change but the second design would be much easier to implement and handle change. The second design may not give the desired results for all cases but that can be handled via overriding the toString method on each class you want stored. The design can support classes that are not defined in this project as long as the toString method will give the desired result.

Regarding a change to support a database in the first design, almost everything would have to change. The first design calls out a file specifically and loads the contents into memory. I suppose, in theory, one could add another method for loading files from a database as a DBLoader class and have to explicitly call the data source type.

In the second design, the same kind of changes would have to take place. I would have to add a DBLoader class instead of a file loader class. I didn't spend a lot of time implementing this functionality. If I were to support a database, creating an interface for loading files would be a start. The next steps would be to implement that interface on a FileLoader class and a DBLoader class. The code for loading up the internal data structure would use the methods from the interface and the changes would be class implementation specific.

Nothing in either design was built for a GUI, though it may not be as difficult for the second design to have a GUI instead of cmd line. The second design has enough functoinality abstracted out of the main method to have each button that the user would click call a method. User action to method mapping would be much less complex in the second design and the first design cannot support it in it's current state.

Another change that would probably happen would be different data types. While the second implementation is not perfect and probably would not support ALL data types being loaded into the program, the second design is in a better place to adapt to those changes and would be able to support most use cases.

The second design is easier to understand as I built it myself and have abstracted functionality and encapsulated it with different objects. Each object is responsible for handling it's internal dataset. 

I would say the first design is better performing. Everything is in the main method and there's not a lot of overhead. With the second design, there's a lot of overhead for handling each data structure internally and there are a lot more operations to get the user the results they want to see. That being said, the second design is easier to understand (which typically comes at the cost of performance). Straight forward development with no flexibility is typically built to do one thing and do it quickly. There is no excess, no room for other use cases to sneak into the design, and it is essentially a one trick pony for that problem statement.

This principle of information hiding is very relevant to this assignment. As the second design showed, it was easier to understand and less decoupled when abstracting and encapsulating functionality in decomposition of the functions. Instead of accessing the items directly, I was able to hide the underlying functionality of a piece of the system behind "something". In this case, that "something" was an object called WordList which contained multiple Line objects. This design approach made the system more stable and more anti-fragile.


