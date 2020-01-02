package main

import "fmt"
import "strconv"

func main() {
	a := 10
	if a > 0 {
		fmt.Println("a is positive")
	} else if a == 0 {
		fmt.Println("a is zero")	
	} else {
		fmt.Println("a is Negative")
	}
	fmt.Println("a = " + strconv.FormatInt(int64(a), 10))
}