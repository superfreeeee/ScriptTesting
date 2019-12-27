pub mod movies {
    pub fn play(name: String) {
        println!("Playing movie {}", name);
    }
}

pub mod A {
    pub mod B {
        pub mod C {
            pub mod D {
                pub mod movies {
                    pub fn play(name: String) {
                        println!("Playing movie {}", name);
                    }
                }
            }
        }
    }
}

// use movies::play;
use A::B::C::D::movies::play;

fn main() {
    movies::play(String::from("Magic"));
    play(String::from("Magic 2"))
}
