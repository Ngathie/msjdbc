package com.groupeisi.ms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.groupeisi.ms.dao.*;

import com.groupeisi.ms.entities.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//User u = new User();
		
		//u.setFirstName("Sidy");
		//u.setLastName("Konteye");
		//u.setEmail("sk@gmail.com");
		//u.setPassword("mameJava");
		//IUser iUser = new IUserImpl();
		//iUser.save(u);
		
		//u.setFirstName("Abdou");
		//u.setLastName("Diouf");
		//u.setEmail("dioufaNdiokhobaye@gmail.com");
		//u.setPassword("DioufKounda");
		//IUser iUser1 = new IUserImpl();
		//iUser1.save(u);
		
		//Transfer tr = new Transfer();
		
		//tr.setArriveYear(2016);
		//tr.setLeavingYear(2023);
		//ITransfer itr = new ITransferImpl();
		//itr.save(tr);
		
		//tr.setArriveYear(2013);
		//tr.setLeavingYear(2043);
		//ITransfer itr = new ITransferImpl();
		//itr.save(tr);
		
		//Teacher teach = new Teacher();
		
				//teach.setFirstName("Sidy");
				//teach.setLastName("Konteye");
				//teach.setPhoneNumber("sk@gmail.com");
				//ITeacher iteach = new ITeacherImpl();
				//iteach.save(teach);
		//Teacher teach = new Teacher();
				
				//teach.setFirstName("Ngor");
				//teach.setLastName("Seck");
				//teach.setPhoneNumber("774658989");
				//ITeacher iteach = new ITeacherImpl();
				//iteach.save(teach);
		//Teacher teach = new Teacher();
				//teach.setId(3);
				//teach.setFirstName("Sidy");
				//teach.setLastName("Diop");
				//teach.setPhoneNumber("777508294");
				//teach.setId(3);
				//ITeacher iteach = new ITeacherImpl();
				//iteach.update(teach);
		
		//Teacher teach = new Teacher();
				//teach.setId(2);
				//ITeacher iteach = new ITeacherImpl();
				//iteach.delete(2);
				
				
				IUser iUser = new IUserImpl();
				File listeUsers = new File("listeUsers.csv");
				List<User> users = iUser.findAll();
				FileWriter fileWriter = new FileWriter(listeUsers);
				fileWriter.write("ID;FirstName;LastName;Email;");
				for (User u: users) {
					String fact ="\r\n"+ u.getId()+";"+u.getFirstName()+";"+u.getLastName()+";"+u.getEmail()+"\r\n";
					fileWriter.write(fact);
				}
				fileWriter.close();
				System.out.println("Fichier cree");
		
		

	}

}
