public class UniqueType{
    void physDown(int amount, int screenAmount) {
        int currentPhysicalLine = getPhysicalLine();
        int currentScrollLine = getScrollLine();
        if (Debug.SCROLL_DEBUG) {
            Log.log(Log.DEBUG, this, "physDown() start:"
                    + currentPhysicalLine + ':' + currentScrollLine);
        }
        setSkew(0);
        if (!getDisplayManager().isLineVisible(currentPhysicalLine)) {
           int lastVisibleLine =
                    getDisplayManager().getLastVisibleLine();
           if (currentPhysicalLine > lastVisibleLine)
                setPhysicalLine(lastVisibleLine);
        } else {
            int nextPhysicalLine = getDisplayManager().
                    getNextVisibleLine(currentPhysicalLine);
            assert nextPhysicalLine > 0;
            amount -= nextPhysicalLine - currentPhysicalLine;
            moveScrollLine(getDisplayManager().
                    getScreenLineCount(currentPhysicalLine));
            setPhysicalLine(nextPhysicalLine);
        }
        if (screenAmount < 0)
            scrollUp(-screenAmount);
        else if (screenAmount > 0)
            scrollDown(screenAmount);
    }
}