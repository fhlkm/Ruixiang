package com.ruixiang.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class First {
	static String str1 ="";
	 public static void readTxtFile(String filePath){
	        try {
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){
	                    InputStreamReader read = new InputStreamReader(
	                    new FileInputStream(file));
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    String line;
	                    while((line = bufferedReader.readLine()) != null){
	                        System.out.println(line);
	                        str1 = str1+line;
	                    }
	                    read.close();
	        }else{
	            System.out.println("Cannot find the file");
	        }
	        } catch (Exception e) {
	            System.out.println("Error occurred");
	            e.printStackTrace();
	        }
	     
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		First mFirst = new First();
		String filepath = mFirst.getCurrentDirectory()+File.separator+"data.txt";
		 //String filePath = "C:\\Users\\Ruixiang\\Desktop\\PFF\\First\\data.txt";
		 readTxtFile(filepath);
		
		 //json
		 System.out.println(str1);
		 Gson gson = new Gson();
		 Student [] students = gson.fromJson(str1, Student[].class);
		 System.out.println(students[0].getAge());
		
		 
//		 JSONArray jsonArray = JSONArray.fromObject(str1);    
////		Student[] stus = (Student[]) JSONArray.toArray(jsonArray, Student.class);
//		 List<Student> stus = (List<Student>)JSONArray.toCollection(jsonArray, Student.class);
//		 for(Student stu: stus){
//			 System.out.println(stu.getName() + " is " + stu.getAge() + " years old and id is " + stu.getId() + ", The gender is " + stu.getGender());
//		 }
	}
	
	public  String getCurrentDirectory(){
		
			
			return this.getClass().getResource("").getPath() ;
		
		
	}
}
