public class Method{
    public void testLastIndexOfShortWithStartIndex() {
        short[] array = null;
        assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 0, 2));
        array = new short[]{0, 1, 2, 3, 0};
        assertEquals(0, ArrayUtils.lastIndexOf(array, (short) 0, 2));
        assertEquals(1, ArrayUtils.lastIndexOf(array, (short) 1, 2));
        assertEquals(2, ArrayUtils.lastIndexOf(array, (short) 2, 2));
        assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 3, 2));
        assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 3, -1));
        assertEquals(-1, ArrayUtils.lastIndexOf(array, (short) 99));
        assertEquals(4, ArrayUtils.lastIndexOf(array, (short) 0, 88));
    }

    public void testLastIndexOfFloat() {
        float[] array = null;
        assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 0));
        array = new float[0];
        assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 0));
        array = new float[]{0, 1, 2, 3, 0};
        assertEquals(4, ArrayUtils.lastIndexOf(array, (float) 0));
        assertEquals(1, ArrayUtils.lastIndexOf(array, (float) 1));
        assertEquals(2, ArrayUtils.lastIndexOf(array, (float) 2));
        assertEquals(3, ArrayUtils.lastIndexOf(array, (float) 3));
        assertEquals(-1, ArrayUtils.lastIndexOf(array, (float) 99));
    }

    public void testToPrimitive_char() {
        final Character[] b = null;
        assertNull(ArrayUtils.toPrimitive(b));

        assertSame(ArrayUtils.EMPTY_CHAR_ARRAY, ArrayUtils.toPrimitive(new Character[0]));

        assertTrue(Arrays.equals(
                new char[]{Character.MIN_VALUE, Character.MAX_VALUE, '0'},
                ArrayUtils.toPrimitive(new Character[]{new Character(Character.MIN_VALUE),
                        new Character(Character.MAX_VALUE), new Character('0')}))
        );

        try {
            ArrayUtils.toPrimitive(new Character[]{new Character(Character.MIN_VALUE), null});
            fail();
        } catch (final NullPointerException ex) {
        }
    }

    public void testToPrimitive_int() {
        final Integer[] b = null;
        assertNull(ArrayUtils.toPrimitive(b));
        assertSame(ArrayUtils.EMPTY_INT_ARRAY, ArrayUtils.toPrimitive(new Integer[0]));
        assertTrue(Arrays.equals(
                new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 9999999},
                ArrayUtils.toPrimitive(new Integer[]{Integer.valueOf(Integer.MIN_VALUE),
                        Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(9999999)}))
        );

        try {
            ArrayUtils.toPrimitive(new Integer[]{Integer.valueOf(Integer.MIN_VALUE), null});
            fail();
        } catch (final NullPointerException ex) {
        }
    }

    public static String toString(final Annotation a) {
        final ToStringBuilder builder = new ToStringBuilder(a, TO_STRING_STYLE);
        for (final Method m : a.annotationType().getDeclaredMethods()) {
            if (m.getParameterTypes().length > 0) {
                continue; //wtf?
            }
            try {
                builder.append(m.getName(), m.invoke(a));
            } catch (final RuntimeException ex) {
                throw ex;
            } catch (final Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return builder.build();
    }

    public static int lastIndexOf(final long[] array, final long valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }
    public static String toString(final Annotation a) {
        final ToStringBuilder builder = new ToStringBuilder(a, TO_STRING_STYLE);
        for (final Method m : a.annotationType().getDeclaredMethods()) {
            if (m.getParameterTypes().length > 0) {
                continue; //wtf?
            }
            try {
                builder.append(m.getName(), m.invoke(a));
            } catch (final RuntimeException ex) {
                throw ex;
            } catch (final Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return builder.build();
    }
    public static int lastIndexOf(final double[] array, final double valueToFind, int startIndex) {
        if (ArrayUtils.isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

}