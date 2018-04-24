package com.glqdlt.ex;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-04-24
 */
public class PetTest {

    @Test
    public void shouldBuild(){
        final Pet.Builder builder = new Pet.Builder();
        Pet dog = builder.withAddress("asd").withOwner("qwe").withPetName("doggy").build();
        System.out.println(dog.getPetName());
    }

}