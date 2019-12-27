fn main() {
    let string:&str = "string";
    println!("string = {}", string);

    let s = String::new();
    println!("s.len = {}", s.len());

    let s = String::from("123");
    println!("s.len = {}", s.len());

    div();

    let s = "12345".to_string();
    println!("s = {}", s);

    let s = s.replace("2", "678");
    println!("s = {}", s);

    let s:&str = s.as_str();
    println!("s = {}", s);

    div();

    let mut s = "123".to_string();
    s.push('4');
    println!("s = {}", s);

    s.push_str("567");
    println!("s = {}", s);

    println!("s.len = {}", s.len());

    div();

    let s = "   \t\n123\n\t123   \n";
    println!("s = {}", s);
    println!("s.len = {}", s.len());
    println!();
    println!("s.trim = {}", s.trim());
    println!("s.trim.len = {}", s.trim().len());
    
    div();

    let s = " 1 2 3 ";
    for token in s.split_whitespace() {
        println!("token: {}", token);
    }

    let s = "1, 2, 3";
    for token in s.split(", ") {
        println!("token: {}", token);
    }
    let tokens:Vec<&str> = s.split(", ").collect();
    println!("token[0]: {}", tokens[0]);
    println!("token[1]: {}", tokens[1]);
    println!("token[2]: {}", tokens[2]);
    println!("token.len: {}", tokens.len());

    div();

    for c in "12345".chars() {
        println!("{}", c);
    }

    div();

    let s1 = "123".to_string();
    let s2 = "456".to_string();
    let s3 = s1 + &s2;
    println!("s3 = {}", s3);

    div();

    let n = 123;
    let s = n.to_string();
    println!("s = {}", s);
    println!("{}", s == "123");

    div();

    let x = "x = 0".to_string();
    let y = "y = 0".to_string();
    let s = format!("{{{} {}}}", x, y);
    print!("{}", s);
}

fn div() {
    println!("\n-----new area-----\n");
}