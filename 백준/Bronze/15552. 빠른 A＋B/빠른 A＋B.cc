#define _CRT_SECURE_NO_WARNINGS//질문!!
#include <stdio.h>
int main() {
	int num, a, b;
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		scanf("%d %d", &a, &b);
		printf("%d\n", a + b);
	}
	return 0;
}