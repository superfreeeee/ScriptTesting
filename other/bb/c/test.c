#include<stdio.h>

int trim(char* str) {
    int i = 0;
    while(str[i] == ' ') {
        i++;
    }
    return i;
}

int StrFunc(char* str){
    int i = trim(str);
    if(str[i] == '-' || str[i] >= '0' && str[i] <= '9') {
        int is_negative = 0;
        if(str[i] == '-') {
            is_negative = 1;
            i++;
        }
        int sum = 0;
        for( ; str[i] != '\0' ; i++) {
            if(!(str[i] >= '0' && str[i] <= '9')) {
                break;
            }
            sum = sum * 10 + str[i] - '0';
        }
        if(is_negative) {
            return -sum;
        } else {
            return sum;
        }
    } else {
        return 0;
    }
    
    // for(i = trim(str) ; str[i] != '\0';i++){
    //     if(str[0] >= 'a' && str[0] <= 'z' && str[0] >= 'A' && str[0] <= 'Z'){
    //         return;
    //     }
    //     else if(str[i] == '-'){
    //         printf("-");
    //     }
    //     else if(str[i] >= '0' && str[i] <= '9'){
    //         printf("%c",str[i]);
    //     }
    // }
}

void input(char* str) {
    char c;
    scanf("%c", &c);
    int i = 0;
    while(c != '\n') {
        str[i] = c;
        i++;
        scanf("%c", &c);
    }
    str[i] = '\0';
}

int main(){
    char str[40];
    input(str);

    int num = StrFunc(str);

    printf("%d\n", num);
    
}