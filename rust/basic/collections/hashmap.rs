use std::collections::HashMap;

fn main() {
    let mut hp = HashMap::new();
    hp.insert("key1", "value1");
    hp.insert("key2", "value2");
    println!("hp: {:?}", hp);
    println!("hp.len: {}", hp.len());

    div();

    let key1 = "key1";
    match hp.get(&key1) {
        Some(value) => {
            println!("key = {}, value = {}", key1, value);
        },
        None => {
            println!("not found");
        }
    }

    div();

    for (key, val) in hp.iter() {
        println!("key = {}, value = {}", key, val);
    }

    div();

    let keys = ["key1", "key2", "key3"];
    for i in 0..3 {
        println!("contains {} ? {}", keys[i], hp.contains_key(&keys[i]))
    }

    div();
    hp.remove(&"key1");
    println!("hp: {:?}", hp);
}

fn div() {
    println!("\n-----new scope-----\n");
}
