public class UniqueTypeT{
    void physUp(int amount, int screenAmount){
        if(Debug.SCROLL_DEBUG){
            Log.log(Log.DEBUG,this,"physUp() start:"
                    +getPhysicalLine()+ ':' + getScrollLine());
            }
        setSkew(0);
        int currentPhysicalLine = getPhysicalLine();
        if(!getDisplayManager().isLineVisible(currentPhysicalLine)){
            int firstVisibleLine =
                    getDisplayManager().getFirstVisibleLine();
            if(currentPhysicalLine < firstVisibleLine)
                setPhysicalLine(firstVisibleLine);
            }else{
            int prevPhysicalLine = getDisplayManager().
                    getPrevVisibleLine(currentPhysicalLine);
            amount -= currentPhysicalLine - prevPhysicalLine;
            }
        if(screenAmount < 0)
            scrollUp(-screenAmount);
        else if(screenAmount > 0)
            scrollDown(screenAmount);
        }
}