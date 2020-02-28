#include<stdio.h>

void to_lower_case(char str[]);
void to_upper_casae(char str[]);

int is_alpha(char c);
int is_lower_alpha(char c);
int is_upper_alpha(char c);

void test_to_lower_case() {
    char string[] = "abcdeFGHIJ";
    printf("origin: %s\n", string);
    to_lower_case(string);
    printf("to_lower_case: %s\n", string);
}

void test_to_upper_case() {
    char string[] = "abcdeFGHIJ";
    printf("origin: %s\n", string);
    to_upper_casae(string);
    printf("to_upper_case: %s\n", string);

}

int main() {
    test_to_lower_case();
    test_to_upper_case();
    return 0;
}

// TODO: 將字符串 str 內的所有英文字母轉成小寫
void to_lower_case(char str[]) {
    int i;
    for(i=0 ; str[i]!='\0' ; i++) {
        if(is_upper_alpha(str[i])) {
            str[i] = str[i] - 'A' + 'a';
        }
    }
}

// TODO: 將字符串 str 內的所有英文字母轉成大寫
void to_upper_casae(char str[]) {
    int i;
    for(i=0 ; str[i]!='\0' ; i++) {
        if(is_lower_alpha(str[i])) {
            str[i] = str[i] - 'a' + 'A';
        }
    }
}

int is_alpha(char c) {
    return is_lower_alpha(c) || is_upper_alpha(c);
}

int is_lower_alpha(char c) {
    return 'a' <= c && c <= 'z';
}

int is_upper_alpha(char c) {
    return 'A' <= c && c <= 'Z';
}
