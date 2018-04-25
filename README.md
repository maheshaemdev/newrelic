## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

If you have a running AEM instance you can build and package the whole project and deploy into AEM Author with

    mvn clean install -PautoInstallPackage

Or to deploy it to a publish instance, run

    mvn clean install -PautoInstallPackagePublish

## Components Location

I have added a page to the code base, Once you deploy the code with above mentioned maven command and navigate to the the page "/content/newrelic/en/newrelic-assignment.html?wcmmode=disabled" you should be able to see both MarqeeeL and Product Combinator component's.

Instead of creating two seperate components i have authored the above two components using my reusable custom components[Container, Column-Control, CTA, Tabs] and some out of the box aem components[Title, Image].

## MarqueeL Component Assembly:

* .Container Component
    * .Column-Container Component
        * .Column-1
            * .Image Component
            * .Title Component
            * .CTA Component
        * .Column-2
            * .Image Component

## Product Combinator Component

* .Container Component
    * .Column-Container Component
        * .Column-1
            * .Title Component
        * .Column-2
            * .Tabs Component
