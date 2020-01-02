package main

import "fmt"

func main() {
	a := 100
	ptr := &a
	pptr := &ptr
	fmt.Printf("a = %d\n", a)
	fmt.Printf("ptr = %x, *ptr = %d\n", ptr, *ptr)
	fmt.Printf("pptr = %x, *pptr = %x, **pptr = %d\n", pptr, *pptr, **pptr)
}