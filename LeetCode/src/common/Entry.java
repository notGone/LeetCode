package common;

import solutions.Problem_01;
import solutions.Problem_02;
import solutions.Problem_02_n;

public class Entry {
  
  public static void main(String[] args){
    System.out.println("--- LeetCode OJ ---");
//    System.out.println(Problem_01.reverseWords("  "));
//    System.out.println(Problem_01.reverseWords("the    sky is blue"));
    String[] tokens = {"4","13","5","/","+"};
    System.out.println(new Problem_02_n().evalRPN(tokens));
  }

}
