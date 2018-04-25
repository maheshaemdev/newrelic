package com.newrelic.assignment.core.components;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;


public class Container extends WCMUsePojo {

    private String backgroundImagePath;
    private String backgroundColorCls;
    private String verticalPaddingStyle;
    private String verticalAlignmentCls;


    @Override
    public void activate() throws Exception {
        backgroundImagePath = (String) getProperties().get("backgroundImage");
        backgroundColorCls = (String) getProperties().get("backgroundColor");

        String verticalPadding = getProperties().get("verticalPadding", "no");
        verticalPaddingStyle   = verticalPadding + "-vertical-padding";

        String verticalAlignment = getProperties().get("verticalAlignment", "none");
        if(!verticalAlignment.equalsIgnoreCase("none"))
            verticalAlignmentCls = verticalAlignment + "-vertical-align";
    }

    public String getBackgroundImagePath() { return backgroundImagePath; }

    public String getBackgroundColorCls() { return backgroundColorCls; }

    public String getverticalAlignmentCls() { return verticalAlignmentCls; }

    public String getVerticalPaddingStyle() { return verticalPaddingStyle; }
}
