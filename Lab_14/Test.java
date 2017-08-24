//Name: Wing Yi Wong	


package lab14;

class Test  
{  
  private static final String [] reserved =  
   { "and",  
     "begin",  
     "define",  
     "do",  
     "else",  
     "end",  
     "if",  
     "not",  
     "or",  
     "return",  
     "then",  
     "while" };  
  
  private static int hash(String name)  
  {  
    return name.charAt(1)*11 % name.charAt(0) *12;  
  }  
  
  public static void main(String [] args)  
  {  
    for (int index = 0; index < reserved.length ; index += 1)  
    {  
      System.out.print("h(\"" + reserved[index] + "\") = ");  
      System.out.print(hash(reserved[index]));  
      System.out.println();  
    }  
  }  
}

//Result:
//h("and") = 552
//h("begin") = 396
//h("define") = 132
//h("do") = 252
//h("else") = 924
//h("end") = 1188
//h("if") = 864
//h("not") = 132
//h("or") = 396
//h("return") = 1020
//h("then") = 1200
//h("while") = 876

