package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "1", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        ValidateInput input1 = new ValidateInput(out, in);
        ValidateInput input2 = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        int selected1 = input1.askInt("Enter menu:");
        int selected2 = input2.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        assertThat(selected1).isEqualTo(1);
        assertThat(selected2).isEqualTo(3);
    }

    @Test
    public void whenNegativeNumberInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}