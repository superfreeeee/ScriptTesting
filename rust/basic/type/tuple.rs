fn main() {
    let tuple = (1, 2, 3);
    println!("{:?}", tuple);

    let tuple:(i32, f32, u8) = (-100, 3.33 , 22);
    println!("{:?}", tuple);
    println!("{}", tuple.0);
    println!("{}", tuple.1);
    println!("{}", tuple.2);
    
    div();   

    let t = (20, 1.2, -50);
    print(t);
    spread(t);


}

fn spread(tuple:(i32, f32, i32)) {
    let (a, b, c) = tuple;
    println!("(price = {}, rate = {}, rest = {})", a, b, c);
}

fn print(tuple:(i32, f32, i32)) {
    println!("inside print");
    println!("{:?}", tuple);
}

fn div() {
    println!("\n-----new scope-----\n");
}
