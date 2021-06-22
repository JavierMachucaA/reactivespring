package com.api.reactive.rest.service;

import com.api.reactive.rest.model.Invoice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IInvoiceService {
    public Mono<Invoice> saveInvoice(Invoice invoice);

    public Flux<Invoice> findAllInvoices();

    public Mono<Invoice> getOneInvoice(String id);

    public Mono<Void> deleteInvoice(String id);

    public Flux<Invoice> findByNumber(String number);
}
