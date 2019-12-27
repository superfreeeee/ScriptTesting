fn main() {
    hi();
    println!("PI = {}", pi1());
    println!("PI = {}", pi2());
    let pi = pi1();
    println!("PI = {}", pi);

    div();

    let num = 123;
    test1(num);
    println!("num outside = {}", num);

    div();

    let mut num = 456;
    println!("num = {}", num);
    add_one(&mut num);
    println!("num = {}", num);

    div();

    let name:String = String::from("my name is ");
    println!("name outside = {}", name);
    let name2 = add_name(name);
    // println!("name outside = {}", name);
    println!("name outside = {}", name2);
    
}

fn add_name(mut name:String) -> String {
    name += "superfree";
    println!("name inside = {}", name);
    return name
}

fn add_one(num:&mut i32) {
    *num += 1;
}

fn test1(mut num: i32) {
    println!("num inside = {}", num);
    num *= 0;
    println!("num inside = {}", num);
}

fn hi() {
    println!("hello world!");
}

fn pi1() -> f32 {
    return 22.0/7.0;
}

fn pi2() -> f32 {
    22.0/7.0
}

fn div() {
    println!("\n-----new scope-----\n");
}