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
    return deq->front == (deq->rear + 1) % deq->capacity ? 1 : 0;
}

void addRear(deque* deq, int value) {
    if (isFull(deq) == 1) {
        return;
    }
    deq->size++;
    deq->rear = (deq->rear + 1) % deq->capacity;
    deq->data[deq->rear] = value;
}

int deleteFront(deque* deq) {
    if (isEmpty(deq) == 1) {
        return -1;
    }
    deq->size--;
    deq->front = (deq->front + 1) % deq->capacity;
    return deq->data[deq->front];
}

void addFront(deque* deq, int value) {
    if (isFull(deq) == 1) {
        return;
    }
    deq->size++;
    deq->data[deq->front] = value; // 값을 먼저 넣기
    deq->front = ((deq->front - 1) + deq->capacity) % deq->capacity;
}

int deleteRear(deque* deq) {
    if (isEmpty(deq) == 1) {
        return -1;
    }
    deq->size--;
    int retValue = deq->data[deq->rear];
    deq->rear = ((deq->rear - 1) + deq->capacity) % deq->capacity;
    return retValue;
}
int main() {
    int size, n;
    scanf("%d %d", &size, &n);
    int* arr = (int*)malloc(sizeof(int) * n);
    int cnt = 0;

    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    deque* deq = createDeq(size + 1); 

    for (int i = 1; i <= size; i++) {
        addRear(deq, i);
    }

    for (int i = 0; i < n; i++) {
        int pos;
        // 한개 남은 경우
        if (deq->size == 1) {
            continue;
        }

        for (int j = 0; j < deq->size; j++) {
            if (arr[i] == deq->data[(deq->front + j + 1) % deq->capacity]) {
                // (deq->front + 1) % deq->capacity
                pos = j;
                break;
            }
        }
        if (pos == 0) {
            deleteFront(deq);
            continue;
        }
        if (pos <= deq->size / 2) { 
            while (pos > 0) {
                addRear(deq, deleteFront(deq));
                pos--;
                cnt++; 
            }
            deleteFront(deq); //연산의 중복을 피하기 위해 마지막 deleteFront()를 별도로 호출
        }
        else {
            while (pos < deq->size) { 
                addFront(deq, deleteRear(deq));
                pos++;
                cnt++;
            }
            deleteFront(deq); 
        }
    }

    printf("%d\n", cnt);

    free(deq->data);
    free(deq);
    free(arr);
    return 0;
}