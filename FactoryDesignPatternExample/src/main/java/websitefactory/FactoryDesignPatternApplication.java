package websitefactory;

import websitefactory.abstractions.Website;
import websitefactory.factory.WebsiteFactory;

public class FactoryDesignPatternApplication {

    public static void main(String[] args) {

      Website blog =  WebsiteFactory.getWebsite("blog");

        System.out.println(blog.getPages());
    }
}
