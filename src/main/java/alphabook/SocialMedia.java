package alphabook;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class SocialMedia {

	Scanner scan=new Scanner(System.in);
	public void signUp(User user) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/alphabook","root","root");
		String query="INSERT INTO USER VALUES(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1,user.getContact_Number());
		preparedStatement.setString(2,user.getFirst_Name());
		preparedStatement.setString(3,user.getLast_Name());
		preparedStatement.setString(4,user.getGender());
		preparedStatement.setString(5,user.getDate_Of_Birth());
		preparedStatement.setString(6,user.getEmail_Id());
		preparedStatement.setString(7,user.getPassword());
		preparedStatement.execute();
		connection.close();
		System.out.println("signed up successfully");
	}
	public void login(User user) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/alphabook","root","root");
		String query="SELECT * FROM USER";
		PreparedStatement ps=connection.prepareStatement(query);
		ResultSet resultset=ps.executeQuery();
		ArrayList email=new ArrayList();
		ArrayList pass=new ArrayList();
		ArrayList firstname=new ArrayList();
		ArrayList lastname=new ArrayList();
		//		String firstname="";
		//		String lastname="";
		//		int temp1=0;
		while(resultset.next()) 
		{
			//			firstname=resultset.getString(2);
			//			lastname=resultset.getString(3);
			lastname.add(resultset.getString(3));	
			firstname.add(resultset.getString(2));
			email.add(resultset.getString(6));
			pass.add(resultset.getString(7));
			//			temp1++;

		}

		connection.close();

		System.out.println("enter mailid");
		String emailid=scan.next();
		int count=0;

		boolean temp=true;
		boolean a=false;
		int count1=0;
		int ref=0;
		while(temp) {
			for (int i = 0; i < email.size(); i++) {
				String temp2=(String) email.get(i);
				a=temp2.equals(emailid);

				if(a) {
					ref=i;

					count1++;
				}
			}
			if(count1==1) {
				temp=false;
				System.out.println("enter password");
				String password=scan.next();
				while(count<2) 
				{
					boolean b=false;
					b=pass.get(ref).equals(password);

					if(b)
					{

						System.out.println("*************WELCOME "+firstname.get(ref)+" "+lastname.get(ref)+"*********************");
						LocalDateTime localDateTime=LocalDateTime.now();
						System.out.println("logged in successfull @ "+localDateTime);
						System.out.println("FIRST NAME:"+firstname.get(ref));
						System.out.println("LAST NAME:"+lastname.get(ref));



						break;
					}
					else 
					{
						System.out.println("enter correct password");
						password=scan.next();
						count++;
						if(count==2) 
						{
							System.out.println("you have entered wrong password 3 times try after sometime");
							System.exit(0);
						}
					}

				}

			}
			else 
			{
				System.out.println("mailid not exist please try again");
				System.out.println("enter correct email id");
				emailid=scan.next();
			}

		}
	}
}


