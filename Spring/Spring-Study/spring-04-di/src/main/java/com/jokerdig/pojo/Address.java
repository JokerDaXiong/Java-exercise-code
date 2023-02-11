package com.jokerdig.pojo;

/**
 * @author Joker大雄
 * @data 2022/5/12 - 19:28
 **/
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
