package org.example.Study.LLD.PriceCalculator;

public class PriceCalculatorImpl implements PriceCalculator{
    private final CustomerRepository customerRepository;

    public PriceCalculatorImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public FinalPriceCalculationResponse calculate(PriceCalculatorRequest request) {
        Customer customer = customerRepository.getCustomerById(request.getCustomerId());
    }
}
