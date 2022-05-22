import file_controller.TypeOS;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {
    private Calculator testCalc;

    @Mock
    private Logger loggerMock;

    private String testPath;


    @BeforeEach
    public void beforeClassFunction() {
        Logger loggerMock = mock(Logger.class);
        testPath = "TestPathWindowsOS";
//        when(loggerMock.getFilePath(testPath, TypeOS.WINDOWS)).thenReturn("test file path of class is Windows!");
        //when(loggerMock.getFilePath(anyString(),any(TypeOS.class))).thenReturn("TestCase");
//        when(loggerMock.getFilePath(anyString(),eq(TypeOS.LINUX))).thenReturn("test file path of class is Linux!");

        doNothing().when(loggerMock).log(anyString());


        testCalc = new Calculator(loggerMock,testPath);
    }


    @AfterAll
    public void teardown() {

    }



    @Test
    @DisplayName("Subtraction test")
    public void subtract() {
        Double result1 = testCalc.subtract(7.0,7.0);
        Double result2 = testCalc.subtract(13.0, 18.0);
        Double result3 = testCalc.subtract(1.2875, 0.789);
        assertAll(() -> assertEquals(0, result1,0.001),
                () -> assertEquals(-5, result2,0.001),
                () -> assertEquals(0.4985, result3,0.001));
    }

    @Test
    @DisplayName("Summary test")
    public void testAdd() {
        Double testResult = testCalc.add(2.0,2.0);
        assertEquals(4, testResult);
    }
    @Test
    @DisplayName("Alternative summary test")
    public void alternativeTestAdd(){
        Double testResult = testCalc.add(3.0,3.0);
        assertEquals(6, testResult);
    }

    @Test
    @DisplayName("Multiplication test")
    public void multiplicate() {

    }


    @Test
    @DisplayName("Throw division zero test")
    public void throwDivisionTest() {
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            testCalc.divide(10.0, 0.0);//Code under test
        });

        Assertions.assertEquals("Zero division!!!", thrown.getMessage());
    }

    @Test
    @DisplayName("No throw division zero test")
    public void noThrowDivisionTest() {
        Double result = assertDoesNotThrow(() -> testCalc.divide(0.0, 2.0));
        assertEquals(0.0, result);
    }

}

