package com.example.blog._core.practice;

import org.junit.jupiter.api.Test;

public class IntegerTest {

    @Test
    public void integer_test(){
        Integer n1 = 3000;
        Integer n2 = 3000;

        System.out.println(n1.intValue() == n2.intValue());
    }
}
