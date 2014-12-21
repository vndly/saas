package server.app.products;

import java.sql.Connection;

import server.app.db.tables.TableProduct;
import server.core.ServerOperation;
import share.app.products.IOperations;
import share.app.products.Product;

public class Operations extends ServerOperation implements IOperations {
	
	public Operations(Connection appConnection, Connection sysConnection) {
		super(appConnection, sysConnection);
	}
	
	public Product[] getProducts(Long barCode, Integer sectionID, Integer brand) {
		TableProduct table = new TableProduct(getConnection());
		
		return table.getProducts(barCode, sectionID, brand);
	}
	
	public Product addProduct(Product product) {
		TableProduct table = new TableProduct(getConnection());
		
		return table.add(product);
	}
	
	public Boolean editProduct(Product original, Product newProduct) {
		TableProduct table = new TableProduct(getConnection());
		
		return table.edit(original, newProduct);
	}
	
	public Boolean deleteProduct(Product product) {
		TableProduct table = new TableProduct(getConnection());
		
		return table.delete(product);
	}
}