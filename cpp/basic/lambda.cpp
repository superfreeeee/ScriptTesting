#include<iostream>

using namespace std;

int main() {
    int x = 10, y = 20, z;
    [x,y,&z](int x, int y) { &z = x + y; }();
    cout << "x = " << x << endl;
    cout << "y = " << y << endl;
    cout << "z = x + y = " << z << endl;
}