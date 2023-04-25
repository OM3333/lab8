import com.company.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Executable;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProductTest {

    @Test
    public void testIndex(){
        Assertions.assertEquals(1, Product.priceIndex(2010,2) );
        Assertions.assertEquals(12, Product.priceIndex(2011,1) );
    }

    @Test
    public void testException(){
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { Product.priceIndex(2009,1); });
    }

    public static Stream<Arguments> getMonthYearIndexes(){
        return Stream.of(
            Arguments.of(2010, 1, 0),
            Arguments.of(2010, 2, 1),
            Arguments.of(2010, 3, 2),
            Arguments.of(2010, 4, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("getMonthYearIndexes")
    public void parameterized(int year, int month, int result){
        Assertions.assertEquals(Product.priceIndex(year, month),result);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "test.csv",numLinesToSkip = 1)
    void parameterizedCSV(int year, int month, int result){
        Assertions.assertEquals(Product.priceIndex(year, month),result);
    }

    @Test
    void priceIndexMultiple(){
        int expected = 0;
        for(int year = 2001;year<2021;++year)
        {
            for(int month : IntStream.rangeClosed(1,12).toArray()){
                if(year>=2010){
                    Assertions.assertEquals(Product.priceIndex(year,month),expected++);
                }
            }
        }
    }
}
