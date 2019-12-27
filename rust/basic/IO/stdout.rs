use std::io::Write;
use std::io::stdout;

fn main() {
    let b1 = stdout().write("Hello ".as_bytes()).unwrap();
    let b2 = stdout().write("superfree".as_bytes()).unwrap();
    stdout().write(format!("\ntotal input length is {}\n", b1 + b2).as_bytes()).unwrap();
}
