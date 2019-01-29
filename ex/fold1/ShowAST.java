public class TargetExp{
    private boolean r_mark_ndA() {
        if (!r_check_vowel_harmony()){
            return false;
        }
        if (find_among_b(a_7, 2) == 0){
            return false;
        }
        return true;
    }

    private boolean r_mark_yUz() {
        if (!r_check_vowel_harmony()){
            return false;
        }
        if (find_among_b(a_14, 4) == 0){
            return false;
        }
        if (!r_mark_suffix_with_optional_y_consonant()){
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Context) {
            Context context = (Context) obj;
            return Arrays.equals(parameters, context.parameters)
                    && Arrays.equals(outcomes, context.outcomes);
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HeadRule) {
            HeadRule rule = (HeadRule) obj;
            return (rule.leftToRight == leftToRight) &&
                    Arrays.equals(rule.tags, tags);
        }
        return false;
    }

}
