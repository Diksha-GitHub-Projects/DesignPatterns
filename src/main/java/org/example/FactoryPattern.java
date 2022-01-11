package org.example;

// have interface and abstract class and let subclasses create object they want
// -> extends
// --> implements

public class FactoryPattern {
    public static void main(String[] args) {
        SBI sbi = (SBI) FactoryClass.getObject("SBI");
        System.out.println(sbi.getRate(10));
        HDFC hdfc = (HDFC) FactoryClass.getObject("HDFC");
        System.out.println(hdfc.getRate(30));

    }
}

interface Bank{
    public double rate = 0.0;
    public double getRate(double rate);
}

class SBI implements Bank{
   public double getRate(double rate){
       return rate;
   }
}

class HDFC implements Bank{
    public double getRate(double rate){
     return rate;
    }
}

class FactoryClass{
    public static Bank getObject(String type){
        Bank bank = null;
      if(type.equals("SBI")){
          bank =  new SBI();
      }
      if(type.equals("HDFC")){
          bank = new HDFC();
      }
      return bank;
    }
}
