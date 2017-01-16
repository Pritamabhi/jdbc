package object_models;

import java.util.List;
import java.util.ArrayList;

public class List_Of_Products {
	private products product;
	public List<products> list1 = new ArrayList<products>();
	
	
	public void List_Of_Products(products product){
		this.product = product;
		list1.add(this.product);
	}

}
