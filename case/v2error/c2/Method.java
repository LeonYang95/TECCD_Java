public class Method{
    //两个方法检测, 距离很大, 在数据集里跑, 距离很小
    private void printNotLoadDependentClass(PrintWriter out, boolean optional,
                                            NoClassDefFoundError ncdfe, String dirListing) {
        out.println("Cause: Could not load a dependent class "
                +  ncdfe.getMessage());
        if (optional) {
            out.println("       It is not enough to have Ant's optional JARs");
            out.println("       you need the JAR files that the" + " optional tasks depend upon.");
            out.println("       Ant's optional task dependencies are" + " listed in the manual.");
        } else {
            out.println("       This class may be in a separate JAR" + " that is not installed.");
        }
        out.println("Action: Determine what extra JAR files are"
                + " needed, and place them in one of:");
        out.println(dirListing);
    }

    private void printTargetAttrs(final PrintWriter out, final String tag) {
        out.print("<!ATTLIST ");
        out.println(tag);
        out.println("          id                      ID    #IMPLIED");
        out.println("          name                    CDATA #REQUIRED");
        out.println("          if                      CDATA #IMPLIED");
        out.println("          unless                  CDATA #IMPLIED");
        out.println("          depends                 CDATA #IMPLIED");
        out.println("          extensionOf             CDATA #IMPLIED");
        out.println("          onMissingExtensionPoint CDATA #IMPLIED");
        out.println("          description             CDATA #IMPLIED>");
        out.println("");
    }


}