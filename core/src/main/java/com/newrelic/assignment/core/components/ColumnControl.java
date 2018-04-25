package com.newrelic.assignment.core.components;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;


public class ColumnControl extends WCMUsePojo {

    private List<ColumnControlItem> columnControlItems;
    private String verticalPadding;
    private String horizontalPadding;
    private String backgroundStyle;
    private String[] paddingOptions = {"no", "small", "medium", "large"};
    private String columnLayout;
    private String removeVerticalPadding;

    @Override
    public void activate() throws Exception {
        String backgroundImagePath = (String) getProperties().get("backgroundImage");
        String backgroundOpacity = (String) getProperties().get("backgroundOpacity");
        String backgroundColor = (String) getProperties().get("backgroundColor");

        columnLayout = getProperties().get("columnLayout", "");
        horizontalPadding = getProperties().get("horizontalPadding", "no");
        verticalPadding = getProperties().get("verticalPadding", "no");
        removeVerticalPadding = getProperties().get("removeVerticalPadding", "");

        if (!hasCorrectPaddingValue(horizontalPadding)) {
            horizontalPadding = "no";
        }

        if (!hasCorrectPaddingValue(verticalPadding)) {
            verticalPadding = "no";
        }

        columnControlItems = getColumnLayoutItems(columnLayout);
        backgroundStyle = getBackgroundStyleOptions(backgroundColor, backgroundOpacity, backgroundImagePath);
    }

    protected List<ColumnControlItem> getColumnLayoutItems(String columnLayout) {
        List<ColumnControlItem> items = new ArrayList<>();
        switch (columnLayout) {
            case "one-column":
                items.add(new ColumnControlItem("col-sm-12", "column-1", horizontalPadding, verticalPadding));
                break;
            case "two-columns":
                items.add(new ColumnControlItem("col-sm-6", "column-1", horizontalPadding, verticalPadding));
                items.add(new ColumnControlItem("col-sm-6", "column-2", horizontalPadding, verticalPadding));
                break;
            case "two-columns-40-60":
                items.add(new ColumnControlItem("col-sm-5", "column-1", horizontalPadding, verticalPadding));
                items.add(new ColumnControlItem("col-sm-7", "column-2", horizontalPadding, verticalPadding));
                break;
            case "two-columns-60-40":
                items.add(new ColumnControlItem("col-sm-7", "column-1", horizontalPadding, verticalPadding));
                items.add(new ColumnControlItem("col-sm-5", "column-2", horizontalPadding, verticalPadding));
                break;
            case "two-columns-33-66":
                items.add(new ColumnControlItem("col-sm-4", "column-1", horizontalPadding, verticalPadding));
                items.add(new ColumnControlItem("col-sm-8", "column-2", horizontalPadding, verticalPadding));
                break;
            case "two-columns-66-33":
                items.add(new ColumnControlItem("col-sm-8", "column-1", horizontalPadding, verticalPadding));
                items.add(new ColumnControlItem("col-sm-4", "column-2", horizontalPadding, verticalPadding));
                break;
            case "three-columns":
                items.add(new ColumnControlItem("col-sm-4", "column-1", horizontalPadding, verticalPadding));
                items.add(new ColumnControlItem("col-sm-4", "column-2", horizontalPadding, verticalPadding));
                items.add(new ColumnControlItem("col-sm-4", "column-3", horizontalPadding, verticalPadding));
                break;
            case "four-columns":
                items.add(new ColumnControlItem("col-sm-3", "column-1", horizontalPadding, verticalPadding));
                items.add(new ColumnControlItem("col-sm-3", "column-2", horizontalPadding, verticalPadding));
                items.add(new ColumnControlItem("col-sm-3", "column-3", horizontalPadding, verticalPadding));
                items.add(new ColumnControlItem("col-sm-3", "column-4", horizontalPadding, verticalPadding));
                break;
        }
        return items;
    }

    protected String getBackgroundStyleOptions(String backgroundColor, String backgroundOpacity, String backgroundImagePath) {
        Formatter formatter = new Formatter(new StringBuilder());
        if (backgroundImagePath == null) {
            backgroundImagePath = "";
        }

        String color = getColorGradientOption(backgroundColor, backgroundOpacity);
        formatter.format("background: linear-gradient(to bottom, %s 0%%, %s 100%%), url('%s'); ", color, color, backgroundImagePath);
        formatter.format("background-size: cover; background-position: 50%% 50%%; background-repeat: no-repeat;");
        return formatter.toString();
    }

    private String getColorGradientOption(String color, String gradient) {
        Formatter formatter = new Formatter(new StringBuilder());
        if (StringUtils.isNotEmpty(color)) {
            formatter.format("rgba(%s, %s)", color, gradient);
        }
        return formatter.toString();
    }

    private Boolean hasCorrectPaddingValue(String value) {
        return Arrays.asList(paddingOptions).contains(value);
    }

    public List<ColumnControlItem> getColumnControlItems() {
        return columnControlItems;
    }

    public String getBackgroundStyle() {
        return backgroundStyle;
    }

    public String getColumnLayout() { return columnLayout; }

    public String getRemoveVerticalPadding() { return removeVerticalPadding; }
}
