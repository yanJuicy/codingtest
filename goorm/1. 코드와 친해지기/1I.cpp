#include<cstdio>
#include<iostream>

using namespace std;


/**
* 주어진 범위의 최소값의 위치를 반환하는 함수
* @param data  데이터 배열
* @param n     배열의 크기
* @param begin 탐색 할 가장 첫(왼쪽) 인덱스
* @param end   탐색 할 가장 마지막(오른쪽) 인덱스
* @return	   data[begin] ~ data[end] 중 가장 작은 원소의 인덱스
*/
int getMinIndexInRange(int data[], int n, int begin, int end)
{
    int min = data[begin];
    int index = begin;
    for (int i= begin + 1; i<=end; i++) {
        if (min > data[i]) {
            index = i;
            min = data[i];
        }
    }
    return index;
}

void selectionSort(int data[], int n)
{
	for (int i = 0; i < n; i++)
	{
		//주어진 범위에서 가장 작은 원소의 위치를 찾는다.
		int minIndex = getMinIndexInRange(data, n, i, n - 1);
        int temp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = temp;
	}
}

int main()
{
	int n;
	int* data;

	scanf("%d", &n);
	data = new int[n];

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &data[i]);
	}

	selectionSort(data, n);
	
	for (int i = 0; i < n; i++)
	{
		if (i > 0)
		{
			printf(" ");
		}
		printf("%d", data[i]);
	}

	delete[] data;
	return 0;
}