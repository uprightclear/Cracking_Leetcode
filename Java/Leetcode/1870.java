class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int length = dist.length;
        
        int start = 1;
        int end = (int)1e7;
        int ans = -1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(isPossible(dist,hour,mid,length)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }

    public boolean isPossible(int[] dist,double hour,int speed,int length){
        double ans = 0;
        for(int i=0;i<length;i++){
            double time = dist[i]*1.0/speed;
            if(i!=length-1)ans = ans + Math.ceil(time);
            else ans += time;
            if(ans>hour) return false;
        }
        return ans<=hour;
    }
}