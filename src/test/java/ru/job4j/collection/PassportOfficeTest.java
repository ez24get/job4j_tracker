package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void duplicate() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenDuplicate = new Citizen("2f44a", "Dmitri Green");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizenDuplicate);
        assertThat(office.get(citizen.getPassport()).equals(office.get(citizenDuplicate.getPassport()))).isFalse();
    }
}