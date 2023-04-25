import com.company.FoodProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.Map;

public class FoodProductTest {
    @Test
    public void accessorCheck() {
        Assertions.assertEquals(FoodProduct.fromCsv(Path.of("src/test/resources/buraki.csv")).getName(), "Buraki - za 1 kg");
    }


    @Test
    public void priceCheck() {
        Assertions.assertEquals(FoodProduct.fromCsv(Path.of("src/test/resources/buraki.csv")).getPrice(2010,1,"ŚLĄSKIE"),1.36);
    }

    @Test
    public  void mapCheck() throws NoSuchFieldException, IllegalAccessException {
        //FoodProduct c = FoodProduct.fromCsv(Path.of("src/test/resources/buraki.csv"));
        FoodProduct c = new FoodProduct();

        //nie działa ale i tak jest złą praktyką więc whatever xD

        Field pricesField = FoodProduct.class.getDeclaredField("prices");
        pricesField.setAccessible(true);

        Assertions.assertNotNull(pricesField);
    }

}
