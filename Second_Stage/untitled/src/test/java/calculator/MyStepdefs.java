package calculator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import org.junit.Assert;


public class MyStepdefs {

    private Calculator calculator;
    private int value1;
    private int value2;
    private int result = 1;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("the first number is (-*\\d+)$")
    public void theFirstNumberIs(int arg0) {
        value1 = arg0;
    }

    @And("the second number is (-*\\d+)$")
    public void theSecondNumberIs(int arg0) {
        value2 = arg0;
    }

    @When("I multiply the two numbers")
    public void iMultiplyTheTwoNumbers() {
        result = calculator.multiply(value1, value2);
        System.out.println(result);
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int arg0) {
        Assert.assertEquals(arg0, result);
    }

    @When("I divide the first number by the second number")
    public void iDivideTheFirstNumberByTheSecondNumber() {
        result = calculator.division(value1, value2);
        System.out.println(result);
    }

    @When("I raise the first number to the power of the second number")
    public void iRaiseTheFirstNumberToThePowerOfTheSecondNumber() {
        result = calculator.power(value1, value2);
        System.out.println(result);
    }
}
