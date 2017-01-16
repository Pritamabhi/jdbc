package object_models;

import java.util.ArrayList;
import java.util.List;

public class List_Of_Product_Categories {
	private product_category product_category;
	public List<product_category> list2 = new ArrayList<product_category>();
	
	
	public void List_Of_Product_Categories(product_category product_category){
		this.product_category = product_category;
		list2.add(this.product_category);
	}
}
