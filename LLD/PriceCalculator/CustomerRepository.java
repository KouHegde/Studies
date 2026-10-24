package org.example.Study.LLD.PriceCalculator;

public interface CustomerRepository {
    Customer getCustomerById(String id);
    Customer getCustomerByName(String name);
}
