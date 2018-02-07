package com.tt;

import com.tt.repository.AccountRepository;
import com.tt.service.AccountService;
import com.tt.service.CommandValidator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
import java.util.logging.Level;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        logOff();

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
        AccountRepository bean = ctx.getBean(AccountRepository.class);


        while (true) {
            System.out.print("Command:");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            CommandValidator commandValidator = new CommandValidator();
            if (!commandValidator.validateCommand(command)) {
                System.out.println("ERROR");
            } else {
                AccountService accountService = new AccountService(bean);
                System.out.println(accountService.resolveCommand(command));
            }
            if (command.equals("EXIT")) {
                break;
            }
        }
    }

    private static void logOff() {
        java.util.logging.Logger.getLogger("org.springframework").setLevel(Level.OFF);
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING);
    }
}
