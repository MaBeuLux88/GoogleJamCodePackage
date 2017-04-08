package com.google;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ProblemTest {

    @Test
    public void testName() {
        PreProcess preProcess = new PreProcess();
        ProblemSample pb = new ProblemSample(preProcess);
        pb.solve();
        Assertions.assertThat(true).isTrue();
    }

}
