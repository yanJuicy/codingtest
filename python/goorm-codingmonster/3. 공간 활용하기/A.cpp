#include <cstdio>

using namespace std;

const int MAX_TABLE_LENGTH = 10000;

/**
* data[0] ~ data[n-1]에 등장한 번호들에 대한 빈도수 테이블을 채우는 함수
* @param data
* @param n
* @param table  table[x] := data배열에서 x가 등장한 횟수
*/
void fillFrequencyTable(int data[], int n, int table[]) {
    for (int i=0; i<n; i++) {
        table[data[i]]++;
    }
}

/**
* data[0] ~ data[n-1]사이에서 가장 많이 등장한 번호를 반환하는 함수
* @param data
* @param n
* @return  가장 많이 등장한 번호. 여러개인 경우 사전순으로 가장 빠른 번호.
*/
int getFrequentNumber(int data[], int n, int table[]) {
	// 0000~9999 중에서 가장 많이 등장한 번호를 구해보자
	int frequent_number = 0;
    int max_frequency = 0;

    for (int i = 0000; i<10000; i++) {
        int count = table[i];
        if (max_frequency < count) {
            max_frequency = count;
            frequent_number = i;
        }

    }

	return frequent_number;
}

int main() {
	int n;

	scanf("%d", &n);
	int* data = new int[n];

	for (int i = 0; i < n; ++i) {
		scanf("%d", &data[i]);
	}

    int* table = new int[MAX_TABLE_LENGTH];
    fillFrequencyTable(data, n, table);
	int answer = getFrequentNumber(data, n, table);

	// 네 자리로 출력
	printf("%04d", answer);

	delete[] data;

	return 0;
}
