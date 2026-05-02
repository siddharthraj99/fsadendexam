package com.klef.fsad.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Scanner;

@Component
public class ClientDemo implements CommandLineRunner {

    @Autowired
    private ProjectService service;

    @Override
    public void run(String... args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1.Insert");
        System.out.println("2.View");

        int ch = sc.nextInt();

        if(ch == 1) {
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Desc: ");
            String desc = sc.nextLine();

            System.out.print("Status: ");
            String status = sc.nextLine();

            Project p = new Project();
            p.setName(name);
            p.setDescription(desc);
            
            p.setStatus(status);

            Project saved = service.save(p);
            System.out.println("Inserted ID: " + saved.getId());
        }
        else {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            Project p = service.getById(id);

            if(p != null)
                System.out.println(p.getName()+" "+p.getStatus());
            else
                System.out.println("Not Found");
        }
    }
}