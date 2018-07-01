package ru.homework.spring01.dao;

import java.util.ArrayList;

import ru.homework.spring01.common.Answer;
import ru.homework.spring01.common.TestUnit;
import ru.homework.spring01.reader.CSVReader;

public class TestBoxDao implements ITestBoxDao {
	
	private ArrayList<TestUnit> TestList;
	private static String newline = System.getProperty("line.separator");
	private int index = 0; 
	
	private void _TestListLoad(String file) {
		
		ArrayList<ArrayList<String>> raw = CSVReader.ParseString(file);
		for (ArrayList<String> rows : raw) {
			TestUnit tu = new TestUnit();
			String var = "";
			Boolean varRight = false; 
			int i = 0;
			int c = 0;
			for (String col : rows) {
				String s = col.trim();
				if (i==0) tu.setQuestion(s);
				else {
					if (i%2==0) {
						varRight = s.equals("1");
						tu.addAnswer(new Answer(c+1, var, varRight));
						c += 1;
					}
					else {
						var = s;
					}
				}
				i++;
			}		
			TestList.add(tu);
		}

	}
	
    public TestBoxDao(String file) {
        //парсим
    	index = 0;
    	TestList = new ArrayList<TestUnit>();
    	System.out.println(file);//"Q:\\otus\\1\\spring-homework-01\\spring-homework-01\\src\\main\\resources\\q.csv"
    	_TestListLoad(file);
    }
    
    private boolean CheckIndex(int index) {
    	return ((index>0)&&(index<TestList.size()));
    }

	@Override
	public boolean EOF() {
		return ((TestList.size() <= 0)||(index == TestList.size()));
	}

	@Override
	public int Count() {
		return TestList.size();
	}

	@Override
	public TestUnit Next() {
		TestUnit result = TestList.get(index);
		index += 1;
		return result;
	}

	/*@Override
	public String GetQuestion() {
		return TestList.get(index).getQuestion();
	}

	@Override
	public ArrayList<Answer> GetAnswers() {
		return TestList.get(index).getAnswerList();
	}
   
	@Override
	public boolean Multiple() {
		return TestList.get(index).Multiple();
	}*/	
	
	public TestUnit Get() {
		return TestList.get(index);
	}	

}
