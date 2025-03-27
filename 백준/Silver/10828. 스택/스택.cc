#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main() {
	int n, num;
	scanf("%d", &n);
	int stack[10001];
	char command[6];
	int top = 0;

	for (int i = 0; i < n; i++) {
		scanf("%s", command);

		if (strcmp(command, "push") == 0) {
			scanf("%d", &num);
			stack[top++] = num;
		}
		else if (strcmp(command, "pop") == 0) {
			if (top == 0) {
				printf("%d\n", -1);
			}
			else {
				printf("%d\n", stack[--top]);
			}
		}
		else if (strcmp(command, "size") == 0) {
			printf("%d\n", top);
		}
		else if (strcmp(command, "empty") == 0) {
			if (top == 0) {
				printf("1\n");
			}
			else {
				printf("0\n");
			}
		}
		else if (strcmp(command, "top") == 0) {
			if (top == 0) {
				printf("-1\n");
			}
			else {
				printf("%d\n", stack[top - 1]);
			}
		}
	}
	return 0;
}