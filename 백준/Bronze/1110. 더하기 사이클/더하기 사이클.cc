#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main(void)
{
    int n, newN;
    int count = 0;
    //필요한 경우 변수 추가

    scanf("%d", &n);
    newN = n;
    //여기에 코드 추가

    while (1) {
        newN = ((newN / 10) + (newN % 10)) % 10 + ((newN % 10) * 10);
        count += 1;
        if (newN == n) {
            break;
        }
    }

    printf("%d\n", count);
    return 0;
}