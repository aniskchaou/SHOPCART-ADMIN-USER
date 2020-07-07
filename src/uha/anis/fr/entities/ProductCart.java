package uha.anis.fr.entities;

import java.util.Iterator;
import java.util.List;

public class ProductCart {
	
   Product product;
   String color;
   int quantity;
   
   
   
   public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public ProductCart(Product product, String color, int quantity) {
	super();
	this.product = product;
	this.color = color;
	this.quantity = quantity;
}

public ProductCart() {
	// TODO Auto-generated constructor stub
}

void addToCart(List<ProductCart> cart,ProductCart productCart)
   {
	   cart.add(productCart);
   }
   
   void removeFromCart(List<ProductCart> cart,ProductCart productCart)
   {
	   cart.remove(productCart);
   }
   public static boolean existInCart(List<ProductCart> cart,Product product)
   {
	   for (ProductCart productCart : cart) {
		if(productCart.product.getpId()==product.getpId())
		{
			return true;
		}
		
		
	}
	   return false;
   }
   
   
   public static int getIndexProduct(List<ProductCart> cart,Product product)
   {
	   int index=0;
	   for (ProductCart productCart : cart) {
			if(productCart.product.getpId()==product.getpId())
			{
				 index= cart.indexOf(productCart);
				 break;
			}
			
			
		}
	   return index;
   }
  
   public static ProductCart getProductFromList(List<ProductCart> cart,Product product)
   {
	   
	   for (ProductCart productCart : cart) {
			if(productCart.product.getpId()==product.getpId())
			{
				 return productCart;
			}
			
			
		}
	   return null;
   }
   
   
   public static void removeFromList(List<ProductCart> cart,Product product)
   {
	   
	   for (ProductCart productCart : cart) {
			if(productCart.product.getpId()==product.getpId())
			{
				  cart.remove(productCart);
				  return;
			}
			
			
		}
	   
   }
   
   public static void removeAll(List<ProductCart> cart)
   {
	   
	   cart.clear();
	   
   }
}
