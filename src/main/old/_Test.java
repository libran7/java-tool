package org.osgl;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: luog
 * Date: 19/06/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class _Test extends TestBase {
    @Test
    public void testEnsureGet() {
        String s = X.ensureGet(null, null, "ss");
        eq(s, "ss");
        
        String p1 = "foo";
        String p2 = "bar";
        s = X.ensureGet(p1, p2);
        eq(s, p1);
    }
    
    @Test
    public void testNewArray() {
        String[] sa = X.newArray(String.class, 5);
        sa[0] = "foo";
    }
}