public class Test0{
    private void assertEqualsArchNotNull(final Processor.Arch arch, final Processor processor) {
        assertNotNull(arch);
        assertNotNull(processor);
        assertEquals(arch, processor.getArch());
    }
    public static int[] add(final int[] array, final int element) {
        final int[] newArray = (int[])copyArrayGrow1(array, Integer.TYPE);
        newArray[newArray.length - 1] = element;
        return newArray;
    }


    public static void swap(final long[] array, final int offset1, final int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    public static byte[] nullToEmpty(final byte[] array) {
        if (isEmpty(array)) {
            return EMPTY_BYTE_ARRAY;
        }
        return array;
    }


    //3
    public void testShiftRangeNoElemObject() {
        final String[] array = new String[]{"1", "2", "3", "4"};
        ArrayUtils.shift(array, 1, 1, 1);
        assertEquals("1", array[0]);
        assertEquals("2", array[1]);
        assertEquals("3", array[2]);
        assertEquals("4", array[3]);
    }
    public void testGetFirstContextValue() {
        exceptionContext.addContextValue("test2", "different value");

        assertTrue(exceptionContext.getFirstContextValue("test1") == null);
        assertTrue(exceptionContext.getFirstContextValue("test2").equals("some value"));
        assertTrue(exceptionContext.getFirstContextValue("crap") == null);

        exceptionContext.setContextValue("test2", "another");

        assertTrue(exceptionContext.getFirstContextValue("test2").equals("another"));
    }

    //4
    public void testShiftRangeNoElemObject() {
        final String[] array = new String[]{"1", "2", "3", "4"};
        ArrayUtils.shift(array, 1, 1, 1);
        assertEquals("1", array[0]);
        assertEquals("2", array[1]);
        assertEquals("3", array[2]);
        assertEquals("4", array[3]);
    }
    public void testHashCode() throws Exception {
        final Test test = getClass().getDeclaredMethod("testHashCode").getAnnotation(Test.class);
        assertEquals(test.hashCode(), AnnotationUtils.hashCode(test));
        final TestAnnotation testAnnotation1 = field1.getAnnotation(TestAnnotation.class);
        assertEquals(testAnnotation1.hashCode(), AnnotationUtils.hashCode(testAnnotation1));
        final TestAnnotation testAnnotation3 = field3.getAnnotation(TestAnnotation.class);
        assertEquals(testAnnotation3.hashCode(), AnnotationUtils.hashCode(testAnnotation3));
    }


}