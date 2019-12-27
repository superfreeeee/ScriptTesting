#[derive(Debug)]
struct Data<T> {
    value: T
}

fn main() {
    let t: Data<i32> = Data {value: 35};
    println!("t: {:?}", t);

    let t2: Data<String> = Data {value: "superfree".to_string()};
    println!("t2: {:?}", t2);

}

