fn main() {
    let a = vec![1,2,3];
    println!("a = {:?}", a);
    let b = a;
    println!("b = {:?}", b);
    // println!("a = {}", a);

    div();

    let a = vec![1,2,3];
    print(a);
    // println!("print outside: {:?}", v);
    
    div();

    let a = vec![1,2,3];  // a got control
    let b = a;  // give control to b
    let c = print2(b);  // give control to function and return to c
    // println!("print outside: {:?}", a);
    // println!("print outside: {:?}", b);
    println!("print outside: {:?}", c);
    
    div();

    let a = 123;
    let b = a;
    println!("a = {}", a);
    println!("b = {}", b);

}

fn print2(v:Vec<i32>) -> Vec<i32> {
    println!("print inside: {:?}", v);
    return v;
}

fn print(v:Vec<i32>) {
    println!("print inside: {:?}", v);
}

fn div() {
    println!("\n-----new scope-----\n");
}
