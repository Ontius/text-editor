package ch.zhaw.text.editor.utility;

public class TextUtil {

    /**
     * Returns a simple string.
     *
     * @return A simple string.
     */
    public static String getShortParagraph() {
        return "Coding is fun";
    }

    /**
     * Returns a lorem ipsum paragraph.
     *
     * @return A lorem ipsum paragraph.
     */
    public static String getLoremIpsumParagraph() {
        return "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor " +
                "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam " +
                "et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
                "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
                "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos " +
                "et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata " +
                "sanctus est Lorem ipsum dolor sit amet.";
    }

    /**
     * Returns a long paragraph.
     *
     * @return A long paragraph.
     */
    public static String getLongParagraph() {
        return getDynamicParagraph(10);
    }

    /**
     * Returns a paragraph with a dynamic size. The size is scaled by the given {@code factor}.
     *
     * @param factor The factor that is used to scale the size the paragraph.
     * @return The paragraph.
     */
    public static String getDynamicParagraph(int factor) {
        String paragraph = getLoremIpsumParagraph();

        for(int i = 0; i < factor - 1; i++) {
            paragraph += " " + getLoremIpsumParagraph();
        }

        return paragraph;
    }

}
