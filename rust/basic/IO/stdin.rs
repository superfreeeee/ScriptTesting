use std::io::stdin;

fn main() {
    let mut name = String::new();
    println!("Please input your name: ");
    let count = stdin().read_line(&mut name).unwrap();
    println!("Hello {}", name);
    println!("length of name is {}", count);
}

