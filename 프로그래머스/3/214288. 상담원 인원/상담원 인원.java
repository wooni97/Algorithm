import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        
        List<List<Time>> timeForEachType = new ArrayList<>();
        for(int i = 0; i < k+1; i++) {
            timeForEachType.add(new ArrayList<>());
        }
        
        for(int[]req : reqs){
            int requestTime = req[0];
            int duration = req[1];
            int type = req[2];
            
            timeForEachType.get(type).add(new Time(requestTime, requestTime + duration));
        }
        
        int[][] waitTimeByNumberOfMentors = new int[n+1][k+1];
        for(int mentorNumber = 1; mentorNumber < n + 1; mentorNumber++){
            for(int type = 1; type < k+1; type++){
                waitTimeByNumberOfMentors[mentorNumber][type] = 
                    calculateTime(timeForEachType.get(type), mentorNumber);
            }
        }
        
        int[] numberOfMentors = new int [k+1];
        for(int i = 1; i < k+1; i++){
            numberOfMentors[i] = 1;
        }
        
        int remainMentors = n - k;
        while(remainMentors > 0){
            int chosenType = 0;
            int savedTime = 0;
            
            for(int type = 1; type < k+1; type++){
                int currentMentorNumber = numberOfMentors[type];
                int tempSavedTime = 
                    waitTimeByNumberOfMentors[currentMentorNumber][type] - waitTimeByNumberOfMentors[currentMentorNumber+1][type];
                
                if(tempSavedTime > savedTime) {
                    chosenType = type;
                    savedTime = tempSavedTime;
                }
            }
            
            numberOfMentors[chosenType] += 1;
            remainMentors--;
        }
        
        for(int i = 1; i < k+1; i++){
            int mentors = numberOfMentors[i];
            //System.out.println(mentors);
            answer += waitTimeByNumberOfMentors[mentors][i];
        }
        
        // for(int i = 1; i < n+1; i++){
        //     for(int j = 1; j < k+1; j++){
        //         System.out.print(waitTimeByNumberOfMentors[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
    
    public int calculateTime(List<Time> times, int mentorNumber){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int totalWaitTime = 0;
        
        for(Time time : times){
            if(pq.isEmpty() || pq.size() < mentorNumber){
                pq.add(time.endTime);
            } else {
                int earliestConsultEndTime = pq.poll();
                
                if (time.requestTime < earliestConsultEndTime){
                    totalWaitTime += (earliestConsultEndTime - time.requestTime);
                    pq.add(earliestConsultEndTime + time.endTime - time.requestTime);
                } else {
                    pq.add(time.endTime);
                }
            }
        }
        return totalWaitTime;
    }
    
    private class Time{
        int requestTime;
        int endTime;
        
        public Time(int requestTime, int endTime){
            this.requestTime = requestTime;
            this.endTime = endTime;
        }
    }
}