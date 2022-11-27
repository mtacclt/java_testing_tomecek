import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import mockito.classes.Fruits;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoMockMethodExample {
    @Mock
    List<String> mockList;
    //@InjectMock creates an instance of the class and
//injects the mocks that are marked with the annotations @Mock into it.
    @InjectMocks
    Fruits mockFruits;

    @SuppressWarnings("unchecked")
    @Test

    public void test() {
// using Mockito.mock() method
        List<String> mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("Apple");
        when(mockList.size()).thenReturn(1);
        System.out.println(mockList.get(1));
        System.out.println(mockList.size());
        System.out.println(mockFruits.getNames().get(0));
        System.out.println(mockFruits.getNames().size());
        mockList.add(1, "Mango");
        System.out.println(mockList.get(1));
    }
}

/*
Regarding the print, printing mocklist.get(1) prints null as it does not exist, and only asking for 0 would get apple.
mocklist.size will correctly print zero due to when()
mockFruits.getNames() will give nullpointer exception as we have no fruits to inject, same with size
adding to the mocklist will not do anything as we are still mocking the object, and as such will return null

 */