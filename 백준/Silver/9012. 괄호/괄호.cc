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
	int n;
	scanf("%d", &n);

	int flag = 1;

	while (n--) {
		char c[51];
		scanf("%s", c);
		Stack* stack = createStack(51);

		for (int i = 0; c[i] != '\0'; i++) {
			if (c[i] == '(') {
				push(stack, 0);
			}
			else {
				if (isEmpty(stack) == 1) {
					printf("NO\n");
					flag = 0;
					break;
				}
				else {
					flag = 1;
					pop(stack);
				}
			}
		}

		if (flag == 1 && isEmpty(stack) == 1) {
			printf("YES\n");
		}
		if(isEmpty(stack) == 0) {
			printf("NO\n");
		}
		free(stack->data);
		free(stack);
	}
	return 0;
}
