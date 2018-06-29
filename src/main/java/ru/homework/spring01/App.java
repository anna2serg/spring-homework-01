package ru.homework.spring01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.homework.spring01.service.TestService;


public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
    	TestService t = context.getBean(TestService.class);
    	t.startTest();
    }
}
