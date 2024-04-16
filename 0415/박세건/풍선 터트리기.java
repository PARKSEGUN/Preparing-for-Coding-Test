최후에 남을 수 있는 풍선의 규칙을 찾아서 해결
탐색기준 왼쪽의 최솟값을 찾아내고 오른쪽을 찾아내서 미리 매핑하는 방식을 사용해서 O(3n)의 시간복잡도로 최적화가능

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] a) {
        boolean[] isLeft=new boolean[a.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
        List<int[]>  list=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            list.add(new int[] {a[i],i});
            pq.add(new int[] {a[i],i});
        }
        int answer = 2;
        int leftMin=list.get(0)[0];
        int rightMin=pq.peek()[0];
        isLeft[0]=true;
        for(int i=1;i<list.size()-1;i++){
            isLeft[list.get(i)[1]]=true;
            while(isLeft[pq.peek()[1]]==true){
                pq.poll();
            }
            rightMin=pq.peek()[0];
            if(list.get(i)[0]<leftMin||list.get(i)[0]<rightMin){
                answer++;
            }  
            leftMin=Math.min(leftMin,list.get(i)[0]);
            
        }
        return answer;
    }
}
