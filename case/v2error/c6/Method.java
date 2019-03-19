public class Method{
    public void endElement(String name) throws SAXException {
        processElement();
        currentText = "";
        this.currentElement = "";
        if (name.equals(EJB_REF) || name.equals(EJB_LOCAL_REF)) {
            inEJBRef = false;
        } else if (parseState == STATE_IN_ENTITY && name.equals(ENTITY_BEAN)) {
            parseState = STATE_IN_BEANS;
        } else if (parseState == STATE_IN_SESSION && name.equals(SESSION_BEAN)) {
            parseState = STATE_IN_BEANS;
        } else if (parseState == STATE_IN_MESSAGE && name.equals(MESSAGE_BEAN)) {
            parseState = STATE_IN_BEANS;
        } else if (parseState == STATE_IN_BEANS && name.equals(ENTERPRISE_BEANS)) {
            parseState = STATE_IN_EJBJAR;
        } else if (parseState == STATE_IN_EJBJAR && name.equals(EJB_JAR)) {
            parseState = STATE_LOOKING_EJBJAR;
        }
    }
    public void startElement(String name, AttributeList attrs)
            throws SAXException {
        this.currentElement = name;
        currentText = "";
        if (name.equals(EJB_REF) || name.equals(EJB_LOCAL_REF)) {
            inEJBRef = true;
        } else if (parseState == STATE_LOOKING_EJBJAR && name.equals(EJB_JAR)) {
            parseState = STATE_IN_EJBJAR;
        } else if (parseState == STATE_IN_EJBJAR && name.equals(ENTERPRISE_BEANS)) {
            parseState = STATE_IN_BEANS;
        } else if (parseState == STATE_IN_BEANS && name.equals(SESSION_BEAN)) {
            parseState = STATE_IN_SESSION;
        } else if (parseState == STATE_IN_BEANS && name.equals(ENTITY_BEAN)) {
            parseState = STATE_IN_ENTITY;
        } else if (parseState == STATE_IN_BEANS && name.equals(MESSAGE_BEAN)) {
            parseState = STATE_IN_MESSAGE;
        }
    }


}