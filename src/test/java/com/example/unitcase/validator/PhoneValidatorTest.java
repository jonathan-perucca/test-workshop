package com.example.unitcase.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class PhoneValidatorTest {

    private PhoneValidator phoneValidator = new PhoneValidator();

    @Parameters(name = "{0} must be {1}")
    public static Collection<Object[]> data() {
        return asList(new Object[][] {
                {"+33102030405", true},
                {"0102030405", true},
                {"test", false}
        });
    }

    @Parameter(0)
    public String number;
    @Parameter(1)
    public boolean excepted;

    @Test
    public void should_validate_number() {
        boolean result = phoneValidator.validate(this.number);

        assertThat(result).isEqualTo(this.excepted);
    }
}
