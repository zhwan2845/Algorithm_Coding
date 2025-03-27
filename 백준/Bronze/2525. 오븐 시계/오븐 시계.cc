#include <stdio.h>
int main (){
	int PreHour, PreMin, CookHour, CookMin;
	int SumMin;
	int Hour, Min;
	
	scanf("%d %d", &PreHour, &PreMin);
	scanf("%d", &CookMin);
	
	SumMin = PreMin + CookMin;
	if (SumMin >= 60)
	{
		Hour = PreHour + (SumMin / 60);
		Min = SumMin % 60;
		if(Hour > 23){
			Hour = Hour - 24;
		}
		printf("%d %d\n", Hour, Min);
	}
	else
		printf("%d %d\n", PreHour, SumMin);
}
