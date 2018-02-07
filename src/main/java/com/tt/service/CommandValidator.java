package com.tt.service;

import java.util.HashSet;
import java.util.Set;

public class CommandValidator {
    public static final String NEWACCOUNT = "NEWACCOUNT";
    public static final String DEPOSIT = "DEPOSIT";
    public static final String WITHDRAW = "WITHDRAW";
    public static final String BALANCE = "BALANCE";
    Set<String> commands= new HashSet<String>();

    public CommandValidator() {
        commands.add(NEWACCOUNT);
        commands.add(DEPOSIT);
        commands.add(WITHDRAW);
        commands.add(BALANCE);
    }

    public boolean validateCommand(String command){
        String[] commArr = command.trim().split(" ");
//        System.out.println(command);
//        System.out.println(Arrays.toString(commArr));
        if(commArr.length > 3 || commArr.length < 2) return false;
        if(commArr[0].equals(NEWACCOUNT)&&commArr[1].length()!=5) return false;
        if(commArr.length == 3 && (commArr[0].equals(BALANCE) || commArr[0].equals(NEWACCOUNT))) return false;
        if(commArr.length == 2 && (commArr[0].equals(DEPOSIT) || commArr[0].equals(WITHDRAW))) return false;
        if(!commands.contains(commArr[0])) return false;
        if(commArr.length == 3 && Float.valueOf(commArr[2])<0.f);
        return true;
    }
}
