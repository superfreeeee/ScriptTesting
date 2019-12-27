fn main() {
    for i in 0..11 {
        println!("{}", i);
    }

    div();

    let mut i = 0;
    while i < 11 {
        println!("{}", i);
        i += 1;
    }

    div();

    let mut i = 0;
    loop {
        println!("{}", i);
        if i >= 10 {
            break;
        } else {
            i += 1;
        }
    }

    div();

    for i in 1..11 {
        if i % 3 == 0 {
            continue;
        }
        println!("{}", i);
    }
}

fn div() {
    println!("\n-----new scope-----\n");
}
