public class Cmis{
	//1
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Object[] array) {
buffer.append(arrayStart);
for (int i = 0; i < array.length; i++) {
final Object item = array[i];
if (i > 0) {
buffer.append(arraySeparator);
}
if (item == null) {
appendNullText(buffer, fieldName);

} else {
appendInternal(buffer, fieldName, item, arrayContentDetail);
}
}
buffer.append(arrayEnd);
}

protected void appendDetail(final StringBuffer buffer, final String fieldName, final float[] array) {
buffer.append(arrayStart);
for (int i = 0; i < array.length; i++) {
if (i > 0) {
buffer.append(arraySeparator);
}
appendDetail(buffer, fieldName, array[i]);
}
buffer.append(arrayEnd);
}



}