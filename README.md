# SE-Lab4
## مرحله اول-- راه‌اندازی BDD 
مراحل گفته‌شده را انجام می‌دهیم و اسکرین‌شات‌های مربوط به آن در پوشه First_Stage/report قرار دارد

### حال RunnerTest را دوباره اجرا می‌کنیم. این بار برخی تست‌ها به مشکل undefined برمی‌خورند. این موارد تست کدامند؟ علت بروز مشکل چیست؟ 
 علت بوجود آمدن خطا دادن عدد منفی‌(-1) در ورودی است. چرا که رجکس اولیه ساخته شده صرفا برای اعداد مثبت کار میکند و اعداد منفی لحاظ نشده‌اند
### مشکل را با تغییر کد برطرف نمایید. 
با تغییر دادن رجکس مورد نظر به صورت زیر, اعداد منفی رو هم لحاظ میکنیم:  
`@Given("^Two input values, (-*\\d+) and (-*\\d+)$")`
## مرحله دوم-- ماشین حساب  
سناریو‌های گفته شده را تعریف می‌کنیم:
``` 
Feature: Calculator
  We want to perform production (multiplication), division, and power operations.

  Scenario: Multiply two numbers
    Given the first number is 6
    And the second number is -2
    When I multiply the two numbers
    Then the result should be -12

  Scenario: Divide two numbers
    Given the first number is 6
    And the second number is 2
    When I divide the first number by the second number
    Then the result should be 3

  Scenario: Power of two numbers
    Given the first number is 6
    And the second number is -2
    When I raise the first number to the power of the second number
    Then the result should be 0 
```
و تعاریف مربوط به آنها را میسازیم:
``` 
public class MyStepdefs {

    private Calculator calculator;
    private int value1;
    private int value2;
    private String op;
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
```
سپس برای سناریو outline به صورت زیر عمل می‌کنیم:  
```
Feature: Calculator operations
  We want to perform production (multiplication), division, and power operations.

  Scenario Outline: Perform an operation on two numbers
    Given the first number is <first>
    And the second number is <second>
    When I perform the "<opt>" operation
    Then the result should be <result>

    Examples:
      | first | second | opt | result |
      | 6     | -2      | *   | -12     |
      | -6     | 2      | /   | -3      |
      | 6     | -2      | ^   | 0     |
```
و همجنین تعریف آنرا اضافه می‌کنیم:
```
@When("I perform the {string} operation")
    public void iPerformTheOperation(String arg0) {
        op = arg0;
        if (op.equals("*")){
            result = calculator.multiply(value1, value2);
        }
        else if(op.equals("/")){
            result = calculator.division(value1, value2);
        }
        else {
            result = calculator.power(value1, value2);
        }
        System.out.println(result);
    }
```
قابل ذکر است که اعداد به صورت integer در نظر گرفته شده‌اند پس حاصل تقسیم یک عدد اگر کوچکتر از ۱ شود, صفر نمایش داده می‌شود. همینطور این قضیه برای توان به اعداد منفی هم صادق است.
