package com.example.monopoly.transaction;

public enum TransactionType {
    INCOME("income"),
    SPENDING("spending")
    ;

    private final String text;

    /**
     * @param text
     */
    TransactionType(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
