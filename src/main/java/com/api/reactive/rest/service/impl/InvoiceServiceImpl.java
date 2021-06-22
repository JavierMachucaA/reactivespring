package com.api.reactive.rest.service.impl;

import com.api.reactive.rest.model.Invoice;
import com.api.reactive.rest.repo.InvoiceRepository;
import com.api.reactive.rest.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

    @Autowired
    private InvoiceRepository repo;

    public Mono<Invoice> saveInvoice(Invoice invoice){
        return repo.save(invoice);
        //for Mono<String> return type
        //return Mono.just("saved successfully");
    }

    public Flux<Invoice> findAllInvoices(){
        //return repo.findAll();
        return repo.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Invoice> getOneInvoice(String id){
        return repo.findById(id).switchIfEmpty(Mono.empty());
    }

    public Mono<Void> deleteInvoice(String id){
        return repo.deleteById(id);
    }

    public Flux<Invoice> findByNumber(String number) {
        return repo.findByNumber(number).switchIfEmpty(Flux.empty());
    }
}