package server.app.support;

import java.sql.Connection;

import server.app.db.tables.TableSupport;
import server.core.ServerOperation;
import share.app.support.IOperations;
import share.app.support.Support;
import share.core.Date;

public class Operations extends ServerOperation implements IOperations {
	
	public Operations(Connection appConnection, Connection sysConnection) {
		super(appConnection, sysConnection);
	}
	
	public Support[] getSupports(Date dateCreationParam, String statusParam) {
		TableSupport table = new TableSupport(getSystemConnection());
		
		return table.getSupports(dateCreationParam, statusParam, getConnection());
	}
	
	public Boolean addSupport(Support support) {
		TableSupport table = new TableSupport(getSystemConnection());
		
		return table.add(support);
	}
	
	public Boolean editSupport(Support original, Support newSupport) {
		TableSupport table = new TableSupport(getSystemConnection());
		
		return table.edit(original, newSupport);
	}
}