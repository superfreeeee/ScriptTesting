package main

import "fmt"

func main() {
	nums := []int{1,3,5,7,9}
	avg := average(nums, 5)
	fmt.Println(nums)
	fmt.Println(avg)

	fmt.Println(3.14 / 10)
}

func average(nums []int, size int) float64 {
	var avg float64
	var sum int
	for i:=0 ; i<size ; i++ {
		sum += nums[i]
	}
	avg = float64(sum) / float64(size)
	return avg
}