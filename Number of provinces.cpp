class Solution
{
public:
    void dfs(int node, vector<vector<int>> &isConnected, vector<bool> &mark)
    {
        mark[node] = true;
        for (int i = 0; i < isConnected.size(); i++)
        {
            if (isConnected[node][i] && !mark[i])
            {
                dfs(i, isConnected, mark);
            }
        }
    }
    void bfs(int node, vector<vector<int>> &isConnected, vector<bool> &mark)
    {
        queue<int> q;
        q.push(node);
        mark[node] = true;

        while (!q.empty())
        {
            node = q.front();
            q.pop();

            for (int i = 0; i < isConnected.size(); i++)
            {
                if (isConnected[node][i] && !mark[i])
                {
                    q.push(i);
                    mark[i] = true;
                }
            }
        }
    }
    class UnionFind
    {
    private:
        vector<int> parent, rank;
        int count;

    public:
        UnionFind(int size)
        {
            parent.resize(size);
            rank.resize(size);
            count = size;
            for (int i = 0; i < size; i++)
            {
                parent[i] = i;
            }
        }

        int find(int x)
        {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union_set(int x, int y)
        {
            int xset = find(x), yset = find(y);
            if (rank[xset] < rank[yset])
            {
                parent[xset] = yset;
            }
            else if (rank[xset] > rank[yset])
            {
                parent[yset] = xset;
            }
            else
            {
                parent[yset] = xset;
                rank[xset] += rank[yset];
            }
        }
    };
    int findCircleNum(vector<vector<int>> &isConnected)
    {
        int n = isConnected.size();
        // vector<bool> mark(n);
        int components = n;
        UnionFind dsu(n);

        // queue<int> q;
        // for(int i=0;i<n;i++){
        //  if(!mark[i]){
        //    components++;
        //     / // dfs(i,isConnected,mark);
        // bfs(i,isConnected,mark);
        //}
        // }

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (isConnected[i][j] && dsu.find(i) != dsu.find(j))
                {
                    components--;
                    dsu.union_set(i, j);
                }
            }
        }
        return components;
    }
};