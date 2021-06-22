package com.api.reactive.rest.repository;

import com.api.reactive.rest.model.Invoice;
import com.api.reactive.rest.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/invoice")
public class InvoiceRestController {

    @Autowired
    private IInvoiceService service;

    @PostMapping
    public Mono<Invoice> saveOneInvoice(@RequestBody Invoice invoice){
        return service.saveInvoice(invoice);
        // for Mono<String>
        // service.saveInvoice(invoice);
        // return Mono.just("Invoice saved" + invoice.getId());
    }

    @GetMapping()
    public Flux<Invoice> getAllInvoices(){
        return service.findAllInvoices();
    }

    @GetMapping("/{id}")
    public Mono<Invoice> getOneInvoice(@PathVariable String id){
        Mono<Invoice> invoice= service.getOneInvoice(id);
        return invoice;
    }

    @DeleteMapping("/{id}")
    public Mono<String> deleteInvoice(@PathVariable String id){
        service.deleteInvoice(id);
        return Mono.just("Invoice with id: " +id+ " deleted !");
    }
}
