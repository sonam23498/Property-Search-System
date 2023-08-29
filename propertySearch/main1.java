package propertySearch;
import java.sql.*;
import java.util.Scanner;

public class main1
{		
	//SEARCH BY COST RANGE
	public static void searchProperty() throws Exception
	{	int ch= 0;
		Scanner sc= new Scanner(System.in);
		 System.out.println("\t\t\t\t1. Search by City");
         System.out.println("\t\t\t\t2. Search by Cost Range");
         System.out.println("\t\t\t\t3. Search by City and No. of Bedrooms");
         ch= sc.nextInt();
         if(ch==1)
         {
        	 System.out.println("Enter the city name");
        	 String city1= sc.next();
        	 Class.forName("com.mysql.cj.jdbc.Driver");
 			Connection con=DriverManager.getConnection
 					("jdbc:mysql://localhost:3306/sonam", "root","root");
			String sql="select * from propertySearch1 where city=?";
 			PreparedStatement ps = con.prepareStatement(sql);
 			ps.setString(1, city1);
 			ResultSet rs = ps.executeQuery();
 			while (rs.next()) 
 			{
 				System.out.println("\t\t\t\t");
				System.out.println("ID:-"+rs.getString("propertyId")+"\n"+
						"No of Rooms:-"+rs.getString("noOfRooms")+"\n"+"Area in Sqft:-"+rs.getString("areaInSqft")+"\n"
						+"City:-"+rs.getString("city")+"\n" +"State:-"+rs.getString("state")+"\n"+"Cost:-"+rs.getString("cost")+"\n"
						+"Floor No:-"+rs.getString("floorNo")+"\n"+"Owner Name:-"+rs.getString("ownerName")+"\n"+"Owner Contact No:-"+rs.getString("ownerContactNo")+"\n\n\n ");
					  
 			}
 			ps.close();
 			con.close();
         }
         else if(ch== 2)
         {
        	 System.out.println("Enter the minimum cost");
        	 double cost1= sc.nextDouble();
        	 System.out.println("Enter the maximum cost");
        	 double cost2= sc.nextDouble();
        	 Class.forName("com.mysql.cj.jdbc.Driver");
 			Connection con=DriverManager.getConnection
 					("jdbc:mysql://localhost:3306/sonam", "root","root");
			String sql="select * from propertySearch1 where cost>? AND cost<=?";
 			PreparedStatement ps = con.prepareStatement(sql);
 			ps.setDouble(1, cost1);
 			ps.setDouble(2, cost2);
 			ResultSet rs = ps.executeQuery();
 			while (rs.next()) 
 			{
 				System.out.println("\t\t\t\t");
				System.out.println("ID:-"+rs.getString("propertyId")+"\n"+
						"No of Rooms:-"+rs.getString("noOfRooms")+"\n"+"Area in Sqft:-"+rs.getString("areaInSqft")+"\n"
						+"City:-"+rs.getString("city")+"\n" +"State:-"+rs.getString("state")+"\n"+"Cost:-"+rs.getString("cost")+"\n"
						+"Floor No:-"+rs.getString("floorNo")+"\n"+"Owner Name:-"+rs.getString("ownerName")+"\n"+"Owner Contact No:-"+rs.getString("ownerContactNo")+"\n\n\n ");
			
// 			  
 			}
 			ps.close();
 			con.close();
         }
         
         else if(ch== 3)
         {
        	 System.out.println("Enter the city name");
        	 String city1= sc.next();
        	 System.out.println("Enter no. of rooms");
        	 String rooms= sc.next();
        	 Class.forName("com.mysql.cj.jdbc.Driver");
 			Connection con=DriverManager.getConnection
 					("jdbc:mysql://localhost:3306/sonam", "root","root");
			String sql="select * from propertySearch1 where city=? and noOfRooms=?";
 			PreparedStatement ps = con.prepareStatement(sql);
 			ps.setString(1, city1);
 			ps.setString(2, rooms);
 			ResultSet rs = ps.executeQuery();
 			while (rs.next()) 
 			{
 				System.out.println("\t\t\t\t");
				System.out.println("ID:-"+rs.getString("propertyId")+"\n"+
						"No of Rooms:-"+rs.getString("noOfRooms")+"\n"+"Area in Sqft:-"+rs.getString("areaInSqft")+"\n"
						+"City:-"+rs.getString("city")+"\n" +"State:-"+rs.getString("state")+"\n"+"Cost:-"+rs.getString("cost")+"\n"
						+"Floor No:-"+rs.getString("floorNo")+"\n"+"Owner Name:-"+rs.getString("ownerName")+"\n"+"Owner Contact No:-"+rs.getString("ownerContactNo")+"\n\n\n ");
			
// 			  
 			}
 			ps.close();
 			con.close();
         }
         
		
	}
	
	
	
