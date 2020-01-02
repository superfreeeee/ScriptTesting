package main

import "fmt"

func main() {
	var grade = 100
	var name = "A"
	
	switch name {
		case "A":
			fmt.Println("name is A")
		case "B":
			fmt.Println("name is B")
		case "C":
			fmt.Println("name is C")
		default:
			fmt.Println("other names")
	}

	switch {
		case grade < 0:
			fmt.Println("invalid grade")
		case grade > 0 && grade < 60:
			fmt.Println("fail")
		case grade > 60:
			fmt.Println("pass")
	}

	var x interface {}

	switch i := x.(type) {
		case nil:
			fmt.Println("x.type =", i)
		case int:
			fmt.Println("x.type = int")
	}

	switch {
		case true:
			fmt.Println("line 1")
			fallthrough
		case false:
			fmt.Println("line 2")
			fallthrough
		case true:
			fmt.Println("line 3")
		case false:
			fmt.Println("line 4")
		default:
			fmt.Println("line 5")

	}
}