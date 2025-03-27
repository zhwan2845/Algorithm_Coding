#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int  main() {
	int total, num, cnt, price;
	int sum = 0;
	scanf("%d", &total);
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		scanf("%d %d", &price, &cnt);
		sum += (price * cnt);
	}
	if (sum == total) {
		printf("Yes\n");
	}
	else {
		printf("No\n");
	}
	return 0;
}