fn main() {
    let mut v1 = Vec::new();
    v1.push(20);
    v1.push(30);
    v1.push(40);
    println!("v1 = {:?}, len = {}", v1, v1.len());

    let v2 = vec![1,2,3];
    println!("v2 = {:?}, len = {}", v2, v2.len());

    div();

    let mut v3 = vec![1,3,5];
    println!("v3 = {:?}, len = {}", v3, v3.len());
    v3.push(7);
    println!("v3 = {:?}, len = {}", v3, v3.len());
    v3.push(9);
    println!("v3 = {:?}, len = {}", v3, v3.len());
    
    v3.remove(4);
    println!("v3 = {:?}, len = {}", v3, v3.len());
    v3.remove(2);
    println!("v3 = {:?}, len = {}", v3, v3.len());

    if v3.contains(&3) {
        println!("contains 3");
    }
    if v3.contains(&4) {
        println!("contains 4");
    }

    div();

    for i in 0..v3.len() {
        println!("v3[{}] = {}", i, v3[i]);
    }
    println!("v3 = {:?}, len = {}", v3, v3.len());
    for i in &v3 {
        println!("{}", i);
    }
    println!("v3 = {:?}, len = {}", v3, v3.len());

}

fn div() {
    println!("\n-----new scope-----\n");
}
