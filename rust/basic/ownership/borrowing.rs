fn main() {
    let v = vec![1,2,3];
    print(&v);
    println!("print outside: {:?}", v);
    
    div();

    let mut n = 123;
    inc(&mut n);
    println!("n = {}", n);

    div();

    let mut s = String::from("hello ");
    add_name(&mut s);
    println!("{}", s);

}

fn add_name(template:&mut String) {
    template.push_str("superfree");
}

fn inc(n:&mut i32) {
    *n += 1;
}

fn print(v:&Vec<i32>) {
    println!("print inside: {:?}", v);
}

fn div() {
    println!("\n-----new scope-----\n");
}
