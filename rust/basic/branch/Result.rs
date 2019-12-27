use std::fs::File;

fn main() {
    let num = 2;
    let result = is_even(num);
    match result {
        Ok(value) => {
            println!("{} is even ? {}", num, value);
        },
        Err(e) => {
            println!("Error msg is {}", e);
        }
    }

    div();

    let num = 2;
    let result = is_even(num).unwrap();
    println!("{} is even ? {}", num, result);

    let num = 2;
    let result = is_even(num).expect("not even");
    println!("{} is even ? {}", num, result);

    // let num = 3;
    // let result = is_even(num).expect("not even");
    // println!("{} is even ? {}", num, result);

    div();

    let f = File::open("main.jpg").expect("file not exist");  // 調用 panic! 並退出

    println!("Main function end");
}

fn is_even(num: i32) -> Result<bool, String> {
    if num % 2 == 0 {
        Ok(true)
    } else {
        Err("not a even".to_string())
    }
}

fn div() {
    println!("\n-----new scope-----\n");
}
