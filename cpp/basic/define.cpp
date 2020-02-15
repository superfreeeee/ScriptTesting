#include<iostream>

using namespace std;

#define LENGTH 10
#define WIDTH 5
#define NEWLINE '\n'

int area() {
    return LENGTH * WIDTH;
}

int main() {
    cout << "area = " << area() << NEWLINE;
}