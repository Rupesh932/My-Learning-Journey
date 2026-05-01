package core.basicproblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberConversionTest {
    NumberConversion numberConversion;
  @BeforeEach
  void setUp(){
      numberConversion = new NumberConversion();
  }

    @Test
    @DisplayName("Decimal To Binary (number format)")
    void decimalToBinary(){
        assertAll(
                () -> assertEquals(0, numberConversion.decimalToBinary(0),"test 'Zero'"),
                () -> assertEquals(-2, numberConversion.decimalToBinary(-44),"Negative number test"),
                () -> assertEquals(1, numberConversion.decimalToBinary(1),"1 tested"),
                () -> assertEquals(11111111, numberConversion.decimalToBinary(255),"random tested"),
                () -> assertEquals(100000000, numberConversion.decimalToBinary(256),"random tested"),
                () -> assertEquals(1111111111, numberConversion.decimalToBinary(1023),"possible max tested"),
                () -> assertEquals(-22, numberConversion.decimalToBinary(1024),"limit crossed"),
                () -> assertEquals(-22, numberConversion.decimalToBinary(3024),"limit crossed")
        );
    }

    @Test
    @DisplayName("Decimal To Binary (string format)")
    void decimalToBinaryStringForm(){
        assertAll(
                () -> assertEquals("0", numberConversion.decimalToBinaryStringForm(0),"test 'Zero'"),
                () -> assertEquals("invalid input", numberConversion.decimalToBinaryStringForm(-44),"Negative number test"),
                () -> assertEquals("1", numberConversion.decimalToBinaryStringForm(1),"1 tested"),
                () -> assertEquals("11111111", numberConversion.decimalToBinaryStringForm(255),"random tested"),
                () -> assertEquals("100000000", numberConversion.decimalToBinaryStringForm(256),"random tested"),
                () -> assertEquals("11110100001001000000", numberConversion.decimalToBinaryStringForm(1000000),"10 lakh test"),
                () -> assertEquals("111111111111111111111111", numberConversion.decimalToBinaryStringForm(16777215),"24 bit-max test"),
                () -> assertEquals("1111111111111111111111111111111", numberConversion.decimalToBinaryStringForm(Integer.MAX_VALUE),"max integer test")
        );
    }
    @Test
    @DisplayName("Binary To Decimal")
    void binaryToDecimalTest(){
      assertAll(
              ()->assertEquals(0,numberConversion.binaryToDecimal(0),"test zero"),
              ()->assertEquals(-1,numberConversion.binaryToDecimal(-33),"negative test"),
              ()->assertEquals(1,numberConversion.binaryToDecimal(1),"small binary form test"),
              ()->assertEquals(256,numberConversion.binaryToDecimal(1000_0000_0),"binary form 100000000 test"),
              ()->assertEquals(-11,numberConversion.binaryToDecimal(1246),"decimal test"),
              ()-> assertEquals(2047,numberConversion.binaryToDecimal(1111_1111_111L),"binary form 11111111111 test"),
              ()->assertEquals(524287,numberConversion.binaryToDecimal(1111_1111_1111_1111_111L),"binary form 1111111111111111111 test")
      );
    }

}
