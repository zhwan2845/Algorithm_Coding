#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main() {
	int arr[100][100] = {0,};
	int n;
	int x, y;
	int cnt = 0;

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d", &x, &y);
		for (int j = y; j < y + 10; j++) {
			for (int k = x; k < x + 10; k++) {
				arr[j][k] = 1;
			}
		}
	}
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			if (arr[i][j] == 1) {
				cnt++;
			}
		}
	}

	printf("%d", cnt);
	return 0;
}