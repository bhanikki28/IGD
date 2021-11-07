package main

import "fmt"

func main() {

	players := make(map[string]string)

	players["cricket"] = "sachin"
	players["tennis"] = "sampras"

	fmt.Println(players)

}
