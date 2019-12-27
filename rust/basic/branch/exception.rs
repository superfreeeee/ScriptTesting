// Recoverable
// UnRecoverable
use std::fs::File;

fn main() {
    // unrecover();
    // index_out_of_range();
    file_not_exist();
    println!("hello");
}

fn file_not_exist() {
    let f = File::open("main.jpg");
    match f {
        Ok(f) => {
            println!("file found {:?}", f);
        },
        Err(e) => {
            println!("file not found \n{:?}", e);
        }
    }
    println!("end of file_not_exist function");
}

fn index_out_of_range() {
    let a = [1,2,3];
    println!("{}", a[10]);
}

fn unrecover() {
    panic!("unrecoverable error, program broken");
}

fn div() {
    println!("\n-----new scope-----\n");
}
