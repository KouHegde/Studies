package org.example.Study.LLD.PriceCalculator;

import java.util.EnumMap;
import java.util.Map;

public class DeliverySpeedCalculatorFactory {

    private final Map<DeliverySpeed, DeliverySpeedCalculator> calculators;

    public DeliverySpeedCalculatorFactory() {

        calculators = new EnumMap<>(DeliverySpeed.class);

        calculators.put(DeliverySpeed.EXPRESS, new ExpressDeliverySpeedCalculator());


    }

    public DeliverySpeedCalculator getCalculator(DeliverySpeed deliverySpeed) {

        DeliverySpeedCalculator calculator = calculators.get(deliverySpeed);

        if (calculator == null) {
            throw new IllegalArgumentException("Unsupported delivery speed");
        }

        return calculator;
    }
}