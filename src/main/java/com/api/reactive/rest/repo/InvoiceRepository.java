package com.api.reactive.rest.repo;

import com.api.reactive.rest.model.Invoice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface InvoiceRepository extends ReactiveMongoRepository<Invoice, String> {
    Flux<Invoice> findByNumber(String number);
}
