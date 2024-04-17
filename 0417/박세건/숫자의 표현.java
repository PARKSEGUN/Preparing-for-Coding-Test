class Solution {
    public int solution(int n) {
        int answer = 0;
        int startNum=1;
        int endNum=1;
        int sum=1;
        while(startNum<=n){

            if(sum>n){
                sum-=startNum;
                startNum++;
            }else if(sum<n){
                endNum++;
                sum+=endNum;
            }else{
                //System.out.println(startNum+" "+endNum+" "+sum);
                answer++;
                endNum++;
                sum+=endNum;
            }
        }
        return answer;
    }
}
