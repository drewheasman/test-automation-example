package org.drewheasman.test.rest.common.pojo;

import org.junit.Test;

import static org.drewheasman.test.rest.common.pojo.PojoHelper.defined;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PojoHelperTest {
    @Test
    public void isDefinedString() {
        assertTrue(defined("just some string"));
    }

    @Test
    public void isDefinedInteger() {
        assertTrue(defined(123));
    }

    @Test
    public void notDefinedString() {
        assertFalse(defined("undefined"));
    }

    @Test
    public void notDefinedInteger() {
        assertFalse(defined(-82));
    }
}
