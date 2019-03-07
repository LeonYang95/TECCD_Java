public class Method{
    private void processFile(final String line) {
        if (!remote && line.startsWith("Working file:")) {
            file = line.substring(14, line.length());
            status = GET_REVISION;
        } else if (remote && line.startsWith("RCS file:")) {
            int startOfFileName = 0;
            for (int i = 0; i < moduleNames.length; i++) {
                int index = line.indexOf(moduleNames[i]);
                if (index >= 0) {
                    startOfFileName = index + moduleNameLengths[i] + 1;
                    break;
                }
            }
            int endOfFileName = line.indexOf(",v");
            if (endOfFileName == -1) {
                file = line.substring(startOfFileName);
            } else {
                file = line.substring(startOfFileName, endOfFileName);
            }
            status = GET_REVISION;
        }
    }

    public void encodedata(final Writer out, final String value) throws IOException {
        final int len = value.length();
        int prevEnd = 0, cdataEndPos = value.indexOf("]]>");
        while (prevEnd < len) {
            final int end = (cdataEndPos < 0 ? len : cdataEndPos);
            for (int prevLegalCharPos = prevEnd; prevLegalCharPos < end;/*empty*/) {
                int illegalCharPos;
                for (illegalCharPos = prevLegalCharPos; true; ++illegalCharPos) {
                    if (illegalCharPos >= end
                            || !isLegalCharacter(value.charAt(illegalCharPos))) {
                        break;
                    }
                }
                out.write(value, prevLegalCharPos, illegalCharPos - prevLegalCharPos);
                prevLegalCharPos = illegalCharPos + 1;
            }

            if (cdataEndPos >= 0) {
                out.write("]]]]><![CDATA[>");
                prevEnd = cdataEndPos + 3;
                cdataEndPos = value.indexOf("]]>", prevEnd);
            } else {
                prevEnd = end;
            }
        }
    }


}