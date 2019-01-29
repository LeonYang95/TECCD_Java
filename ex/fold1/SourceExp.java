public class SourceExp{

    public void visitTypeInsn(final int opcode, final String desc){
        if(computeMaxs && opcode == Constants.NEW){
            int size = stackSize + 1;
            if(size > maxStackSize){
                maxStackSize = size;
            }
            stack = size;
        }
        code.put12(opcode, cw.newClass(desc).index);
    }
}


