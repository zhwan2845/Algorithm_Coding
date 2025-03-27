#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
typedef struct dequeType {
	int front;
	int rear;
	int capacity;
	int* data;
	int size;
} deque;
deque* createDeq(int capacity) {
	deque* deq = (deque*)malloc(sizeof(deque));
	deq->front = 0;
	deq->rear = 0;
	deq->capacity = capacity;
	deq->data = (int*)malloc(sizeof(int) * capacity);
	deq->size = 0;

	return deq;
}
int isEmpty(deque* deq) {
	return deq->front == deq->rear ? 1 : 0;
}
int isFull(deque* deq) {
	return deq->front == (deq->rear + 1) % deq->capacity;
}
void addRear(deque* deq, int value) {
	if (isFull(deq) == 1) {
		return;
	}
	else {
		deq->size++;
		deq->rear = (deq->rear + 1) % deq->capacity;
		deq->data[deq->rear] = value;
	}
}
int deleteFront(deque* deq) {
	if (isEmpty(deq) == 1) {
		return -1;
	}
	else {
		deq->size--;
		deq->front = (deq->front + 1) % deq->capacity;
		return deq->data[deq->front];
	}
}
void addFront(deque* deq, int value) {
	if (isFull(deq) == 1) {
		return;
	}
	else {
		deq->size++;
		deq->data[deq->front] = value;
		deq->front = ((deq->front - 1) + deq->capacity) % deq->capacity;
	}
}
int deleteRear(deque* deq) {
	if (isEmpty(deq) == 1) {
		return -1;
	}
	else {
		deq->size--;
		int retValue = deq->data[deq->rear];
		deq->rear = ((deq->rear - 1) + deq->capacity) % deq->capacity;
		return retValue;
	}
}
int main() {
	int size;
	scanf("%d", &size);

	deque* deq = createDeq(size + 1);

	for (int i = 1; i <= size; i++) {
		addRear(deq, i);
	}
	
	while (deq->size > 1) {
		deleteFront(deq); 
		int value = deleteFront(deq);
		addRear(deq, value);
	}

	printf("%d\n", deq->data[deq->rear]);

	free(deq);
	return 0;
}