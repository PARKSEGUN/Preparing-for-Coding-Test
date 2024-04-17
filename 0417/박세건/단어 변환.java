import java.io.*;
import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {
        int answer=0;
        boolean[] visited=new boolean[words.length];
        Queue<Object[]> q=new LinkedList<>();
        q.add(new Object[] {begin,0});
        while(!q.isEmpty()){
            String cur=(String)q.peek()[0];
            int cnt=(int)q.poll()[1];
            if(cur.equals(target)){
                answer=cnt;
                break;
            }
            for(int i=0;i<words.length;i++){
                if(visited[i]==false&&correctRule(cur,words[i])){
                    visited[i]=true;
                    q.add(new Object[] {words[i],cnt+1});
                }
            }
        }
        return answer;
    }

    public boolean correctRule(String str1,String str2){
        int diffCnt=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                diffCnt++;
                if(diffCnt>1){
                    return false;
                }
            }
        }
        return true;
    }
}
