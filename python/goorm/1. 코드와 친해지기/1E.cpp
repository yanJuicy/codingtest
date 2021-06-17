#include<stdio.h>
#include<iostream>

using namespace std;

/**
* 동아리 멤버들의 탑승 가능 여부를 출력하는 함수
*
* @param data 각 멤버들의 몸무게 data[0] ~ data[n-1]
* @param n    멤버들의 수
* @param p    놀이기구 탑승 가능 체중 제한
* @param q    놀이기구 최대 하중
*/
void solve(int data[], int n, int p, int q)
{
    int cnt = 0;
    int weight = 0;

    for (int i=0; i<n; i++) {
        if (data[i] <= p) {
            cnt++;
            weight += data[i];
        }
    }

    printf("%d %d\n", cnt, weight);
    printf("%s", weight < q ? "YES" : "NO");
}

int main()
{
	int n, p, q;
	int *data;

	scanf("%d %d %d", &n, &p, &q);
	data = new int[n];
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &data[i]);
	}

	solve(data, n, p, q);

	delete[] data;
	return 0;
}