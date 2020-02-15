#include<iostream>

using namespace std;

class Box {
    public:
        double length;
        double breadth;
        double height;

        double getVolume(void);
        void setLength(double len);
        void setBreadth(double bre);
        void setHeigth(double hei);
};

double Box::getVolume(void) {
    return length * breadth * height;
}

void Box::setLength(double len) {
    length = len;
}

void Box::setBreadth(double bre) {
    breadth = bre;
}

void Box::setHeigth(double hei) {
    height = hei;
}

int main() {
    Box box;
    double volume;

    box.setHeigth(6.0);
    box.setBreadth(7.0);
    box.setLength(8.0);
    volume = box.getVolume();
    
    cout << "volume of box = " << volume << endl;
}