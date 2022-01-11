package org.example;

public class LazySingleton {
    private static LazySingleton singletonObject;
    private LazySingleton(){

    }

    public static LazySingleton getObject(){
        // two threads are here
      if(singletonObject == null)
          synchronized (LazySingleton.class){
          // first thread creates and exist , second thread should check again
            if(singletonObject == null){
                singletonObject = new LazySingleton();
            }
          }

        return singletonObject;
    }


    public String createDatabaseConnection(){
        return "databaseConnection";
    }

}

class InitializeObj{
    public static void main(String[] args) {
        LazySingleton singletonObj = LazySingleton.getObject();
        System.out.println(singletonObj.createDatabaseConnection());
    }
}