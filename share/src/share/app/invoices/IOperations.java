package share.app.invoices;

import share.core.Date;

public interface IOperations
{
	public static final String GET_INVOICES = "server.app.invoices.Operations:getInvoices";
	public static final String ADD_INVOICE = "server.app.invoices.Operations:addInvoice";
	public static final String EDIT_INVOICE = "server.app.invoices.Operations:editInvoice";
	public static final String DELETE_INVOICE = "server.app.invoices.Operations:deleteInvoice";

	public static final String GET_INVOICE_DETAIL = "server.app.invoices.Operations:getInvoiceDetail";
	public static final String ADD_INVOICE_DETAIL = "server.app.invoices.Operations:addInvoiceDetail";
	public static final String EDIT_INVOICE_DETAIL = "server.app.invoices.Operations:editInvoiceDetail";
	public static final String DELETE_INVOICE_DETAIL = "server.app.invoices.Operations:deleteInvoiceDetail";

	public Invoice[] getInvoices(Integer clientID, Date dateParam);

	public Invoice addInvoice(Invoice invoice);

	public Boolean editInvoice(Invoice original, Invoice newInvoice);

	public Boolean deleteInvoice(Invoice invoice);

	public InvoiceDetail[] getInvoiceDetail(Integer invoiceID);

	public Boolean addInvoiceDetail(InvoiceDetail invoiceDetail);

	public Boolean editInvoiceDetail(InvoiceDetail original, InvoiceDetail newInvoiceDetail);

	public Boolean deleteInvoiceDetail(InvoiceDetail invoiceDetail);
}