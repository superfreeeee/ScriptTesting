use std::collections::HashSet;

fn main() {
    let mut s = HashSet::new();
    s.insert("Python");
    s.insert("C");
    s.insert("Java");
    s.insert("Ruby");
    s.insert("Rust");
    s.insert("Rust");

    println!("s: {:?}", s);
    println!("len: {}", s.len());

    div();
    // iter
    for i in s.iter() {
        println!("language {}", i);
    }

    div();
    // get
    match s.get(&"Rust") {
        Some(value) => {
            println!("get {}", value);
        },
        None => {
            println!("get nothing");
        }
    }

    div();
    // contains
    let vals = ["Rust", "Java", "JavaScript"];
    for i in 0..3 {
        println!("contains {} ? {}", vals[i], s.contains(vals[i]));
    }

    div();

    println!("s: {:?}", s);
    s.remove(&"C");
    s.remove(&"Java");
    s.remove(&"Vue");
    println!("s: {:?}", s);


}

fn div() {
    println!("\n-----new scope-----\n");
}
