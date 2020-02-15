#include<iostream>

using namespace std;

class Printer {
    public:
        void print(int i) {
            cout << "int: " << i << endl;
        }

        void print(float f) {
            cout << "float: " << f << endl;
        }

        void print(char c[]) {
            cout << "string: " << c << endl;
        }
};

int main() {
    Printer p;
    int i = 3;
    p.print(3);
    float f = 3.14;
    p.print(f);
    char c[] = "hello";
    p.print(c);

    return 0;
}