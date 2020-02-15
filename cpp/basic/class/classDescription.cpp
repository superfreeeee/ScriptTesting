#include<iostream>

using namespace std;

class Person {
    public:
        void setName(string name);
        void setId(long id);

    private:
        string _name;
        long _id;
};

void Person::setName(string name) {
    _name = name;
}

void Person::setId(long id) {
    _id = id;
}

int main() {
    Person p;
    p.setId(12345);
    p.setName("sueprfree");
}