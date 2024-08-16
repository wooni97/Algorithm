import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = {};
        
        for(long number : numbers) {
            System.out.println(Long.toBinaryString(number));
        }
        return answer;
    }
}