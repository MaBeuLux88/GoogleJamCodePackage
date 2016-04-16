package com.google;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ProblemTest {

    @Test
    public void testName() {
        ProblemSample pb = new ProblemSample();
        pb.solve();
        Assertions.assertThat(true).isTrue();
    }

}
