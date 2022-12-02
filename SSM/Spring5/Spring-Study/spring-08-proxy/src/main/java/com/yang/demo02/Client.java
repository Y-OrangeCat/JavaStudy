package com.yang.demo02;

public class Client {
    public static void main(String[] args) {
//        UserServiceImpl userService=new UserServiceImpl();
//        userService.insert();

        UserService userService=new UserServiceImpl();
        UserServiceProxy proxy= new UserServiceProxy();
       proxy.setUserService(userService);
       proxy.insert();

    }
}
