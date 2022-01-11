package org.example;

/*
* when object creation is expensive and you want to hide object creation complexities
*
*/
interface Prototype<T> {
    public Prototype getClone();
}

class MainClass implements Prototype{

    private int id;
    private String name;

    MainClass(int id, String name){
        this.id  = id;
        this.name = name;
    }

    MainClass(MainClass e){
        this.id  = e.id;
        this.name = e.name;
    }

    public Prototype getClone(){
        return new MainClass(this.id,this.name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class ExecuteProgram{
    public static void main(String[] args) {
        MainClass m = new MainClass(1,"Prototype");
        MainClass m1 = (MainClass) m.getClone();
        m1.setId(2);

        System.out.println(m1.getId());
        System.out.println(m.getId());
    }
}
