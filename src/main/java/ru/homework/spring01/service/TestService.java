package ru.homework.spring01.service;

//import ru.homework.spring01.dao.ITestBoxDao;
import ru.homework.spring01.dao.TestBoxDao;

public class TestService {
	
	private TestBoxDao dao;
	
    public TestService(TestBoxDao dao) {
    	this.dao = dao;
    }	
     
    public void startTest() {
   	 System.out.println( "в Нью-Йорке свет погас давно и молоко прокисло,\r\n" + 
      		"а мне плевать, ведь все равно\r\n" + 
      		"жизнь не имеет смысла.\r\n" + 
      		"Фиби Буфе (c)\r\n" + 
      		"" );    	
   	 System.out.println();
     while (!dao.EOF()) {
    	 System.out.println(dao.GetQuestion());
    	 System.out.println(dao.GetAnswers());
    	 System.out.println();
    	 dao.Next();
     }
   }    

    
}
