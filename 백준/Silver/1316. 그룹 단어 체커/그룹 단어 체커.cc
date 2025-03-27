#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int checkGroupString(char s[]);
int main() {
	int num;
	scanf("%d", &num);
	char s[101];
	int count = 0;

	for (int i = 0; i < num; i++) {
		scanf("%s", s);
		count += checkGroupString(s);
	}

	printf("%d\n", count);

	return 0;
}
int checkGroupString(char s[]) {
	for (int i = 0; s[i] != '\0'; i++) {
		for (int k = i + 1; s[k] != '\0'; k++) {
			if (s[i] == s[k]) {
				int dist = k - i;
				if (dist > 1) {
					if (s[k] != s[k - 1])
						return 0;
				}
			}
		}
	}
	return 1;
}
