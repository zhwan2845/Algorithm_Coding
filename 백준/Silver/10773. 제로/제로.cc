#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
typedef struct StackType {
	int top;
	int capacity;
	int* data;
} Stack;
Stack* createStack(int capacity) {
	Stack* stack = (Stack*)malloc(sizeof(Stack));
	stack->top = -1;
	stack->capacity = capacity;
	stack->data = (int*)malloc(sizeof(int) * capacity);

	return stack;
}
int isFull(Stack* stack) {
	if (stack->top >= stack->capacity - 1) {
		return 1;
	}
	else {
		return 0;
	}
}
int isEmpty(Stack* stack) {
	if (stack->top == -1) {
		return 1;
	}
	else {
		return 0;
	}
}
int pop(Stack* stack) {
	if (isEmpty(stack) == 1) {
		return -1;
	}
	else {
		return stack->data[stack->top--];
	}
}
void push(Stack* stack, int value) {
	if (isFull(stack) == 1) {
		return;
	}
	else {
		stack->data[++(stack->top)] = value;
	}
}
int peek(Stack* stack) {
	return stack->data[stack->top];
}
int main() {
	int k;
	int n;
	int sum = 0;

	scanf("%d", &k);

	Stack* stack = createStack(k);

	for (int i = 0; i < k; i++) {
		scanf("%d", &n);
		if (n == 0) {
			pop(stack);
		}
		else {
			push(stack, n);
		}
	}

	for (int i = 0; i <= stack->top; i++) {
		sum += stack->data[i];
	}

	printf("%d\n", sum);

	return 0;
	
}