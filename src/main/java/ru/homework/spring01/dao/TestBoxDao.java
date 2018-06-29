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
			ArrayList<Answer> ans = new ArrayList<Answer>(); 
			int i = 0;
			for (String col : rows) {
				String s = col.trim();
				if (i==0) tu.setQuestion(s);
				else {
					if (i%2==0) {
						varRight = s.equals("1");
						ans.add(new Answer(var, varRight));
					}
					else {
						var = s;
					}
				}
				i++;
			}		
			tu.setAnswerList(ans);
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
    
    public String ToString() {
    	String result = "";
    	for (TestUnit tu : TestList) {
    		result += tu.getQuestion().toString() + " " + tu.getAnswerList().toString();
    		result += newline;
    	}
    	return result;
    	
    }
    
    private boolean CheckIndex(int index) {
    	return ((index>0)&&(index<TestList.size()));
    }

	@Override
	public boolean EOF() {
		return index == TestList.size() - 1;
	}

	@Override
	public int Count() {
		return TestList.size();
	}

	@Override
	public TestUnit Next() {
		index += 1;
		return TestList.get(index);
	}

	@Override
	public String GetQuestion() {
		return TestList.get(index).getQuestion();
	}

	@Override
	public ArrayList<Answer> GetAnswers() {
		return TestList.get(index).getAnswerList();
	}
    
}
