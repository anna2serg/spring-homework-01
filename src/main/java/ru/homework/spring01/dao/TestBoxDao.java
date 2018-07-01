package ru.homework.spring01.dao;

import java.io.File;
import java.util.ArrayList;

import ru.homework.spring01.common.Answer;
import ru.homework.spring01.common.TestUnit;
import ru.homework.spring01.reader.CSVReader;

public class TestBoxDao implements ITestBoxDao {
	
	private ArrayList<TestUnit> TestList;
	private int index = 0; 
	
	private void _TestListLoad(String file) {
		
		File f = new File(file);
		if (!f.exists()) {
			System.out.println("Упс! Файл с тестом не найден. Надо бы проверить путь к файлу в настройках программы");
			return;
		}
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
    	_TestListLoad(file);
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
	
	@Override
	public TestUnit Get() {
		return TestList.get(index);
	}	

}
