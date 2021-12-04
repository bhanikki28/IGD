# Getting Started

    Code Samples to demonstrate
        1. Functional Interface
        2. Streams
        3. Method References
        4. Optional 
        5. Map
        6. FlatMap

### Imperative v Declarative Approach

	    1. Filtering the list by Imperative approach ( declaring temp list to hold the filtered values )
        2. Filtering the list by Declarative Approach ( using Streams and filters )
        Refer to ImperativeDemo and DeclartiveDemo class

## Lambda expressions

        1. Denoted by : () -> {} , anonymous functions i.e function with no name, with optional param and
           body
        2. It is different from normal method , as it does not have a name and its not
           bind to a particular function
        3. Refer to lambda.demo package for using lamdba expressions to call functional interface



## Functional Interface

    Interface having only one abstract method

    Using Functional Interface :
            Predicate  - Functional Interface to take one argument and do return boolen value
            Function   - FI to take one argument and return it
            Chaining of Functions - Chain Functions to do one or more operations , output of one is fed to another function ( PIPE )
                eg : apply(), andThen() and thenCompose()
                
    
    Function Interface : Takes one argument and returns one
                         Pass argument using apply() method
                         Refer to FuncInterfaceDemo

    BiFunction Interface :  Takes two argument and returns one 
                            Pass argument using apply() method
                            Refer to FuncInterfaceDemo

    Consumer Interface : Takes one argument and returns no argument. 
                         To pass argument to consumer interface,use accept(T t) method
                         Refer to ConsumerFuncDemo class
    
    Predicate Interface : Takes one argument and returns Boolean value
                          Pass argument using test()
                          Refer to PredicateFuncDemo class
    
    Supplier Interface : Takes no argument and returns one
                            Refer to SupplierFuncDemo class

## Streams 

    ![img.png](img.png)
    
    Brings functional programming to Java
    Uses Lambda expressions
    Streams - to process the collection of objects ( map, reduce, transformation )

    Using Java Streams to filter the list based on predicate
     Streams will have three parts
     1. Source to Operate i.e Input , it can be list
     2. Intermediate Operations : it can be filter, map,sort,allMatch, anyMatch etc
     3. Terminal Operations ( collectors, forEach )

     Parallel Operations are easy to perform using Streams compared to fork feature 
     introduced in Java7
    
     Stream Intermediate Operations:

     1. map - apply the function ( map) to the elements in stream
     2. filter - pick the elements matching the condition/predicate
     3. sort - sort the stream based on comparator

     Stream Terminal Operations

     1. Collect : collect(Collectors.toList())
     2. forEach : to iterate through the stream
     3. reduce : reduce
     
     Inside Streams :  list : filter/map/reduce : collect
     ![img.png](img.png)

     Debugging Streams : use peek() in filter chain to see the value or use streams trace view

## Optional

    - Better way of Handling Null Check
    - Avoid potential Null Pointer Exception
    - Avoid boilerplate coding

## Map
    Used in tandem with streams api to map the element ( do transformation ) operation
    Refer to MapDemo class 

## FlatMap
    Used to flatten the 2D list to single dimensional list and do mapping operation
    Refer to FlatMapDemo class

## Method Reference

    Method Reference is denoted by ClassName :: MethodName
                    for eg :  sorted(Comparator.comparing(Celebrity::getName))  // here Celebrity is the class name followed
                              by :: and then by method name i.e getName


## Concurrency

    ExecutorService - to execute tasks in parallel
    
    If you need a submit a task to ExecutorService, your task has to
    implement Callable interface ( if need a result back ) or can implement Runnable interface run method

    public interface Callable{
        public Object call() throws Exception;
    }

## Completable Future / Completion Stage Interface

    Completable Future class got introduced in Java 8
    