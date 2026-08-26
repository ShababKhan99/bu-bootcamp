#include <stdio.h>

void print_math()
{
    int first;
    int second;

    printf("Enter first number: ");
    scanf("%d", &first);

    printf("Enter second number: ");
    scanf("%d", &second);

    int sum = first + second;
    int product = first * second;

    printf("Sum: %d \n", sum);
    printf("product: %d \n", product);
}

int main()
{
    print_math();
}