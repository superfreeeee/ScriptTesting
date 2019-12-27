package main

import "fmt"

var (
	v6 float64
	v7 string
)

func main() {
	var a string = "GoLang"
	fmt.Println(a)
	
	var b, c int = 1, 2
	fmt.Println(b, c)

	var i int
	fmt.Println(i)
	
	var b2 bool
	fmt.Println(b2)

	var i0 int
	var f0 float64
	var b0 bool
	var s0 string
	fmt.Printf("%v %v %v %q\n", i0, f0, b0, s0);

	v0 := 123
	fmt.Println(v0)

	v1, v2, v3 := 1, 2, 3
	fmt.Println(v1, v2, v3)

	var (
		v4 int
		v5 bool
	)
	fmt.Println(v4, v5, v6, v7)

	v8, v9 := 0, 1
	fmt.Println(v8, v9)
	v8, v9 = v9, v8
	fmt.Println(v8, v9)

	v10, _, v11 := 1, 2, 3
	fmt.Println(v10, v11)
	
}