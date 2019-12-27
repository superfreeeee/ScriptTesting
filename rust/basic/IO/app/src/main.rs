fn main() {
    println!("Hello, world!\n");
    let args = std::env::args();
    println!("args.len = {}", args.len());
    for arg in args {
        println!("[{}]", arg);
    }
}
