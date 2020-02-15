#include<stdio.h>

int main() {
    int pay[12];
    int i;
    for(i=0 ; i<12 ; i++) {
        scanf("%d", &pay[i]);
    }
    
    int rest = 0;
    int saved = 0;
    for(i=0 ; i<12 ; i++) {
        rest += 300 - pay[i];
        if(rest < 0) {
            printf("-%d\n", i+1);
            return 0;
        }
        if(rest >= 100) {
            int about_to_saved = rest / 100 * 100;
            saved += about_to_saved;
            rest -= about_to_saved;
        }
    }
    printf("%d\n", (int)(rest + saved * 1.2));
    return 0;
}