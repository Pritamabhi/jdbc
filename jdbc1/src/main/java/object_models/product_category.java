package object_models;

import java.sql.ResultSet;

public class product_category {
private String product_category;
private int product_code;
public String getProduct_category() {
	return product_category;
}
public void setProduct_category(String product_category) {
	this.product_category = product_category;
}
public int getProduct_code() {
	return product_code;
}
public void setProduct_code(int product_code) {
	this.product_code = product_code;
}
}
//String str3 = "select product_description from Products.product_details where product_name = "+product_name_query;
//ResultSet resultSet = statement.executeQuery(str3);
//System.out.println("Description of"+product_name_query +"="+resultSet.getString(1));