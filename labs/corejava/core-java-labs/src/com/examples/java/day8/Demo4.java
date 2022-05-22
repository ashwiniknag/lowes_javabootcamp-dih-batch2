package com.examples.java.day8;
class UserAlreadyLoggedInException extends Exception {

}
class Authentication{
    private boolean isLoggedIn = false;
    public void login(String userid, String password) throws UserAlreadyLoggedInException {
        if(!isLoggedIn){
            if (userid.equals("user1") && password.equals("abc123")) {
                isLoggedIn =true;
                System.out.println("Logged in successfully");
            } else {
              System.out.println("login failed! try again ");
           }
            } else {
                throw new UserAlreadyLoggedInException();

            }
    }
}
public class Demo4 {
    public static void main(String[] args) {
    Authentication auth = new Authentication();
    try {
        auth.login("user1", "abc123");
    }catch(UserAlreadyLoggedInException e){
        e.printStackTrace();
    }
    try {
        auth.login("user2", "aaaa");
    }catch (UserAlreadyLoggedInException e) {
           System.out.println("hey! you already logged in");
        }
    }
}
