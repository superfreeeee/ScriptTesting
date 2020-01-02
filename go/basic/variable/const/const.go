package main

import "fmt"
import "unsafe"

const (
	a = "abc"
	b = len(a)
	c = unsafe.Sizeof(a)
	d = iota
	e
	f
	g = "ha"
	h
	i = iota
	j
	k
)

const (
	l = 1<<iota
	m
	n = 3<<iota
	o
	p
	q
)

func main() {
	const LENGTH = 10
	const WIDTH = 5
	fmt.Printf("area = %v\n", LENGTH * WIDTH)

	const i_var, b_var, s_var = 0, false, "str"
	fmt.Println(i_var, b_var, s_var)

	const (
		Male = 0
		Female = 1
	)

	println(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p)
	
}