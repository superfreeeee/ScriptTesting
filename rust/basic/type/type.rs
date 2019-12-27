fn main() {
    let s = "hello world";
    let f = 123.456;
    let b = true;
    let c = 'c';

    println!("s: {0}", s);
    println!("f: {}", f);
    println!("b: {}", b);
    println!("c: {}", c);

    div();

    let int = 123456;
    println!("int(default = i32): {}", int);
    let i8:i8 = 123;
    println!("i8: {}", i8);
    // let u8:u8 = -123;
    // print!("u8: {}\n", u8);
    let f32:f32 = 123.456;
    println!("f32: {}", f32);
    let f32_2:f32 = 123.456789;
    println!("f32-2: {}", f32_2);

    // let int_to_f:f32 = 8;
    let int_to_f:f32 = 8.0;
    println!("int_to_f: {}", int_to_f);

    div();

    let bigint:i128 = 100_000_000_000;
    println!("bigint: {}",bigint);

    let bool_val:bool = true;
    println!("bool: {}", bool_val);

    let character:char = 'A';
    println!("char: {}", character);

}

fn div() {
    println!("\n-----new area-----\n");
}