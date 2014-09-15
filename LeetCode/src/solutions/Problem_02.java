package solutions;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/<br>
 * �Ҽ�����������������ֵ�������һ����ȡ������ʧ�����������ط���100%��ȷ��������վ�ļ��㷽ʽ����������Ĳ�һ��<br>
 * ��һ����дһ��������ͼ���㷨�� 
 *   
 * @author harrisonwang
 */
public class Problem_02 {

  public int evalRPN(String[] tokens) {
    Stack<Number> numbers = new Stack<Number>();
    if (tokens != null && tokens.length > 0) {
      for (int i = 0, lg = tokens.length; i < lg; i++) {
        String curToken = tokens[i];
        if (isNumeric(curToken)) {
          numbers.push(new Number(Integer.valueOf(curToken), 1));
        } else {
          Number rOp = numbers.pop();
          Number lOp = numbers.pop();
          numbers.push(calculate(lOp, rOp, curToken));
        }
      }
    }
    Number res = numbers.pop();
    return Math.round((res.getUpNum() + 0.0f) / res.getDownNum());
  }

  private Number calculate(Number ln, Number rn, String op) {
    int lnUp = ln.getUpNum();
    int lnDown = ln.getDownNum();
    int rnUp = rn.getUpNum();
    int rnDown = rn.getDownNum();
    int nUp = 0, nDown = 1;
    if (op.equals("+")) {
      nUp = lnUp * rnDown + lnDown * rnUp;
      nDown = lnDown * rnDown;
    } else if (op.equals("-")) {
      nUp = lnUp * rnDown - lnDown * rnUp;
      nDown = lnDown * rnDown;
    } else if (op.equals("*")) {
      nUp = lnUp * rnUp;
      nDown = lnDown * rnDown;
    } else if (op.equals("/")) {
      nUp = lnUp * rnDown;
      nDown = lnDown * rnUp;
    }
    return new Number(nUp, nDown);
  }

  class Number { 
    private int upNum;
    private int downNum;

    public int getUpNum() {
      return upNum;
    }

    public int getDownNum() {
      return downNum;
    }

    public Number(int up, int down) {
      this.upNum = up;
      this.downNum = down;
    }
  }

  private boolean isNumeric(String str) {
    String nStr = str;
    if (str.startsWith("-") && str.length() > 1) {
      nStr = str.substring(1);
    }
    Pattern pattern = Pattern.compile("[0-9]*");
    return pattern.matcher(nStr).matches();
  }

}
