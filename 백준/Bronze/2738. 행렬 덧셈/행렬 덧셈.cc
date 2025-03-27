#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main() {
	int n, m;
	scanf("%d %d", &n, &m);

	int arr1[100][100];
	int arr2[100][100];
	int sum[100][100] = { 0, };

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &arr1[i][j]);
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &arr2[i][j]);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			sum[i][j] = arr1[i][j] + arr2[i][j];
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			printf("%d ", sum[i][j]);
		}
		printf("\n");
	}
	return 0;
}