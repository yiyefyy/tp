package seedu.address.model.task;

import org.junit.jupiter.api.Test;
import seedu.address.testutil.PersonBuilder;


import static org.junit.jupiter.api.Assertions.*;

public class ModuleIsDonePredicateTest {
    @Test
    public void equals() {

        ModuleIsDonePredicate predicate = new ModuleIsDonePredicate(false);

        // same object -> returns true
        assertTrue(predicate.equals(predicate));

        // same values -> returns true
        ModuleIsDonePredicate predicateCopy = new ModuleIsDonePredicate(false);
        assertTrue(predicate.equals(predicateCopy));

        // different types -> returns false
        assertFalse(predicate.equals(1));

        // null -> returns false
        assertFalse(predicate.equals(null));

    }

    @Test
    public void test_nameContainsKeywords_returnsTrue() {

        // One keyword
        ModuleIsDonePredicate predicate = new ModuleIsDonePredicate(false);
        assertTrue(predicate.test(new PersonBuilder().withIsDone(false).build()));

    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        ModuleIsDonePredicate predicate = new ModuleIsDonePredicate(false);
        assertTrue(predicate.test(new PersonBuilder().withIsDone(true).build()));
    }
}