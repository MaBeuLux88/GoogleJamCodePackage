package com.google;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ProblemTest {

    @Test
    public void testName() {
        Solution.Problem pb = new Solution.Problem(1, 2);
        Object solution = pb.getSolution();
        Assertions.assertThat(solution).isEqualTo(2);
    }

}
