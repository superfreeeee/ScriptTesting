package main

import "fmt"

func main() {
	var a int = 10
	fmt.Printf("address of a = %x\n", &a)
	var pa *int = &a
	fmt.Printf("pointer pa = %x\n", pa)
	fmt.Printf("value of pa = %d\n", *pa)

	var ptr *int
	fmt.Println(ptr == nil)
}