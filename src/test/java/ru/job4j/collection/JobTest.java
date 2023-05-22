package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByPriorityAndAscName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByPriorityAndDescName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

   @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

}