package solutions;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/<br>
 * �°棬���������ȡֵҲʹ��int,�������ڶ���Ŀ��Each operand may be an integer�����ƫ��
 * @author harrisonwang
 *
 */
public class Problem_02_n {
  
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < tokens.length; i++) {
      String curToken = tokens[i];
      if(isDigit(curToken)){
        stack.push(Integer.valueOf(curToken));
      }else{
        int right = stack.pop();
        int left = stack.pop();
        stack.push(calculate(left, right, curToken));
      }
    }
    return stack.pop();
  }
  
  private boolean isDigit(String token) {
    if (!token.startsWith("-") || token.length() <= 1) {
      Pattern pattern = Pattern.compile("[0-9]*");
      return pattern.matcher(token).matches();
    }
    return true;
  }
  
  private int calculate(int left, int right, String op){
    if(op.equals("+")){
      return left+right;
    }else if(op.equals("-")){
      return left-right;
    }else if(op.equals("*")){
      return left*right;
    }else if(op.equals("/")){
      return left/right;
    }else{
      return 0;
    }
  }

}
