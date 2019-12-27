fn main() {
    let s = "Superfree".to_string();
    let s2 = &s[2..6];
    println!("s = {}", s);
    println!("s2 = {}", s2);

    div();

    let arr = [1,2,3,4,5];
    print(&arr[2..4]);
    println!("print outside: {:?}", arr);

    div();
    
    let mut arr = [1,2,3,4,5,6,7,8,9,10];
    println!("arr: {:?}", arr);
    reverse(&mut arr[3..7]);
    println!("arr: {:?}", arr);

}

fn reverse(slice:&mut [i32]) {
    let length = slice.len();
    for i in 0..length/2 {
        let temp = slice[i];
        slice[i] = slice[length-1-i];
        slice[length-1-i] = temp;
    }
}

fn print(arr:&[i32]) {
    println!("print inside: {:?}", arr);
}

fn div() {
    println!("\n-----new scope-----\n");
}
