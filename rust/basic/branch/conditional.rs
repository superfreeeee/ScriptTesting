fn main() {
    let grade = -1;
    if grade > 100 {
        println!("grade over 100");
    } else if grade < 0 {
        println!("grade lower 0");
    } else {
        println!("your grade = {}", grade);
    }

    div();

    for name in "A B C D".split_whitespace() {
        let state = match name {
            "A" => "Apple",
            "B" => "Bear",
            "C" => "Car",
            _ => "default"
        };
        println!("state: {}", state);
    }
}

fn div() {
    println!("\n-----new scope-----\n");
}
