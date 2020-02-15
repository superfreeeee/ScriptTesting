#include<iostream>
#include<string>

using namespace std;

void for_test() {
    for(int i=0 ; i<5 ; i++) {
        cout << "i = " << i << endl;
    }
    cout << endl;
    int my_array[5] = {1,3,5,7,9};
    for(int &x : my_array) {
        x *= x;
        cout << "x = " << x << endl;
    }
    cout << endl;
    string str("some string");
    for(char &c : str) {
        c = toupper(c);
    }
    cout << "string = " << str << endl;
}

void while_test() {
    int a = 0;
    while(a < 5) {
        cout << "a = " << a << endl;
        a++;
    }
}

void do_while_test() {
    int a = 0;
    do {
        a++;
        cout << "a = " << a << endl;
    }while(a < 5);
}

int main() {
    cout << "invoke for_test" << endl;
    for_test();
    cout << "\ninvoke while_test" << endl;
    while_test();
    cout << "\ninvoke do_while_test" << endl;
    do_while_test();
}