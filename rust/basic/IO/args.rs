use std::env::args;

fn main() {
    let args = args();
    println!("args.len = {}", args.len());
    for arg in args {
        println!("[{}]", arg);
    }
}
