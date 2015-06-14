/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable {
    String s = "",a;
    int count,count2; double r;
 
    /**
     * The available operators of the calculator.
     */
  
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL,   // MR
        BACK          //←
    }
    /**
     * 顯示數字
     * @param digit 
     */
    public void appendDigit(int digit) {
        s += String.valueOf(digit);
        getDisplay();
    }
    /**
     * 顯示點
     * @param dot 
     */
    public void appendDot(String dot) {
        s += dot;
         getDisplay();
        // TODO code application logic here
    }
    /**
     * 運算功能
     * @param operator 
     */
    public void performOperation(Operator operator) {
           if(operator == Operator.RECIPROCAL)
        {
            if(s !="")
            {
                 r = Double.valueOf(s);
                 r = r/100;
                 s = String.valueOf(r);
                 getDisplay() ;
                 s= "";
            }
        }
        if(operator == Operator.SQRT)
        {
            if(s!="")
            {
                s = String.valueOf(Math.sqrt(Double.parseDouble(s)));
                double a  = Double.parseDouble(s);
                if(s.indexOf(".0")==s.length()-2) s = String.valueOf((int)a);
               getDisplay();
                    
            }
        }
          if(operator == Operator.BACK)
        {
            if(s!="")
            {
                if(s.length()>0) {
                    s = s.substring(0,s.length()-1);
                    if(s.length()==0)
                   {
                        s= "0"; 
                        getDisplay();
                         s = "";
                   }
                    else
                    {
                        getDisplay();
                    }
                }
            }            
            
           
        }
          if(operator == Operator.PERCENT)
        {
            if(s !="")
            {
                 r = Double.valueOf(s);
                 r = r/100;
                 s = String.valueOf(r);
                 getDisplay() ;
                 s= "";
            }
          
        }
        /**
         * 加
         */
        if(operator == Operator.PLUS)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          a = "+";
        }
        /**
         * 減
         */
        
        if(operator == Operator.MINUS)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          a = "-";
         
        }
        /**
         * 乘
         */
         if(operator == Operator.TIMES)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          a = "*";
        }
         /**
          * 除
          */
         
         if(operator == Operator.OVER)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          a = "/";
        }
         /**
          * 等於 判斷運算符號 依各種運算符號運算執行結果
          */
             
        if(operator == Operator.EQUAL)
        {
            if(a =="+")
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count+count2);
                getDisplay();
                s= "";
            }
        
            if(a =="-")
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count-count2);
                getDisplay();
                s= "";
            }
            
             if(a =="*")
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count*count2);
                getDisplay();
                s= "";
            }
            
              if(a =="/")
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count/count2);
                getDisplay();
                s= "";
            }
            
        }
        // TODO code application logic here
    }
    /**
     * 回傳最新值
     * @return 
     */
    public String getDisplay() {
        setChanged();
	notifyObservers(s);
        return null;
    }
    /**
     * 依傳過來的符號來判斷執行哪一種運算結果
     * @param text 
     */
    public void setOperation(String text)
    {
        if(text == "+") performOperation (Operator.PLUS);
        if(text == "=") performOperation (Operator.EQUAL);
        if(text == "-") performOperation (Operator.MINUS);
        if(text == "*") performOperation (Operator.TIMES);
        if(text == "/") performOperation (Operator.OVER);
        if(text == "%") performOperation (Operator.PERCENT); 
        if(text == "←") performOperation (Operator.BACK);
        if(text == "1/x") performOperation (Operator.RECIPROCAL);
        if(text == "√") performOperation (Operator.SQRT);
         
        
    }
  
}
