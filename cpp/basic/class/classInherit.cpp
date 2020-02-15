#include<iostream>

using namespace std;

class Shape {
    public:
        void setWidth(int w) {
            _width = w;
        }

        void setHeight(int h) {
            _height = h;
        }

    protected:
        int _width;
        int _height;
};

class Rectangle: public Shape {
    public:
        int getArea() {
            return _width * _height;
        }
};

int main() {
    Rectangle rect;
    rect.setHeight(7);
    rect.setWidth(5);
    cout << "Area: " << rect.getArea() << endl;

    return 0;
}