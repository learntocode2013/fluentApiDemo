-----**Need** ---- 
                                                                                              <br>
Why do we need our public API(s) to be fluent at all ?                                        <br>
                                                                                              <br>
In developing a piece of software, we always strive to separate the common from the variable. <br>
For e.g., externalizing configuration is always a good idea instead of re-compiling code for  <br>
every small configuration change. We can express the externalized configuration in a language <br>
easy for non-developers to reason about ; it can be in XML form or any custom domain specific <br>
language. If we do choose to write the DSL in our main programming language, we need to do    <br>
away with API wiring and ceremony. The DSL must flow as prose so that it is easy to reason    <br>
about. Fluent API is an attempt in that direction.                                            <br>


----- **Design considerations** ----
                                                                                               <br>

1. Shared functionality (data/behaviour) is declared only once in the object hierarchy -       <br> 
in parent and specific responsibility delegated to derived classes.                            <br>

2. Not all attributes are equal ; some might be mandatory and rest optional. This introduces   <br>
the need of validating object state before persistence/business logic is applied.              <br>
  
3. Any self-documenting code (like the fluent approach) must keep the following in mind :      <br>

    a. How to ensure the method call order so that the object state is correctly set.          <br>
    b. How to allow terminal methods to be called only after mandatory state has been set.     <br>


---- **Project model** ----
                                                                                                <br>
                                                                                                <br>
All the semantic models(objects populated by a DSL) used in this project are in-memory object   <br>
models.

---- **Conclusion(s) drawn** ----
                                                                                              <br>
1. Fluent interfaces are more about context, and are so much more than just ways to configure <br>
objects. What that means is, when we typically do many actions in a sequence with the same    <br>
thing, we can chain the actions without having to declare that context over and over.         <br>

2. For a fluent interface to be effective, we need situations where you actually have all     <br>
the information upfront (e.g. configuration mostly) so that we can chain the methods in a     <br>
fluid way                                                                                     <br>

---- **Good examples of fluent api design** ----
<br>
1. JQuery
2. Linq
3. EasyMock
4. Jooq
<br>

---- **Developers with opinion** ----
                    <br>
Paul M. Jones       <br>
Eric Evans          <br>
Martin Fowler       <br>

---- ***Additional literature*** ----
                                                                                   <br>
https://www.hanselman.com/blog/TheWeeklySourceCode14FluentInterfaceEdition.aspx    <br>
https://dzone.com/articles/factories-builders-and-fluent-                          <br>
https://en.wikipedia.org/wiki/Fluent_interface                                     <br>
https://en.wikipedia.org/wiki/Bounded_quantification#F-bounded_quantification      <br>
https://blog.allinsight.de/fluent-interface-pattern/                               <br>
http://www.erikschierboom.com/2014/10/08/fluent-interfaces/                        <br>
http://www.unquietcode.com/blog/2011/programming/using-generics-to-build-fluent-apis-in-java/

