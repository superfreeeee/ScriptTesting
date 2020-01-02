package main

import "fmt"

type User struct {
	name string
	id string
	age int
}

func main() {
	user1 := User {"user1", "0001", 20}
	user2 := User {age: 21, id: "0002", name: "user2"}
	user3 := User {id: "0003", name: "user3"}
	fmt.Println(user1)
	fmt.Println(user2)
	fmt.Println(user3)

	printUser(user1)
	printUser(user2)
	printUser(user3)

	user4 := User {}
	copyUser(user1, &user4)
	user4.name = "user4"
	printUser(user4)
}

func printUser(user User) {
	fmt.Println("print User\n===============")
	fmt.Printf("name: %v\n", user.name)
	fmt.Printf("id: %v\n", user.id)
	fmt.Printf("age: %v\n", user.age)
	fmt.Println("===============")
}

func copyUser(sample User, target *User) {
	target.name = sample.name
	target.id = sample.id
	target.age = sample.age
}