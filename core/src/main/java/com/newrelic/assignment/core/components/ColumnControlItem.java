package com.newrelic.assignment.core.components;

public class ColumnControlItem {
    private String styleClass;
    private String columnName;

    public ColumnControlItem(String styleClass, String columnName, String horizontalPadding, String verticalPadding) {
        String horizontalPaddingStyle = horizontalPadding + "-horizontal-padding";
        String verticalPaddingStyle   = verticalPadding + "-vertical-padding";

        this.styleClass = String.format("%s %s %s %s", styleClass, columnName, horizontalPaddingStyle, verticalPaddingStyle);
        this.columnName = columnName;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public String getColumnName() {
        return columnName;
    }

    public String toString(){
        return "Column Name: " + getColumnName() + " StyleClass: " + getStyleClass();
    }
}
