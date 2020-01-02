package main

import "fmt"

func main() {
	var a int = 21
	var b int = 10
	var c int

	c = a + b
	fmt.Printf("%v + %v = %v\n", a, b, c)
	c = a - b
	fmt.Printf("%v - %v = %v\n", a, b, c)
	c = a * b
	fmt.Printf("%v * %v = %v\n", a, b, c)
	c = a / b
	fmt.Printf("%v / %v = %v\n", a, b, c)
	c = a % b
	fmt.Printf("%v %% %v = %v\n", a, b, c)

	/*
	關系運算
	==, !=, >, <, <=, >=
	邏輯運算
	&&, ||, !
	位運算
	&, |, ^, <<, >>
	賦值運算
	=, +=, -=, *=, /=, %=, <<=, >>=, &=, ^=, |=
	*/

	var p *int = &a
	fmt.Printf("%v contains %v\n", p, *p)

}