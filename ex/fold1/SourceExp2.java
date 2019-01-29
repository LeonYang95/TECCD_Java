public class SourceExp2{
    public boolean equals(Object obj) {
        if (obj instanceof Context) {
            Context context = (Context) obj;
            return Arrays.equals(parameters, context.parameters)
                    && Arrays.equals(outcomes, context.outcomes);
        }
        return false;
    }
}


