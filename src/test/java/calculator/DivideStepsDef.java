package calculator;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class DivideStepsDef {
    private Calculator calculator;
    private int value1;
    private int value2;
    private int result;
    private boolean isDivideByZeroThrown;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("^Two input values, (-?\\d+) and (-?\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        isDivideByZeroThrown = false;
        value1 = arg0;
        value2 = arg1;
    }

    @When("^I divide the two values$")
    public void iDivideTheTwoValues() {
        try {
            result = calculator.divide(value1, value2);
            System.out.println(result);
        } catch (ArithmeticException e) {
            isDivideByZeroThrown = true;
        }
    }

    @Then("^I expect the result (-?\\d+)$")
    public void iExpectTheResult(int arg0) {
        Assert.assertEquals(arg0, result);
    }

    @Then("^I expect the divide by zero exception$")
    public void iExpectTheDivideByZeroException() {
        Assert.assertTrue(isDivideByZeroThrown);
    }
}
