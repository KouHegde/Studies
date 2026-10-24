package org.example.Study.LLD.PriceCalculator;

public class Address {

    private final String houseNumber;
    private final String houseName;
    private final String pinCode;
    private final String landMark;
    private final String addressData;
    private final String country;

    public Address(String houseNumber,
                   String houseName,
                   String pinCode,
                   String landMark,
                   String country) {

        this.houseNumber = houseNumber;
        this.houseName = houseName;
        this.pinCode = pinCode;
        this.landMark = landMark;
        this.country = country;

        this.addressData = String.join(", ",
                houseNumber,
                houseName,
                landMark,
                pinCode,
                country);
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getHouseName() {
        return houseName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getLandMark() {
        return landMark;
    }

    public String getAddressData() {
        return addressData;
    }

    public String getCountry() {
        return country;
    }
}
