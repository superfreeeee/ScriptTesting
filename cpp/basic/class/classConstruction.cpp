#include<iostream>

using namespace std;

class Line {
    public:
        void setLength(double length);
        double getLength();
        Line();
        Line(double length);

    private:
        double _length;
};

Line::Line() {
    cout << "create Object based on Line" << endl;
}

Line::Line(double length): _length(length) {
    Line();
}

void Line::setLength(double length) {
    _length = length;
}

double Line::getLength() {
    return _length;
}

int main() {
    Line line;
    line.setLength(6.0);
    cout << "Length of line: " << line.getLength() << endl;
    
    Line line2(5.0);
    cout << "Length of line2: " << line2.getLength() << endl;

}