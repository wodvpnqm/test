package com.qm.designs.pattern.proxy.version1;

import java.util.Collection;

public class Client {
    public static void main(String[] args) throws Exception{
       UserManager userManager = new UserManager();
       Collection<UserModel> col = userManager.getUserByDepId("0101");
       System.out.println(col);
    }
}