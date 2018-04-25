package com.newrelic.assignment.core.components;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.commons.lang3.StringUtils;

public class CTA extends WCMUsePojo {
    private String ctaPosition;
    private String firstCtaText;
    private String firstCtaButtonType;
    private String firstCtaUrl;
    private String firstCtaNewtab;
    private String secondCtaText;
    private String secondCtaButtonType;
    private String secondCtaUrl;
    private String secondCtaNewtab;

    @Override
    public void activate() throws Exception {
        ctaPosition = getProperties().get("ctaPosition", "");
        firstCtaText = getProperties().get("firstCtaText", "");
        firstCtaButtonType = getProperties().get("firstCtaButtonType", "");
        firstCtaUrl = getProperties().get("firstCtaUrl", "");
        firstCtaNewtab = getProperties().get("firstCtaNewtab", "");
        secondCtaText = getProperties().get("secondCtaText", "");
        secondCtaButtonType = getProperties().get("secondCtaButtonType", "");
        secondCtaUrl = getProperties().get("secondCtaUrl", "");
        secondCtaNewtab = getProperties().get("secondCtaNewtab", "");

        firstCtaUrl = getFormattedLink(firstCtaUrl);
        secondCtaUrl = getFormattedLink(secondCtaUrl);
    }

    public static String getFormattedLink(String link) {
        String result = link;
        if (StringUtils.isNotBlank(result)) {
            if (isInternalUrl(link) && !link.contains("/content/dam")) {
                result += ".html";
            }
        }
        return result;
    }

    public static boolean isInternalUrl(String link) {
        return (link != null && link.startsWith("/") && !link.endsWith(".htm"));
    }

    public String getCtaPosition() {
        return ctaPosition;
    }

    public String getFirstCtaText() {
        return firstCtaText;
    }

    public String getFirstCtaButtonType() {
        return firstCtaButtonType;
    }

    public String getFirstCtaUrl() {
        return firstCtaUrl;
    }

    public String getFirstCtaNewtab() {
        return firstCtaNewtab;
    }

    public String getSecondCtaText() {
        return secondCtaText;
    }

    public String getSecondCtaButtonType() {
        return secondCtaButtonType;
    }

    public String getSecondCtaUrl() {
        return secondCtaUrl;
    }

    public String getSecondCtaNewtab() {
        return secondCtaNewtab;
    }
}

