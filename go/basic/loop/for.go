package main

import "fmt"

func main() {
	var i int
	for i := 1 ; i<10 ; i++{
		fmt.Println("i =", i)
	}

	fmt.Println("")

	i = 0
	for i < 10 {
		fmt.Println("i =", i)
		i++
	}

	fmt.Println("")

	i = 0
	for {
		fmt.Println("i =", i)
		i++
		if i > 10 {
			break
		}
	}

	fmt.Println("")

	nums := [7]int{1,3,5,7}
	for index, value := range nums {
		fmt.Printf("nums[%v] = %v\n", index, value)
	}
}