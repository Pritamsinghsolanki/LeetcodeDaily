class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Arrays.sort(trips,(t1,t2)->t1[1]-t2[1]);
        // int load=0;
        // Queue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        // for(int i=0;i<trips.length;i++){
        //     while(q.size()>0){
        //         int t[]=q.peek();
        //         if(t[2]<=trips[i][1]){
        //             q.poll();
        //             load-=t[0];
        //         }
        //         else{break;}
        //     }
        //     load+=trips[i][0];
        //     q.add(trips[i]);
        //     if(load>capacity){return false;}
        // }
        // return true;
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        Queue<int[]> q=new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int load=0;
        for(int i=0;i<trips.length;i++){
            while(q.size()>0){
                int[] t=q.peek();
                if(t[2]<=trips[i][1]){
                    q.poll();
                    load-=t[0];
                }else{
                    break;
                }
            }
            load+=trips[i][0];
            q.add(trips[i]);
            if(load>capacity) return false;
        }
        return true;
        
//         int[] arr=new int[1001];
//         for(int[] trip: trips){
//             arr[trip[1]]+=trip[0];
//             arr[trip[2]]-=trip[0];
//         }
//         int carLoad=0;
//         for(int i=0;i<=1000;i++){
//             carLoad+=arr[i];
//             if(carLoad>capacity) return false;
//         }
//         return true;
    }
}