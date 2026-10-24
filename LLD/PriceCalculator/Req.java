package org.example.Study.LLD.PriceCalculator;

public class Req {

    /*
    Functional Requirements

        Package Details — weight, dimensions (to calculate volumetric weight)
        Delivery Speed — Standard, Express, Same-Day

        Prime: Free on Standard, % discount on Express & Same-Day


        Destination — Shipping Zones

        Domestic: Zone 1 (local), Zone 2 (regional), Zone 3 (national)
        International: Flat international tier


        Customer Membership — Regular (full price) vs Prime (free standard, % discount on Express/Same-Day)
        Seller Type — FBA (0 shipping cost), Third-party (adds surcharge)
        Discounts / Promotions — Free shipping if order value ≥ ₹499 (applied on product price)

   Error Handling

        Invalid/unknown source or destination → throw appropriate error
        Bad request & internal exceptions → handled accurately

   Non-Functional Requirements

        Concurrency — Stateless computation, no request mixing
        Latency — Response within 20-25ms
        Extensibility — Easy to add new requirements
        Availability — High reliability (checkout critical path)
     */
}
