#include<stdio.h>

void to_lower_case(char str[]);
void to_upper_casae(char str[]);

int is_lower_alpha(char c);
int is_upper_alpha(char c);

void string_equals(char str1[], char str2[]);
void test_invoke(char func_name[]);
void test_to_lower_case();
void test_to_upper_case();

int main() {
    test_to_lower_case();
    test_to_upper_case();
    return 0;
}

// TODO: 將字符串 str 內的所有英文字母轉成小寫
void to_lower_case(char str[]) {

}

// TODO: 將字符串 str 內的所有英文字母轉成大寫
void to_upper_casae(char str[]) {

}
// TODO: 檢查字符是否為小寫字母
int is_lower_alpha(char c) {

}

// TODO: 檢查字符是否為大寫字母
int is_upper_alpha(char c) {

}

// ! Don't edit the following program
int string_equals(char str1[], char str2[]) {
    int i=0;
    int count=0;
    for( ; ; ) {
        if(str1[i] != str2[i]) {
            return str1[i] - str2[i];
        } else if(str1[i] == '\0') {
            return 0;
        }
        count++;
        if(count >= 1000) {
            printf("string too long\n");
            return 0;
        }
    }
}

void test_invoke(char func_name[]) {
    printf("===== test %s =====", func_name);
}

void test_to_lower_case() {
    char string[] = "abcdeFGHIJ";
    char ans[] =    "abcedfghij";
    
    printf("origin: %s\n", string);
    to_lower_case(string);
    printf("result: %s\n", string);
    printf("expect: %s\n", ans);
    printf("")
}

void test_to_upper_case() {
    char string[] = "abcdeFGHIJ";
    char ans[] =    "ABCDEFGHIJ";
    printf("origin: %s\n", string);
    to_upper_casae(string);
    printf("to_upper_case: %s\n", string);
}
