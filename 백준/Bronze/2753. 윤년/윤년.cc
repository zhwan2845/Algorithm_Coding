#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main() {
	int num;
	scanf("%d", &num);

	if (num % 4 == 0 && num % 100 != 0)
		printf("1\n");
	else if (num % 400 == 0)
		printf("1\n");
	else
		printf("0\n");

	return 0;
}