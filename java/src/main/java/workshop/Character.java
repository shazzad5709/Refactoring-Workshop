package workshop;

public enum Character {
    SMALLER("<", "&lt;"), GREATER(">", "&gt;"), AND("&", "&amp;"), NEWLINE("\n", "<br />");

    final String symbol;
    final String output;

    Character(String symbol, String output) {
        this.symbol = symbol;
        this.output = output;
    }
}