///

#[derive(Debug)]
enum Color {
    Red,
    Yellow,
    Green
}

///

#[derive(Debug)]
enum Gender {
    Male, Female
}

#[derive(Debug)]
struct Person {
    name: String,
    gender: Gender
}

impl Person {
    fn instance(name:String, gender: Gender) -> Person {
        Person {name: name, gender: gender}
    }

    fn print(&self) {
        println!("{:?}", self);
    }
}

/// 

enum DataSize {
    B, KB, MB, GB, TB
}

///
enum ProfileCategory {
    Name(String),
    ID(u32)
}

fn main() {
    let color_1 = Color::Red;
    let color_2: Color = Color::Yellow;
    println!("color 1 = {:?}", color_1);
    println!("color 2 = {:?}", color_2);

    div();

    let p = Person::instance("superfree".to_string(), Gender::Male);
    p.print();

    div();

    print_size(DataSize::B);
    print_size(DataSize::KB);
    print_size(DataSize::MB);
    print_size(DataSize::GB);
    print_size(DataSize::TB);

    div();

    let p1 = ProfileCategory::Name("superfree".to_string());
    let p2 = ProfileCategory::ID(123456789);
    show_profile(p1);
    show_profile(p2);
    
}

fn show_profile(p: ProfileCategory) {
    match p {
        ProfileCategory::Name(value) => {
            println!("Name {}", value)
        },
        ProfileCategory::ID(value) => {
            println!("ID {}", value);
        }
    }
}

fn print_size(data: DataSize) {
    let byte = 8;
    let k = 1024;
    match data {
        DataSize::B => {
            println!("B equals {} bits", byte);
        },
        DataSize::KB => {
            println!("KB equals {} bits", byte * k);
        },
        DataSize::MB => {
            println!("MB equals {} bits", byte * k * k);
        },
        DataSize::GB => {
            println!("GB equals {} MB", k);
        },
        DataSize::TB => {
            println!("TB equals {} MB", k * k);
        },

    }
}

fn div() {
    println!("\n-----new scope-----\n");
}
