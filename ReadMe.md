**Intent:** Reduce complexity faced by an API client. At the API level, one way
 is to move object construction behnind a thoughtful, humance interface.

Common design requirements which are encountered

For a fluent interface to be effective, you need situations where you actually have all that information at one time so that you can chain the methods in a fluid way" - Paul M. Jones

1. Shared functionality (data/behaviour) is declared only once in the object hierarchy - 
in parent and delegate special responsibility to derived classes.

**Ref:** http://www.unquietcode.com/blog/2011/programming/using-generics-to-build-fluent-apis-in-java/

2. Mandatory and optional attributes/settings ; a fallout of this is validating
object state before persistence/business logic is applied.

**Ref:**
  
3. Self-documenting code which achieves the following : 

    a. Forces the method call order so that the object state is correctly set. <br>
    b. Allow terminal methods to be called only after mandatory state has been set.

**Ref:** 
<br>
https://blog.allinsight.de/fluent-interface-pattern/
<br>
http://www.erikschierboom.com/2014/10/08/fluent-interfaces/

**Points to be noted**
<br>
1. Fluent interfaces are more about context, and are so much 
more than just ways to configure objects.<br><br>
Context (so when you typically do many actions in a sequence with the same thing, 
you can chain the actions without having to declare your context over and over).

2. Discoverability (when you go to objectA. then intellisense gives you lots of hints. 
In my case above, plm.Led. gives you all the options for controlling the built-in LED, 
and plm.Network. gives you the things you can do with the network interface.  plm.Network.X10.
 gives you the subset of network actions for X10 devices. You won't get this with constructor 
 initializers (unless you want to have to construct an object for every different type of action, 
 which is not idiomatic). 
<br><br>

**Good examples of fluent api design**
<br>
1. JQuery
2. Linq
3. EasyMock
4. Jooq
<br>

***Additional literature***
https://www.hanselman.com/blog/TheWeeklySourceCode14FluentInterfaceEdition.aspx
https://dzone.com/articles/factories-builders-and-fluent-
https://en.wikipedia.org/wiki/Fluent_interface
https://en.wikipedia.org/wiki/Bounded_quantification#F-bounded_quantification

