package com.mis;

import com.exception.InvalidTestNameException;
import com.model.Diagnosis;
import com.model.Do;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Diagnosis dd = ctx.getBean(Diagnosis.class);
        Do d = new Do();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of tests");
        int n = sc.nextInt();
        double price = 0.0;
        while(n>0){
            String test_name = sc.nextLine();
            try{
                d.validatetest(test_name);
                price += d.getprice(test_name);

            }catch (InvalidTestNameException e){
                System.out.println(e.getMessage());
                break;
            }
            n--;
        }

        System.out.println("Total price for your valid tests is: " + price);
    }
}
