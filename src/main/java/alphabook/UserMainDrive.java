package alphabook;

import java.util.Scanner;

public class UserMainDrive {

	public static void main(String[] args) throws Exception {
		User user=new User();
		SocialMedia socialMedia=new SocialMedia();
		Scanner scan=new Scanner(System.in);
		System.out.println("************************ALPHA BOOK**************************");
		int choice=0;
		System.out.println("ENTER YOUR CHOICE:\n1.LOGIN \n2.SIGNUP \n3.EXIT\n************************************");
		choice=scan.nextInt();
		switch(choice) {
		case 1:{
			socialMedia.login(user);
			break;	

		}
		case 2:{
			System.out.println("ENTER FIRST NAME");
			user.setFirst_Name(scan.next());
			System.out.println("ENTER LAST NAME");
			user.setLast_Name(scan.next());
			boolean temp=true;
			while(temp) 
			{
				System.out.println("SELECT YOUR GENDER \nSELECT 1/2/3\n1:MALE \n2:FEMALE \n3:OTHERS");
				int gender=scan.nextInt();
				switch(gender) 
				{
				case 1:{
					user.setGender("MALE");
					temp=false;
					break;
				}
				case 2:{
					user.setGender("FEMALE");
					temp=false;
					break;
				}
				case 3:{
					user.setGender("OTHERS");
					temp=false;
					break;
				}
				default :{
					System.out.println("select correct option");
					System.out.println("SELECT YOUR GENDER \n1:MALE \n2:FEMALE \n3:OTHERS");
					gender=scan.nextInt();
				}

				}
			}
			System.out.println("ENTER CONTACT NUMBER");
			user.setContact_Number(scan.nextInt());
			System.out.println("ENTER YOUR DATE OF BIRTH");
			user.setDate_Of_Birth(scan.next());
			System.out.println("ENTER YOUR EMAILID");
			user.setEmail_Id(scan.next());
			System.out.println("ENTER PASSWORD");
			user.setPassword(scan.next());
			System.out.println("ENTER 1 :SUBMIT \n2:CANCEL");
			int select=scan.nextInt();
			if(select==1) {
				socialMedia.signUp(user);
				
			}
			else {
				System.out.println("ENTER YOUR CHOICE:\n1.LOGIN \n2.SIGNUP \n3.EXIT\n************************************");
				choice=scan.nextInt();
			}
			break;
		}
		case 3:{
			System.out.println("THANK YOU HAVE A NICE DAY");
			System.exit(0);
			break;		
		}
		}
		scan.close();
	}

}
