#include<cstdio>
#include<iostream>

using namespace std;

/**
* 생일이 m월인 가장 큰 키의 도토리를 찾는 함수
* @param height  각 도토리의 키
* @param month   각 도토리의 출생 월
* @param n   도토리의 수
* @param m   찾고자 하는 달
* @return    month[k] == m인 가장 큰 height[k]
*/
int getMaximumHeight(int height[], int month[], int n, int m)
{
    int max = -1;
    for (int i=0; i<n; i++) {
        if (month[i] == m && max < height[i]) {
            max = height[i];
        }
    }
    return max;
}

int main()
{
	int n, m;
	int* height;
	int* month;

	scanf("%d", &n);
	height = new int[n];
	month = new int[n];

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &height[i]);
	}

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &month[i]);
	}

	scanf("%d", &m);

	int answer = getMaximumHeight(height, month, n, m);

	printf("%d\n", answer);

	delete[] height;
	delete[] month;
	return 0;
}