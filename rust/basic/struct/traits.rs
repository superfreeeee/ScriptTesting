use std::fmt::Display;

fn main() {
    let b = Book {
        id: 1001,
        name: "Rust in action"
    };
    b.print();

    div();

    print_pro(10 as u8);
    print_pro(30 as u16);

}

struct Book {
    name: &'static str,
    id: u32
}

trait Printable {
    fn print(&self);
}

impl Printable for Book {
    fn print(&self) {
        println!("Printing book: name = {}, id = {}", self.name, self.id);
    }
}

////////////////////////

fn print_pro<T:Display>(t: T) {
    println!("inside print_pro");
    println!("{}", t);
}

////////////////////////

fn div() {
    println!("\n-----new scope-----\n");
}