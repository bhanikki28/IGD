## Building the Project

go build main.go

./main

## Running the App

go run main.go


## Go Packages

package main - Defines a package that can be compiled and then can be executed !

package util - Defines a package that can be reused in GO
golang.org/pkg ( to view the list of packages in GO)


## Import Statements

To import the packages in GO
eg : import "fmt" - gives access to all the functionalities in package


## File Organization


1. Package Declaration
2. Import relevant packages 
3. Function declaration and instructing GO to execute the function body


## func in GO


func - func keyword is short name for functions. 

Denoted by func function_name (args to be passed) { function body...}


## Summary

package in GO - To group together code with similar purpose

main package in GO - To make it as an executable ( to turn the file as an executable)

main package constraint - atleast one func with name as "main"

import statements - to give our package access to code written in another package

