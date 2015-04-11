package com.google;

import org.assertj.core.api.Assertions;

public class Test {

    @org.testng.annotations.Test
    public void testName() throws Exception {
        Assertions.assertThat(true).isTrue();
    }

}
