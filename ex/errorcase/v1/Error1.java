public class Error1{
    public void testArrayCreationWithDifferentTypes() {
        final Number[] array = ArrayUtils.<Number>toArray(Integer.valueOf(42), Double.valueOf(Math.PI));
        assertEquals(2, array.length);
        assertEquals(Integer.valueOf(42), array[0]);
        assertEquals(Double.valueOf(Math.PI), array[1]);
    }

    public void reset() {
        wrappedFactory = null;
        exceptionHandler = null;
        namingPattern = null;
        priority = null;
        daemonFlag = null;
    }
}