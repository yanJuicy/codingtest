#include<cstdio>
#include<cmath>
#include<iostream>

using namespace std;


/**
 * 평균과의 차가 가장 작은 데이터의 번호를 반환하는 함수
 * 여러 가지라면 가장 빠른 번호를 반환한다.
 *
 * @param data 
 * @param n 
 * @return int  가장 평균과 가까운 데이터의 번호 (1번부터 시작)
 */
int findIndex(int data[], int n)
{
    int avg = 0;
    int sum = 0;
    for (int i=0; i<n; i++) {
        sum += data[i];
    }

    avg = sum / n;

    int index = 0;
    int min = 987654321;
    for (int i=0; i<n; i++) {
        if (abs(data[i] - avg) < min) {
            min = abs(data[i] - avg);
            index = i;
        }
    }

    return index + 1;
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

	int answer = findIndex(data, n);
	printf("%d %d\n", answer, data[answer-1]);

	delete[] data;
	return 0;
}