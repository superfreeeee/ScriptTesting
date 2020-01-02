package main

import "fmt"

func main() {
	var num1 int = 100
	var num2 int = 200
	var num3 int = max(num1, num2)
	fmt.Printf("max{%v, %v} = %v\n", num1, num2, num3)

	x, y := 10, 20
	fmt.Printf("x = %v, y = %v\n", x, y)
	x, y = swap(x, y)
	fmt.Printf("x = %v, y = %v\n", x, y)
	swap2(&x, &y)
	fmt.Printf("x = %v, y = %v\n", x, y)

}

func max(num1, num2 int) int {
	if num1 > num2 {
		return num1
	} else {
		return num2
	}
}

func swap(x int, y int) (int, int) {
	return y, x
}

func swap2(x *int, y *int) {
	// temp := *x
	// *x = *y
	// *y = temp
	*x, *y = *y, *x
}