	//VIEW PROPERTY
	 public static void viewProperty() throws Exception
	    {
	    	

	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/sonam", "root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from propertySearch1");
			while(rs.next())
			{
				System.out.println("\t\t\t\t");
				System.out.println("ID:-"+rs.getString("propertyId")+"\n"+
						"No of Rooms:-"+rs.getString("noOfRooms")+"\n"+"Area in Sqft:-"+rs.getString("areaInSqft")+"\n"
						+"City:-"+rs.getString("city")+"\n" +"State:-"+rs.getString("state")+"\n"+"Cost:-"+rs.getString("cost")+"\n"
						+"Floor No:-"+rs.getString("floorNo")+"\n"+"Owner Name:-"+rs.getString("ownerName")+"\n"+"Owner Contact No:-"+rs.getString("ownerContactNo")+"\n\n\n ");
			}
			st.close();
			con.close();
	    }
	
	
	//DELETE PROPERTY
	 public static void deleteProperty() throws Exception
	    {
	    	Scanner t=new Scanner(System.in);
	    	System.out.print("\t\t\t\t  Enter Property id:-");
	        System.out.print("\t\t\t\t");
			String propertyId=t.nextLine();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/sonam", "root","root");
			String insertQuery="delete from propertySearch1 where propertyId =?";
			PreparedStatement st=con.prepareStatement(insertQuery);
	         st.setString(1, propertyId);
			int res=st.executeUpdate();
			if(res == 0) {
				System.out.println("\t\t\t\tRecord not deleted");
			}else {
				System.out.println("\t\t\t\tRecord deleted");
			}
			st.close();
			con.close();
	    }
	
	
	//ADD PROPERTY
	 public static void addProperty() throws Exception
	    {
	    	Scanner sc=new Scanner(System.in);
	    	System.out.print("\t\t\t\t  Enter Property id:-");
	        System.out.print("\t");
			String propertyId=sc.nextLine();
			
			System.out.print("\t\t\t\t Enter No of rooms-");
			System.out.println("\t");
			String noOfRooms= sc.nextLine();
			
			System.out.print("\t\t\t\t Enter area in square feet");
			System.out.println("\t");
			String areaInSqft=sc.nextLine();
			
			System.out.print("\t\t\t\t Enter City:-");
			System.out.println("\t");
			String city=sc.nextLine();
			
			System.out.print("\t\t\t\t Enter State:-");
			System.out.println("\t");
			String state=sc.nextLine();
			
			System.out.print("\t\t\t\t Enter cost:-");
			System.out.println("\t");
			String cost=sc.nextLine();
			
			System.out.print("\t\t\t\t Enter Floor no:-");
			System.out.println("\t");
			String floorNo=sc.nextLine();
			
			System.out.print("\t\t\t\t Enter owner name:-");
			System.out.println("\t");
			String ownerName=sc.nextLine();
			
			System.out.print("\t\t\t\t Enter owner contact no:-");
			System.out.println("\t");
			String ownerContactNo=sc.nextLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/sonam", "root","root");
			Statement st=con.createStatement();
			String insertQuery="insert into propertySearch1 "
					+ "values('"+propertyId+"','"+noOfRooms+"','"+areaInSqft+"','"+city+"','"+state+"','"+cost+"','"+floorNo+"','"+ownerName+"','"+ownerContactNo+"')";
			int res=st.executeUpdate(insertQuery);
			
			if(res == 0) {
				System.out.println("\t\t\t\tRecored not inserted");
			}else {
				System.out.println("\t\t\t\tRecored inserted succesfully");				 
			}
			st.close();
			con.close();
	    }							//ADD PROPERTY CLOSING
	 
	 
	 
	 
	//UPDATE PROPERTY
	 public static void updateProperty() throws Exception
	    {
	    	Scanner dt=new Scanner(System.in);
	    	System.out.println("\t\t\t\t1. No. of Rooms");
	        System.out.println("\t\t\t\t2. Area in Sqft");
	        System.out.println("\t\t\t\t3. Floor no");
	        System.out.println("\t\t\t\t4. City");
	        System.out.println("\t\t\t\t5. State");
	        System.out.println("\t\t\t\t6. Cost");
	        System.out.println("\t\t\t\t7. Owner Name");
	        System.out.println("\t\t\t\t8. Owner Contact No");
	        System.out.println("\t\t\t\t0. Exit");	
	        String gt=dt.nextLine();
	        if(gt.equals("1"))
	        {
	        	System.out.print("\t\t\t\t  Enter Property id:-");
	            System.out.print("\t\t\t\t");
	    		String propertyId=dt.nextLine();
	    		System.out.println("\t\t\t\t Enter No of Rooms-");
	    		System.out.println("\t\t\t\t");
	    		String noOfRooms= dt.nextLine();
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con=DriverManager.getConnection
	    				("jdbc:mysql://localhost:3306/sonam", "root","root");
	    		String insertQuery="update propertySearch1 set noOfRooms=? where propertyId =?";
	    		PreparedStatement st=con.prepareStatement(insertQuery);
	             st.setString(1,noOfRooms);
	             st.setString(2, propertyId);
	    		int res=st.executeUpdate();
	    		if(res==1)
	    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
	    		else
	    			System.out.print("\t\t\t\t Row not Updated!");

	    		st.close();
	    		con.close();
	        }
	        else if(gt.equals("2"))
	        {
	        	System.out.print("\t\t\t\t  Enter Property id:-");
	            System.out.print("\t\t\t\t");
	    		String propertyId=dt.nextLine();
	    		System.out.println("\t\t\t\t Enter Area in Sqft-");
	    		System.out.println("\t\t\t\t");
	    		String areaInSqft= dt.nextLine();
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con=DriverManager.getConnection
	    				("jdbc:mysql://localhost:3306/sonam", "root","root");
	    		String insertQuery="update propertySearch1 set areaInSqft=? where propertyId =?";
	    		PreparedStatement st=con.prepareStatement(insertQuery);
	             st.setString(1,areaInSqft);
	             st.setString(2, propertyId);
	    		int res=st.executeUpdate();
	    		if(res==1)
	    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
	    		else
	    			System.out.print("\t\t\t\t Row not Updated!");

	    		st.close();
	    		con.close();
	        }
	        else if(gt.equals("3"))
	        {
	        	System.out.print("\t\t\t\t  Enter Property id:-");
	            System.out.print("\t\t\t\t");
	    		String propertyId=dt.nextLine();
	    		System.out.println("\t\t\t\t Enter Floor No-");
	    		System.out.println("\t\t\t\t");
	    		String floorNo= dt.nextLine();
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con=DriverManager.getConnection
	    				("jdbc:mysql://localhost:3306/sonam", "root","root");
	    		String insertQuery="update propertySearch1 set floorNo=? where propertyId =?";
	    		PreparedStatement st=con.prepareStatement(insertQuery);
	             st.setString(1,floorNo);
	             st.setString(2, propertyId);
	    		int res=st.executeUpdate();
	    		if(res==1)
	    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
	    		else
	    			System.out.print("\t\t\t\t Row not Updated!");

	    		st.close();
	    		con.close();
	        }
	        
	        else if(gt.equals("4"))
	        {
	        	System.out.print("\t\t\t\t  Enter Property id:-");
	            System.out.print("\t\t\t\t");
	    		String propertyId=dt.nextLine();
	    		System.out.println("\t\t\t\t Enter City-");
	    		System.out.println("\t\t\t\t");
	    		String city= dt.nextLine();
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con=DriverManager.getConnection
	    				("jdbc:mysql://localhost:3306/sonam", "root","root");
	    		String insertQuery="update propertySearch1 set city=? where propertyId =?";
	    		PreparedStatement st=con.prepareStatement(insertQuery);
	             st.setString(1,city);
	             st.setString(2, propertyId);
	    		int res=st.executeUpdate();
	    		if(res==1)
	    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
	    		else
	    			System.out.print("\t\t\t\t Row not Updated!");

	    		st.close();
	    		con.close();
	        }
	        else if(gt.equals("5"))
	        {
	        	System.out.print("\t\t\t\t  Enter Property id:-");
	            System.out.print("\t\t\t\t");
	    		String propertyId=dt.nextLine();
	    		System.out.println("\t\t\t\t Enter State-");
	    		System.out.println("\t\t\t\t");
	    		String state= dt.nextLine();
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con=DriverManager.getConnection
	    				("jdbc:mysql://localhost:3306/sonam", "root","root");
	    		String insertQuery="update propertySearch1 set state=? where propertyId =?";
	    		PreparedStatement st=con.prepareStatement(insertQuery);
	             st.setString(1,state);
	             st.setString(2, propertyId);
	    		int res=st.executeUpdate();
	    		if(res==1)
	    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
	    		else
	    			System.out.print("\t\t\t\t Row not Updated!");

	    		st.close();
	    		con.close();
	        }
	        else if(gt.equals("6"))
	        {
	        	System.out.print("\t\t\t\t  Enter Property id:-");
	            System.out.print("\t\t\t\t");
	    		String propertyId=dt.nextLine();
	    		System.out.println("\t\t\t\t Enter Cost-");
	    		System.out.println("\t\t\t\t");
	    		String cost= dt.nextLine();
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con=DriverManager.getConnection
	    				("jdbc:mysql://localhost:3306/sonam", "root","root");
	    		String insertQuery="update propertySearch1 set cost=? where propertyId =?";
	    		PreparedStatement st=con.prepareStatement(insertQuery);
	             st.setString(1,cost);
	             st.setString(2, propertyId);
	    		int res=st.executeUpdate();
	    		if(res==1)
	    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
	    		else
	    			System.out.print("\t\t\t\t Row not Updated!");

	    		st.close();
	    		con.close();
	        }
	        else if(gt.equals("7"))
	        {
	        	System.out.print("\t\t\t\t  Enter Property id:-");
	            System.out.print("\t\t\t\t");
	    		String propertyId=dt.nextLine();
	    		System.out.println("\t\t\t\t Enter Owner Name-");
	    		System.out.println("\t\t\t\t");
	    		String ownerName= dt.nextLine();
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con=DriverManager.getConnection
	    				("jdbc:mysql://localhost:3306/sonam", "root","root");
	    		String insertQuery="update propertySearch1 set ownerName=? where propertyId =?";
	    		PreparedStatement st=con.prepareStatement(insertQuery);
	             st.setString(1,ownerName);
	             st.setString(2, propertyId);
	    		int res=st.executeUpdate();
	    		if(res==1)
	    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
	    		else
	    			System.out.print("\t\t\t\t Row not Updated!");

	    		st.close();
	    		con.close();
	        }
	        else if(gt.equals("8"))
	        {
	        	System.out.print("\t\t\t\t  Enter Property id:-");
	            System.out.print("\t\t\t\t");
	    		String propertyId=dt.nextLine();
	    		System.out.println("\t\t\t\t Enter Owner Contact No-");
	    		System.out.println("\t\t\t\t");
	    		String ownerContactNo= dt.nextLine();
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con=DriverManager.getConnection
	    				("jdbc:mysql://localhost:3306/sonam", "root","root");
	    		String insertQuery="update propertySearch1 set ownerContactNo=? where propertyId =?";
	    		PreparedStatement st=con.prepareStatement(insertQuery);
	             st.setString(1,ownerContactNo);
	             st.setString(2, propertyId);
	    		int res=st.executeUpdate();
	    		if(res==1)
	    			System.out.print("\t\t\t\t Row Updated SeccessFully!");
	    		else
	    			System.out.print("\t\t\t\t Row not Updated!");

	    		st.close();
	    		con.close();
	        }
	        else if(gt.equals("0"))
	        {
	        	System.out.println("Thankyou!!!!"); 
	        }
	        else
	        {
	        	System.out.println("Wrong Entry Re-run The Application");
	        }
	        
	    }							//UPDATE PROPERTY CLOSING
	public static void main(String[] args) throws Exception {
		Scanner st=new Scanner(System.in);
		int ch;
		int flag=1;
		while(flag==1)
		{
			//1clearscreen();
			System.out.print("\n\n\n\n\n");
            System.out.println("\t\t\t\tWELCOME PROPERTY SEARCH SYSTEM");
            System.out.println("\t\t\t\t------------------------------------------");
            System.out.println("\t\t\t\t1. ADD PROPERTY");
            System.out.println("\t\t\t\t2. UPDATE PROPERTY");
            System.out.println("\t\t\t\t3. DELETE PROPERTY");
            System.out.println("\t\t\t\t4. VIEW PROPERTY ON SALE");
            System.out.println("\t\t\t\t5. SEARCH PROPERTY");
            System.out.println("\t\t\t\t0. Exit");
            System.out.println("\t\t\t\t------------------------------------------");
            System.out.println("\t\t\t\tEnter your Choice...:");
            System.out.print("\t\t\t\t");
            ch=st.nextInt();
            if(ch==0)
             {
            	flag=0;
            	//clearscreen();
                System.out.print("\n\n\n\n\n\n");
                System.out.println("\t\t\t\t\t--------------------------------------------");
                System.out.println("\t\t\t\t\t\tTHANK YOU FOR USING ........!!!!");
            }
            else if(ch==1)
            {
                    //clearscreen();
                    System.out.print("\n\n\n\n");
                    System.out.println("\t\t\t\t------------------------------------------");
                    System.out.println("\t\t\t\tADD PROPERTY");
                    System.out.println("\t\t\t\t------------------------------------------");
                    addProperty();
                  
                
            }
                else if(ch==2)
                {
                	
                       // clearscreen();
                        System.out.print("\n\n\n\n");
                        System.out.println("\t\t\t\t------------------------------------------");
                        System.out.println("\t\t\t\tUPDATE PROPERTY");
                        System.out.println("\t\t\t\t------------------------------------------");
                        updateProperty();
                }
//                    
            else if(ch==3)
            {
            	
                	// clearscreen();
                     System.out.print("\n\n\n\n");
                     System.out.println("\t\t\t\t------------------------------------------");
                     System.out.println("\t\t\tDELETE PROPERTY");
                     System.out.println("\t\t\t\t------------------------------------------");
                     deleteProperty();
            }
            else if(ch==4)
            {
                	 //clearscreen();
                     System.out.print("\n\n\n\n");
                     System.out.println("\t\t------------------------------------------");
                     System.out.println("\t\t\t VIEW PROPERTY");
                     System.out.println("\t\t------------------------------------------");
                     viewProperty();
                
            }
            else if(ch==5)
            {
            	
            	
                	// clearscreen();
                     System.out.print("\n\n\n\n");
                     System.out.println("\t\t\t\t------------------------------------------");
                     System.out.println("\t\t\t SEARCH PROPERTY");
                     System.out.println("\t\t\t\t------------------------------------------");
                     searchProperty();
            }
            else
            {
            	// clearscreen();
                 System.out.println("\n\n\n\n\t\t\t\t------------------------");
                 System.out.println("\t\t\t\tEnter a VALID CHOICE....");
                 System.out.println("\t\t\t\t------------------------");
                 flag=0;
            }
	}
		

	}
		}
	
