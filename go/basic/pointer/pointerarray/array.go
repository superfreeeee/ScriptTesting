package main

import "fmt"

const MAX int = 5

func main() {
	nums := [MAX]int{1,3,5,7,9}
	var ptrs [MAX]*int
	for i:=0 ; i<MAX ; i++ {
		ptrs[i] = &nums[i]
	}

	for i:=0 ; i<MAX ; i++ {
		fmt.Printf("nums[%d], address = %x, value = %v\n", i, ptrs[i], *ptrs[i])
	}

}