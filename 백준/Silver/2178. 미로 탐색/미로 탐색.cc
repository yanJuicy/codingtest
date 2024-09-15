#include <iostream>
#include <queue>

using namespace std;

int N, M;
char graph[102][102];
bool visit[102][102];
int result;
pair<int, int> direction[4] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

void bfs()
{
    queue< pair<int, int> > q;
    q.push({1, 1});
    visit[1][1] = true;

    while(!q.empty())
    {
        int len = q.size();
        while(len--)
        {
            int i=q.front().first, j=q.front().second; q.pop();

            if (i == N && j == M) 
            {
                result++;
                return;
            }

            for (int l=0; l<4; l++)
            {
                int nextI = i + direction[l].first;
                int nextJ = j + direction[l].second;

                if (graph[nextI][nextJ]=='1' && !visit[nextI][nextJ])
                {
                    q.push({nextI, nextJ});
                    visit[nextI][nextJ] = true;
                }
            }
        }
        result++;
    }

}

int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    cin >> N >> M;

    for (int i=1; i<=N; i++)
        for (int j=1; j<=M; j++) cin >> graph[i][j];

    bfs();
    cout << result;
    return 0;
}
