package com.glqdlt.ex;

/**
 * Created By iw.jhun
 * On 2018-04-24
 */

//Builder Pattern
public class Pet {

    private String petName;
    private String address;
    private String owner;

    public String getPetName() {
        return petName;
    }

    public String getAddress() {
        return address;
    }

    public String getOwner() {
        return owner;
    }

    public static class Builder {

        private String petName;
        private String address;
        private String owner;

        public Builder withPetName(final String name) {
            this.petName = name;
            return this;
        }

        public Builder withOwner(final String owner) {
            this.owner = owner;
            return this;
        }

        public Builder withAddress(final String address) {
            this.address = address;
            return this;
        }

        public Pet build(){
            if(this.petName == null ||this.owner == null || this.address ==null){
                throw  new IllegalStateException("Cannot create pet");
            }
            return new Pet(petName,address,owner);
        }
    }

    private Pet(String petName, String address, String owner) {
        this.petName = petName;
        this.address = address;
        this.owner = owner;
    }
}
