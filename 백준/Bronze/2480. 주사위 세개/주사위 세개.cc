#include <stdio.h>
int main() {
	int x, y, z, prize = 0, max = 0;
	scanf("%d %d %d", &x, &y, &z);

	if (x == y && x == z && y == z)

		prize = 10000 + x * 1000;
	else if (x == y || x == z)

		prize = 1000 + x * 100;



	else if (y == z)

		prize = 1000 + y * 100;



	else {



		if (x > y && x > z)

			max = x;



		else if (y > x && y > z)

			max = y;



		else if (z > x && z > y)

			max = z;
		prize = max * 100;

	}
	printf("%d", prize);

	return 0;
}

