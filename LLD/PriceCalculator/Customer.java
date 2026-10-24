package org.example.Study.LLD.PriceCalculator;

import java.util.List;

public class Customer {

    private final String name;
    private final String phoneNumber;
    private final MembershipType membershipType;
    private final List<Address> addresses;

    private Customer(Builder builder) {
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.membershipType = builder.membershipType;
        this.addresses = List.copyOf(builder.addresses);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public static class Builder {

        private String name;
        private String phoneNumber;
        private MembershipType membershipType;
        private List<Address> addresses;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder membershipType(MembershipType membershipType) {
            this.membershipType = membershipType;
            return this;
        }

        public Builder addresses(List<Address> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}