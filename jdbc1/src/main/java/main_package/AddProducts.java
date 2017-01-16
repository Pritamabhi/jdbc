package main_package;

import object_models.List_Of_Product_Categories;
import object_models.List_Of_Products;
import object_models.product_category;
import object_models.products;
import java.sql.*;
import java.util.Scanner;  

//import java.sql.*;
import java.util.ListIterator;

public class AddProducts {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int product_id=0;
		int product_category_id=0;
		int product_code=0;
		String product_name="";
		int product_price=0;
		int product_quantity=0;
		String product_description="";
		double product_rating=0.0;
		String product_category = "";
		int product = 0;
		int categoryID = 0;
		int productID =0;
		String product_name_query="";
		System.out.println("if you want to modify products table enter 1");
		System.out.println("2 to modify products_category table");
		System.out.println(" 3 for product_details ");
		System.out.println("4 for Display Average number of products among all categories");
		System.out.println(" 5 for the product which has largest description");
		System.out.println(" 6 for deleting a category");
		System.out.println("7 for deleting a product");
		System.out.println("8  to retrieve last 5 products");
		int table = sc.nextInt();
		if(table == 1)
		{
			System.out.println("Enter product id");
			product_id = sc.nextInt();
			System.out.println("Enter product_category_id");
			product_category_id = sc.nextInt();
			System.out.println("Enter product_code");
			product_code = sc.nextInt();
			System.out.println("Enter product_name");
			product_name = sc.next();
			System.out.println("Enter product_price");
			product_price = sc.nextInt();
			System.out.println("Enter product_quantity");
			product_quantity = sc.nextInt();
			System.out.println("Enter product_description");
			product_description = sc.next();
			System.out.println("Enter product_rating");
			product_rating = sc.nextDouble();
		}
		else if(table == 2){
			System.out.println("Enter product_category");
			product_category = sc.next();
			System.out.println("Enter product");
			product = sc.nextInt();
		    }
		else if(table == 3)
		{
			System.out.println("enter product's name");
			product_name_query = sc.next();
		}
		else if(table == 6)
		{
			System.out.println("enter the category_id of the category to be deleted");
			categoryID = sc.nextInt();
		}
		else if(table == 7)
		{
			System.out.println("enter the product_id of the product to be deleted");
			productID = sc.nextInt();
		}
		ListIterator<products> litr = null;
		ListIterator<product_category> litr2 = null;
		String str1 ="INSERT INTO Products.product_details"
		+ "(product_id, product_category_id, product_code,product_name,product_price,product_quantity,product_description,product_rating) VALUES"
		+ "(?,?,?,?,?,?,?,?)";
		String str2 ="INSERT INTO Products.product_category"
				+ "(product_category, product_code) VALUES"
				+ "(?,?)";
		String str3 = "select product_description from Products.product_details where product_name = "+'"'+product_name_query+'"';
		String str4 = "SELECT AVG(product_id)"+ 
		"FROM Products.product_details "+
		"GROUP BY product_category_id;";
		String str5 = "SELECT product_name from Products.product_details where product_description = (select max(product_description) from Products.product_details);";
		String str6 = "delete from Products.product_category where product_code = "+'"'+categoryID+'"';
		String str7 = "delete from Products.product_details where product_id = "+'"'+productID+'"';
		String str8 = "SELECT * FROM Products.product_details ORDER BY product_id DESC LIMIT 5;";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Products","root","password");
        PreparedStatement preparedStatement = con.prepareStatement(str1);
        PreparedStatement preparedStatement2 = con.prepareStatement(str2);
        Statement statement = con.createStatement();
        //ResultSet resultSet = statement.executeQuery(str3);
       // ResultSet resultSet2 = statement.executeQuery(str4);
        
        
        
       
		products product1 = new products();
		product1.setProduct_id(product_id);
		product1.setProduct_category_id(product_category_id);
		product1.setProduct_code(product_code);
		product1.setProduct_description(product_description);
		product1.setProduct_name(product_name);
		product1.setProduct_price(product_price);
		product1.setProduct_quantity(product_quantity);
		product1.setProduct_rating(product_rating);
		List_Of_Products list = new List_Of_Products();
		list.List_Of_Products(product1);
		product_category category1 = new product_category();
		category1.setProduct_category(product_category);
		category1.setProduct_code(product);
		List_Of_Product_Categories list_categories = new List_Of_Product_Categories();
		list_categories.List_Of_Product_Categories(category1);
		litr=list.list1.listIterator();
		litr2 = list_categories.list2.listIterator();
        products product_item = new products();
        product_category Product_category = new product_category();
        if(table == 1){
        while(litr.hasNext()){
       
        	product_item= litr.next();
        	preparedStatement.setInt(1,product_item.getProduct_id());
            preparedStatement.setInt(2,product_item.getProduct_category_id());
            preparedStatement.setInt(3,product_item.getProduct_code());
            preparedStatement.setString(4,product_item.getProduct_name());
            preparedStatement.setInt(5,product_item.getProduct_price());
            preparedStatement.setInt(6,product_item.getProduct_quantity());
            preparedStatement.setString(7,product_item.getProduct_description());
            preparedStatement.setDouble(8,product_item.getProduct_rating());
            preparedStatement.executeUpdate();
            System.out.println("the products table has been updated");
            
        }
        }
        if(table == 2){
        while(litr2.hasNext()){
            
        	Product_category= litr2.next();
        	preparedStatement2.setString(1,Product_category.getProduct_category());
            preparedStatement2.setInt(2,Product_category.getProduct_code());
            preparedStatement2.executeUpdate();
            System.out.println("the product_category table has been updated");
            
        }
        }
        if(table == 3)
        {
        	ResultSet resultSet = statement.executeQuery(str3);
        	while(resultSet.next()){
        		String name1 = resultSet.getString(1);
        		System.out.println(name1);
        	}
        }
        
       
		if(table == 4)
		{
			ResultSet resultSet2 = statement.executeQuery(str4);
			while(resultSet2.next()){
				int name2 = resultSet2.getInt(1);
				System.out.println(name2);
				
			}
		}
       
        if(table == 5)
        {
        	ResultSet resultSet3 = statement.executeQuery(str5);
        	while(resultSet3.next()){
        		String name3 = resultSet3.getString(1);
        		System.out.println(name3);
        	}
        }
        if(table == 6)
        {
        	boolean count1 = statement.execute(str6);
        	if(count1){
        	System.out.println("the category with category_id = "+categoryID+"is deleted");
        	}
        	else
        	{
        		System.out.println("no such record found");
        	}
        	}
        if(table == 7)
        {
        	boolean count2 = statement.execute(str7);
        	if(count2 == true){
        	System.out.println("the product with product_id = "+productID+"is deleted");
        	}
        	else
        	{
        		System.out.println("no such record found");
        	}
        }
        if(table == 8)
        {
        	ResultSet resultSet4 = statement.executeQuery(str8);
        	while(resultSet4.next()){
        		String name4 = resultSet4.getString(4);
        		System.out.println(name4);
        }
        
        sc.close();

	}

}
}
