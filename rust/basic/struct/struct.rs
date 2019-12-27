struct Employee {
    name:String,
    company:String,
    age:u32
}

impl Employee {
    fn say_hi(&self) {
        println!("invoke say hi");
        print_employee(self);
    }

    fn say_hi2(&self) {
        println!("invoke say hi 2");
        println!("====================");
        println!("an employee");
        println!("====================");
        println!("> name: {}", self.name);
        println!("> company: {}", self.company);
        println!("> age: {}", self.age);
        println!("====================\n");
    }
}

struct Rectangle {
    height: u32,
    width: u32
}

impl Rectangle {
    fn get_instance(x:u32, y:u32) -> Rectangle {
        Rectangle {height: x, width: y}
    }

    fn area(&self) -> u32 {
        self.height * self.width
    }
}

fn main() {
    let employee_1 = Employee {
        name: String::from("superfree"),
        company: String::from("nju"),
        age: 20
    };
    print_employee(&employee_1);

    div();

    let mut em2 = Employee {
        name: String::from("employee2"),
        company: String::from("NJUSE"),
        age: 20
    };
    print_employee(&em2);
    em2.age = 10;
    print_employee(&em2);

    div();

    let p1 = Employee {
        name: "employee_1".to_string(),
        company: "com".to_string(),
        age: 10
    };
    let p2 = Employee {
        name: "employee_2".to_string(),
        company: "com".to_string(),
        age: 20
    };
    let elder = get_elder(p1, p2);
    print_employee(&elder);

    div();

    let p = Employee {
        name: "superfree".to_string(),
        company: "com".to_string(),
        age: 30
    };
    p.say_hi();
    p.say_hi2();

    div();

    let rect_1 = Rectangle {
        height: 20,
        width: 10
    };
    let rect_1_area = rect_1.area();
    println!("rect 1 area = {}", rect_1_area);

    let rect_2 = Rectangle::get_instance(40, 20);
    let rect_2_area = rect_2.area();
    println!("rect 2 area = {}", rect_2_area);

    
}

fn get_elder(e1:Employee, e2:Employee) -> Employee {
    if e1.age >= e2.age {
        return e1;
    } else {
        return e2;
    }
}

fn print_employee(e:&Employee) {
    println!("====================");
    println!("an employee");
    println!("====================");
    println!("> name: {}", e.name);
    println!("> company: {}", e.company);
    println!("> age: {}", e.age);
    println!("====================\n");
}

fn div() {
    println!("\n-----new scope-----\n");
}
