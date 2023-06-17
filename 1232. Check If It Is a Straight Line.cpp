class Solution
{
public:
    int getxdiff(vector<int> &a, vector<int> &b)
    {
        return a[0] - b[0];
    }
    int getydiff(vector<int> &a, vector<int> &b)
    {
        return a[1] - b[1];
    }
    bool checkStraightLine(vector<vector<int>> &co)
    {
        int deltay = getydiff(co[1], co[0]);
        int deltax = getxdiff(co[1], co[0]);

        for (int i = 2; i < co.size(); i++)
        {
            if (deltay * (getxdiff(co[i], co[0])) != deltax * (getydiff(co[i], co[0])))
            {
                return false;
            }
        }
        return true;
    }
};