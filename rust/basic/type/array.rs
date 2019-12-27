fn main() {
    let arr:[i32;10] = [1,2,3,4,5,6,7,8,9,0];
    println!("{:?}", arr);
    let arr:[i32;10] = [0;10];
    println!("{:?}", arr);
    let arr = [0.3;7];
    println!("{:?}", arr);

    println!("arr.len = {}", arr.len());

    div();

    let arr = [1,3,5,7,9];
    print!("{{");
    for index in 0..arr.len() {
        print!("{}", arr[index]);
        if index != arr.len()-1 {
            print!(", ");
        }
    }
    println!("}}");

    for i in arr.iter() {
        println!("{}", i);
    }

    div();

    let mut arr = [1,2,3,4];
    println!("{:?}", arr);
    arr[0] = 100;
    println!("{:?}", arr);

    div();
    
    let arr = [1,2,3];
    println!("arr outside: {:?}", arr);
    print(arr);
    add_one(arr);
    println!("arr outside: {:?}", arr);

    div();

    let mut arr = [1,2,3];
    println!("arr outside: {:?}", arr);
    inc(&mut arr);
    println!("arr outside: {:?}", arr);

    div();

    const N:usize = 5;

    let arr = [-3;N];
    println!("{:?}", arr);

    div();

    let mut arr = [1,2,3];
    let mut arr2 = arr;
    println!("arr: {:?}", arr);
    println!("arr2: {:?}", arr2);

    arr[1] = 4;
    println!("arr: {:?}", arr);
    println!("arr2: {:?}", arr2);
}

fn inc(arr:&mut [i32;3]) {
    for i in 0..3 {
        arr[i] += 1;
    }
}

fn add_one(mut arr:[i32;3]) {
    for i in 0..3 {
        arr[i] += 1;
    }
    println!("arr inside: {:?}", arr);
}

fn print(arr:[i32;3]) {
    for i in 0..3 {
        println!("{}", arr[i]);
    }
}

fn div() {
    println!("\n-----new scope-----\n");
}
