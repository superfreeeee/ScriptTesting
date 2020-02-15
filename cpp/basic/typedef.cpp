#include<iostream>

using namespace std;

int main() {
    typedef int myint;
    myint a = 1;
    cout << sizeof(myint) << endl;
    cout << sizeof(int) << endl;
    cout << a << endl;
}