package prjS4.ProjectSem4.interfaces;

import java.util.List;
import prjS4.ProjectSem4.entities.Invoices;

public interface IInvoiceService {
    
    List<Invoices> getAllInvoices();
    
    Invoices getInvoiceById(String id);
    
    Invoices createInvoice(Invoices invoice);
    
    Invoices updateInvoice(String id, Invoices invoice);
    
    void deleteInvoice(String id);
    
}
