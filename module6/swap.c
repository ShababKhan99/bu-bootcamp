#include <stdio.h>

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b)
{
    int temp = a;
    a = b;
    b = temp;
}

int main()
{
    int a = 10;
    int b = 50;

    printf("Before swap: x=%d, y=%d\n", a, b);

    broken_swap(a, b);

    printf("After swap: x=%d, y=%d\n\n", a, b);

    printf("Before swap: x=%d, y=%d\n", a, b);

    swap(&a, &b);

    printf("After swap: x=%d, y=%d\n", a, b);
}