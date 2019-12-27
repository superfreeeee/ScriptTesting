package main

import "fmt"

func main() {
	const LENGTH = 10
	const WIDTH = 5
	fmt.Printf("area = %v\n", LENGTH * WIDTH)

	const i, b, s = 0, false, "str"
	fmt.Println(i, b, s)

	const (
		Male = 0
		Female = 1
	)
}