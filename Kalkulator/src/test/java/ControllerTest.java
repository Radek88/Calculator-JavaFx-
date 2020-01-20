
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sample.Controller;
import sample.Memory;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

    @InjectMocks
    Controller controller;
    @Mock
    Memory memoryMock;
    @Mock
    ArrayList<Memory> list;


    @Test
    void shoudlReturnObject() {
        controller.addToArray(new Memory(1,2,3));
        verify(list).add(new Memory(1,2,3));


    }

    @Test
    void shouldReturnSumss() {
        when(memoryMock.getFirsMemorizerd()).thenReturn(5.0);
        when(memoryMock.getSecondMemorized()).thenReturn(1.0);

        controller.add();
        assertThat(controller.getResult()).isEqualTo(6);
    }

    @Test
    void shouldReturnSum() {
        when(controller.add()).thenReturn(5.0);
        assertThat(controller.add()).isEqualTo(5);
    }

    @Test
    void shouldReturnSubtract() {
        when(controller.minus()).thenReturn(0.0);
        assertThat(controller.minus()).isEqualTo(0.0);
    }

    @Test
    void shouldReturnDivideResult() {
        when(controller.divide()).thenReturn(15.4);
        assertThat(controller.divide()).isEqualTo(15.4);
    }

    @Test
    void shouldReturnMultipleResult() {
        when(controller.multiple()).thenReturn(12.0);
        assertThat(controller.multiple()).isEqualTo(12.0);
    }

    @Test
    void shouldReturnResult() {


    }


}
