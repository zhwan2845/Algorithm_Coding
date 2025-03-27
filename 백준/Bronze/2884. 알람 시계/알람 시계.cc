#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main() {
	int h, m;
	scanf("%d %d", &h, &m);

	if (h == 0) {
		if (m > 45)
			printf("%d %d\n", h, m - 45);
		else if (m == 45)
			printf("%d %d\n", h, m - 45);
		else
			printf("%d %d\n", 23, 60 - (45 - m));
	}	
	else {
		if (m > 45)
			printf("%d %d\n", h, m - 45);
		else if (m == 45)
			printf("%d %d\n", h, m - 45);
		else
			printf("%d %d\n", h - 1, 60 - (45 - m));
	}

	return 0;
}