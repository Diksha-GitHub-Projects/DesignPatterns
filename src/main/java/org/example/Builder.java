package org.example;

// creating complex objects using simple objects in step by step process
// creating different complex objects using same builder process
// use when we want to create immutable objects

public class Builder {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private long phone;

    Builder(UserBuilder user){
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.age = user.age;
        this.phone = user.phone;
        this.address = user.address;
    }

    public static class UserBuilder{
        private String firstName;
        private String lastName;
        private int age;
        private String address;
        private long phone;

        UserBuilder(String firstName,String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder Address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(long phone) {
            this.phone = phone;
            return this;
        }

        public Builder build(){
            return new Builder(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public long getPhone() {
        return phone;
    }

}

class ExecuteBuilder{
    public static void main(String[] args) {
        Builder builder = new Builder.UserBuilder("Builder","Pattern").build();
        Builder builder2 = new Builder.UserBuilder("Builder1","Pattern2").phone(1233).build();
        System.out.println(builder.getFirstName());
        System.out.println(builder.getAddress());
        System.out.println(builder2.getPhone());
    }
}
