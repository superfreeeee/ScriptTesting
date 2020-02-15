#include<iostream>

using namespace std;

int main() {
    enum color {
        RED,
        GREEN,
        BLUE,
        A = 4,
        B,
        C= 6,
        D,
        E = 0,
        F
    }c;
    c = RED;
    cout << c << endl;
    c = GREEN;
    cout << c << endl;
    c = BLUE;
    cout << c << endl;
    c = A;
    cout << c << endl;
    c = B;
    cout << c << endl;
    c = C;
    cout << c << endl;
    c = D;
    cout << c << endl;
    c = E;
    cout << c << endl;
    c = F;
    cout << c << endl;
}