package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Invoices;
import prjS4.ProjectSem4.interfaces.IInvoiceService;
import prjS4.ProjectSem4.repositories.InvoiceRepository;

@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoices> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoices getInvoiceById(String id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public Invoices createInvoice(Invoices invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoices updateInvoice(String id, Invoices invoice) {
        if (!invoiceRepository.existsById(id)) {
            return null;
        }
        invoice.setInvId(id);
        return invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoice(String id) {
        invoiceRepository.deleteById(id);
    }
    
}
