#include<cstdio>
#include<iostream>

using namespace std;


/**
* 1부터 N까지의 자연수의 합을 계산하는 함수
* @param i
* @return
*/
int getRangeSumFromOne(int i) {
    int sum = 0;
    for (int x=1; x<=i; x++) sum += x;
    return sum;
}


long long getAnswer(int N)
{
    long long sum = 0;

    for (int i=1; i<=N; i++) {
        sum += getRangeSumFromOne(i);
    }

    return sum;
}

int main()
{
	int n;

	scanf("%d", &n);

	long long answer = getAnswer(n);
	
	printf("%lld\n", answer);

	return 0;
}