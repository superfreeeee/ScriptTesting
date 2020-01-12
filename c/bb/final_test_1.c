#include<stdio.h>

int compareTo(char str1[40], char str2[40]) {
    int p1 = 0;
    int p2 = 0;
    while(str1[p1] != '\0' && str2[p2] != '\0') {
        if(str1[p1] != str2[p2]) {
            return str1[p1] - str2[p2];
        }
        p1++;
        p2++;
    }
    if(str1[p1] == str2[p2]) {
        return 0;
    } else if(str1[p1] == '\0') {
        return -1;
    } else {
        return 1;
    }
}

void copy_string(char from[40], char to[40]) {
    int i = 0;
    while(from[i] != '\0') {
        to[i] = from[i];
        i++;
    }
    to[i] = '\0';
}

int find(int find_max, char strs[100][40]) {
    int target = 0;
    int i;
    for(i=0 ; strs[target][i] != '\0' ; i++) {
        if(find_max) {
            if(compareTo(strs[target], strs[i]) < 0) {
                target = i;
            }
        } else {
            if(compareTo(strs[target], strs[i]) > 0) {
                target = i;
            }
        }
    }
    return target;
}

void find_and_put_result(char strs[100][40], char result[2][40]) {
    int min = find(0, strs);
    copy_string(strs[min], result[0]);

    int max = find(1, strs);
    copy_string(strs[max], result[1]);
}

void single_test(char result[2][40]) {
    int n;
    scanf("%d", &n);
    char strs[100][40];
    int i;
    for(i=0 ; i<n ; i++) {
        scanf("%s", strs[i]);
    }
    find_and_put_result(strs, result);
}

int main() {
    int t;
    scanf("%d", &t);
    int i;
    char result[100][2][40];
    for(i = 0; i < t ; i++) {
        single_test(result[i]);
    }
    for(i=0 ; i<t ; i++) {
        printf("%s %s\n", result[i][0], result[i][1]);
    }
}
