#include<iostream>

using namespace std;

int area(int length, int width) {
    return length * width;
}

int main() {
    const int LENGTH = 10;
    const int WIDTH = 5;
    const char NEWLINE = '\n';
    cout << "area = " << area(LENGTH, WIDTH) << NEWLINE;
    
}

