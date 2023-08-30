package com.jana.hexagonal.application.core.domain;

public class Customer {

    private String id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean validCpf;

    public Customer(){
        //se criar um cliente ele sempre vem com cpf não validado, pois só será validado após passar pela fila do kafka, passar pela api de validação do cpf etc e só ai que se tornará true.
        this.validCpf = false;
    }
    public Customer(String id, String name, Address address, String cpf, Boolean validCpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValidCpf() {
        return validCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        validCpf = validCpf;
    }
}
