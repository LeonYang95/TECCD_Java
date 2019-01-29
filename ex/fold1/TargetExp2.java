public class TargetExp2{
    public boolean equals(Object obj) {
        if (obj instanceof HeadRule) {
            HeadRule rule = (HeadRule) obj;
            return (rule.leftToRight == leftToRight) &&
                    Arrays.equals(rule.tags, tags);
        }
        return false;
    }
}