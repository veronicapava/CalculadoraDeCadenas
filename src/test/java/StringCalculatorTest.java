import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    public StringCalculator stringCalculatorInstance = new StringCalculator();
    //An empty string returns zero
    @Test
    public void emptyStringTest() throws Exception {
        Assert.assertEquals(stringCalculatorInstance.add(""),0);
    }
    // A single number returns the value
    @Test
    public void singleNumberReturnItsValueTest() throws Exception {
        Assert.assertEquals(stringCalculatorInstance.add("2"),2);
        Assert.assertEquals(stringCalculatorInstance.add("1"),1);
    }

    //Two numbers, comma delimited, returns the sum
    @Test
    public void twoNumbersCommaDelimitedReturnsTheSumTest() throws Exception {
        Assert.assertEquals(stringCalculatorInstance.add("0,2"),2);
        Assert.assertEquals(stringCalculatorInstance.add("1,1"),2);
        Assert.assertEquals(stringCalculatorInstance.add("1,2"),3);
    }

    // Two numbers, newline delimited, returns the sum
    @Test
    public void sameThatBeforeButNewLineDelimitedTest() throws Exception {
        Assert.assertEquals(stringCalculatorInstance.add("0\n2"),2);
        Assert.assertEquals(stringCalculatorInstance.add("1\n1"),2);
        Assert.assertEquals(stringCalculatorInstance.add("1\n2"),3);
    }

    //Delimiters must be equal
    @Test
    public void sameThatBeforeButAllDelimitersWorksTest() throws Exception {
        Assert.assertEquals(stringCalculatorInstance.add("1\n2\n3"),6);
        Assert.assertEquals(stringCalculatorInstance.add("1\n2\n4"),7);
    }

    // Negative numbers throw an exception
    @Test(expected = Exception.class)
    public void negativeNumbersThrowsAnExceptionTest() throws Exception {
        stringCalculatorInstance.add("-1,-1");
    }

    // Numbers greater than 1000 are ignored
    @Test
    public void greaterThan1000AreIgnoredTest() throws Exception {
        Assert.assertEquals(stringCalculatorInstance.add("2,1000"),1002);
        Assert.assertEquals(stringCalculatorInstance.add("2,1001"),2);
    }
    // A single char delimiter can be defined on the first line
    @Test
    public void singleCharDelimiterTest() throws Exception {
        Assert.assertEquals(stringCalculatorInstance.add("#2#1000"),1002);
    }
}
