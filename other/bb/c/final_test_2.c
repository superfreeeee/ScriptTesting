#include<stdio.h>

int match(char* template, char* target) {
    // printf("match \"%s\" and \"%s\"\n", template, target);
    int t1 = 0;
    int t2 = 0;
    while(template[t1] != '\0' && target[t2] != '\0') {
        if(template[t1] != target[t2]) {
            return -1;
        }
        t1++;
        t2++;
    }
    if(target[t2] == '\0') {
        return t2;
    } else {
        return -1;
    }
}

void split(char template[40], char target[40]) {
    int i = 0;
    int count = 0;
    while(template[i] != '\0') {
        int len = match(template + i, target);
        if(len == -1) {
            printf("%c", template[i]);
            i++;
            count++;
        } else {
            if(count == 0) {
                printf("EmptyString");
            }
            printf("\n");
            i += len;
            count = 0;
        }
    }
    if(count == 0) {
        printf("EmptyString");
    }
    printf("\n");
}

int main() {
    char template[40];
    char target[40];
    scanf("%s%s", template, target);

    // printf("%s\n", template);
    // printf("%s\n", target);

    split(template, target);
}