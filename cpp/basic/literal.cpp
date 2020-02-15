#include<iostream>

using namespace std;

void print_num();
void print_num_float();
void print_b();
void division();

int num;
float num_float;
bool b;

int main() {
    num = 212;
    print_num();
    num = 215u;
    print_num();
    num = 0x101L;
    print_num();
    num = 012;
    print_num();

    division();

    num = 85;
    print_num();
    num = 020;
    print_num();
    num = 0x123;
    print_num();
    num = 30;
    print_num();
    num = 30u;
    print_num();
    num = 30l;
    print_num();
    num = 30ul;
    print_num();

    division();

    num_float = 3.14;
    print_num_float();
    num_float = 314159E-5;
    print_num_float();

    division();

    b = true;
    print_b();
    b = false;
    print_b();
}

void division() {
    cout << "\n===== division =====\n" << endl;
}

void print_num() {
    cout << "num = " << num << endl;
}

void print_num_float() {
    cout << "num_float = " << num_float << endl;
}

void print_b() {
    cout << "b = " << b << endl;
}