#include<iostream>

using namespace std;

class Line {
    public:
        void setLength(double length);
        double getLength();
        Line(double length);
        ~Line();

    private:
        double _length;
};

Line::Line(double length): _length(length) {
    cout << "create Object based on Line" << endl;
}

Line::~Line() {
    cout << "destroy Object of class Line" << endl;
}

void Line::setLength(double length) {
    _length = length;
}

double Line::getLength() {
    return _length;
}

int main() {
    Line line(6.0);
    cout << "Length of line: " << line.getLength() << endl;
    return 0;
}