class Solution
{
public:
    int minFlips(int a, int b, int c)
    {
        return ((a | b) ^ c) + (a & b & ~c);
    }
};