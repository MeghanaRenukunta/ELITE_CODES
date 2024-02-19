// <!-- There are N cities, and M routes[], each route is a path between two cities.
// routes[i] = [city1, city2], there is a travel route between city1 and city2.
// Each city is numbered from 0 to N-1.
 
// There are one or more Regions formed among N cities. 
// A Region is formed in such way that you can travel between any two cities 
// in the region that are connected directly and indirectly.
 
// Your task is to findout the number of regions formed between N cities. 
 
// Input Format:
// -------------
// Line-1: Two space separated integers N and M, number of cities and routes
// Next M lines: Two space separated integers city1, city2.
 
// Output Format:
// --------------
// Print an integer, number of regions formed.
 
 
// Sample Input-1:
// ---------------
// 5 4
// 0 1
// 0 2
// 1 2
// 3 4
 
// Sample Output-1:
// ----------------
// 2
 
 
// Sample Input-2:
// ---------------
// 5 6
// 0 1
// 0 2
// 2 3
// 1 2
// 1 4
// 2 4
 
// Sample Output-2:
// ----------------
// 1
 
// Note: Look HINT for explanation. -->


import java.util.*;
class test{
    public static int find(int i,int parent[])
    {
        if(parent[i]==i)
        {
            return i;
        }
        else
        {
            int r=find(parent[i],parent);
            parent[i]=r;
            return r;
        }
    }
    public static void Union(int x,int y,int parent[])
    {
        int x1=find(x,parent);
        int y1=find(y,parent);
        parent[x1]=y1;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int parent[]=new int[n];
        int arr[][]=new int[m][2];
        for(int i=0;i<m;i++)
        {
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        for(int i=0;i<m;i++)
        {
            Union(arr[i][0],arr[i][1],parent);
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(find(parent[i],parent)==i)
            {
                c++;
            }
        }
        System.out.println(c);
    }
}