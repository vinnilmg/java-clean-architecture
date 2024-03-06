package com.vinnilmg.cleanarchitecture.core.domain;

public class Customer {
    private String id;
    private String name;
    private String cpf;
    private Address address;
    private boolean validCpf;

    public Customer() {
        this.validCpf = false;
    }

    public Customer(String id, String name, String cpf, Address address, boolean validCpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.validCpf = validCpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean getValidCpf() {
        return validCpf;
    }

    public void setValidCpf(boolean validCpf) {
        this.validCpf = validCpf;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", address=" + address +
                ", validCpf=" + validCpf +
                '}';
    }
}
