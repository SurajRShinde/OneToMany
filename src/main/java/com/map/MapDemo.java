package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
public static void main(String[] args) {
	System.out.println("step 1");
	Configuration cfg = new Configuration();
	cfg=cfg.configure("hibernate.cfg.xml");
	System.out.println("step 2");
	SessionFactory factory =cfg.buildSessionFactory();
	
	Session s = factory.openSession();
	
	Question q1=new Question();
	q1.setQuestionId(1212);
	q1.setQuestion("what is java");
	
	Answer answer=new Answer();
	answer.setAnswerId(343);
	answer.setAnswer("java is programming language");
	answer.setQuesion(q1);
	
	Answer answer1=new Answer();
	answer1.setAnswerId(33);
	answer1.setAnswer("With the help of java we can create the softwares");
	answer1.setQuesion(q1);
	
	Answer answer2=new Answer();
	answer2.setAnswerId(33);
	answer2.setAnswer("Java has diffrenet types of frameworks");
	answer2.setQuesion(q1);
	
	List<Answer> list=new ArrayList<Answer>();
	list.add(answer);
	list.add(answer1);
	list.add(answer2);
	q1.setAnswers(list);
	
	

	Transaction tx = s.beginTransaction();
	s.save(q1);
	s.save(answer);
	s.save(answer1);
	s.save(answer2);
	
	tx.commit();
	s.close();
	factory.close();

	
}
}
