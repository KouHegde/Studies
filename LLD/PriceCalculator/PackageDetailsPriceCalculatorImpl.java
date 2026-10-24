//package org.example.Study.LLD.PriceCalculator;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//public class PriceCalculatorImpl implements PriceCalculator {
//
//    private final CustomerRepository customerRepository;
//    private final PackageDetailsPriceCalculator packageCalculator;
//    private final DeliverySpeedCalculatorFactory deliveryFactory;
//    private final DestinationCalculatorFactory destinationFactory;
//    private final CustomerMembershipCalculatorFactory membershipFactory;
//    private final ShippingZoneResolver shippingZoneResolver;
//
//    public PriceCalculatorImpl(
//            CustomerRepository customerRepository,
//            PackageDetailsPriceCalculator packageCalculator,
//            DeliverySpeedCalculatorFactory deliveryFactory,
//            DestinationCalculatorFactory destinationFactory,
//            CustomerMembershipCalculatorFactory membershipFactory,
//            ShippingZoneResolver shippingZoneResolver) {
//
//        this.customerRepository = customerRepository;
//        this.packageCalculator = packageCalculator;
//        this.deliveryFactory = deliveryFactory;
//        this.destinationFactory = destinationFactory;
//        this.membershipFactory = membershipFactory;
//        this.shippingZoneResolver = shippingZoneResolver;
//    }
//
//    @Override
//    public FinalPriceCalculationResponse calculate(
//            PriceCalculatorRequest request) {
//
//        Customer customer = customerRepository.getCustomerById(request.getCustomerId());
//
//        double packageCharge = packageCalculator.calculate(request.getPkg());
//
//        double deliveryCharge = deliveryFactory.getCalculator(request.getDeliverySpeed()).calculate();
//
//        ShippingZone zone = shippingZoneResolver.resolve(request.getFromAddress(), request.getToAddress());
//        if (zone == ShippingZone.INTERNATIONAL && request.getDeliverySpeed() == DeliverySpeed.SAME_DAY) {
//            throw new RuntimeException("Same-Day not available for international shipments");
//        }
//
//        double destinationCharge = destinationFactory.getCalculator(zone).calculate(request.getFromAddress(), request.getToAddress());
//
//        double subtotal = packageCharge + deliveryCharge + destinationCharge;
//
//        double membershipDiscount = membershipFactory.getCalculator(customer.getMembershipType()).calculateDiscount(subtotal, request.getDeliverySpeed(), customer);
//
//        double finalAmount = subtotal - membershipDiscount;
//
//        Price price = new Price(finalAmount, membershipDiscount, destinationCharge, membershipDiscount, deliveryCharge, packageCharge);
//
//        return new FinalPriceCalculationResponse(UUID.randomUUID().toString(), price, request.getPkg(), request.getFromAddress(), request.getToAddress(), request.getCustomerId(), request.getDeliverySpeed(), LocalDateTime.now(), LocalDateTime.now().plusDays(3));
//    }
//}