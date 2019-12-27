// enum Option<T> {
//     Some(T),      // 用于返回一个值 used to return a value
//     None          // 用于返回 null ，虽然 Rust 并不支持 null 
//     the null keyword
// }

fn main() {
    let result = is_even(3);
    println!("result: {:?}", result);
    let result = is_even(30);
    println!("result: {:?}", result);

    div();

    print_even(32);
    print_even(-33);
    
}

fn print_even(num: i32) {
    match is_even(num) {
        Some(value) => {
            if value == true {
                println!("{} is even", num);
            }
        },
        None => {
            println!("{} is not even", num);
        }
    }
}

fn is_even(num: i32) -> Option<bool>{
    if num % 2 == 0 {
        Some(true)
    } else {
        None
    }
}

fn div() {
    println!("\n-----new scope-----\n");
}
