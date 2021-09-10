import com.sinch.FindPairs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindPairsTest {

    @Test
    @DisplayName("Two pairs present for the given value")
    void testCalculateSuccess() {
        List<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(2,1,4,5,3));
        assertEquals(2, FindPairs.calculatePairs(inputArray, 6),
                "Two pairs should be found");
    }

    @Test
    @DisplayName("No pairs present for the given value")
    void testCalculateFailure() {
        List<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(12,11,4,5,3));
        assertEquals(0, FindPairs.calculatePairs(inputArray, 10),
                "No pairs should be found");
    }

}
