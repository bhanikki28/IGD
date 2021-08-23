# Getting Started

### Imperative v Declarative Approach

	Code Sample to iterate through the list and adding filters;
	Filtering the list by Imperative approach ( declaring temp list to hold the filtered values )
    Filtering the list by Declarative Approach ( using Streams and filters )
    Refer to ImperativeDemo and DeclartiveDemo class
## Functional Interface

    Using Functional Interface :
            Predicate  - Functional Interface to take one argument and do return boolen value
            Function   - FI to take one argument and return it
            Chaining of Functions - Chain Functions to do one or more operations , output of one is fed to another function ( PIPE )
                eg : apply(), andThen() and thenCompose()
                
    Refer to FuncInterfaceDemo
    
    Function Interface : Takes one argument and returns one
                         Pass argument using apply() method

    BiFunction Interface :  takes two argument and returns one 
                            Pass argument using apply() method

    Consumer Interface : Takes one argument and returns no argument. 
                         To pass argument to consumer interface,use accept(T t) method
                         Refer to ConsumerFuncDemo class
    
    Predicate Interface : Takes one argument and returns Boolean value
                          Pass argument using test()
                          Refer to PredicateFuncDemo class


## Streams 


## Method Reference