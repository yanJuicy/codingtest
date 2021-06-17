#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;


class FenceRepairing {
public:
	vector<double> memo;            // DP 상태공간
	vector<bool> isBroken;        	// 각 팬스가 고장났는지의 여부
	int n;                    		// 팬스의 길이

	FenceRepairing(string str) {
		this->n = str.length();
		this->memo.assign(str.length(), -1);
		this->isBroken.resize(str.length());
		for (int i = 0; i < str.length(); i += 1) {
			isBroken[i] = str[i] == 'X';
		}
	}

	/**
	 * 0번째 팬스부터 (lastIndex)번째 팬스까지 모두 완벽히 수리하는데 소요되는 최소의 비용
	 *
	 * @param lastIndex 수리할 가장 마지막(오른쪽) 팬스의 인덱스
	 * @return 그 때의 최소 비용
	 */
	double f(int lastIndex) {
		if (lastIndex < 0) {
			// 수리할 팬스가 없는 경우
			return 0;
		} else if (memo[lastIndex] != -1) {
			// 이미 계산한 적 있는 경우
			return memo[lastIndex];
		} else if (lastIndex == 1) {
            return 1;
        }

		// 0번째부터 모두 한 번에 교체하는 경우
		double answer = sqrt(lastIndex + 1);

        if (isBroken[lastIndex] == false) {
            answer = f(lastIndex - 1);
        } else {
            // 현재 팬스가 교체 범위의 오른쪽 끝
            // [previousIndex, lastIndex] 범위를 모두 한 번에 교체할 때 최소 비용
            for (int previousIndex = 0; previousIndex <= lastIndex; previousIndex++) {
                double newCost = 0;
                newCost += sqrt(lastIndex - previousIndex + 1);
                newCost += f(previousIndex - 1);
                if (newCost < answer) {
                    answer = newCost;
                }
            }
        }

		memo[lastIndex] = answer;
		return memo[lastIndex];
	}

};

int main() {
	string str;
	cin >> str;

	FenceRepairing problem(str);
	double answer = problem.f(str.length() - 1);

	cout << fixed << setprecision(3) << answer << endl;
}
