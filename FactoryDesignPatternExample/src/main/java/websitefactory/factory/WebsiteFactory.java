package websitefactory.factory;

import websitefactory.abstractions.Website;
import websitefactory.sitetypes.Blog;
import websitefactory.sitetypes.Shop;

public class WebsiteFactory {

//    public enum WebsiteType{
//        BLOG, SHOP;
//    }

    //as of Java 7, you can do a switch statement on a String -- before
    // it was only compatible with boolean, char, int, and short
    public static Website getWebsite(String siteType) {
        switch (siteType) {
            case "blog": {
                return new Blog();
            }
            case "shop": {
                return new Shop();
            }
            default: {
                return null;
            }
        }
    }



}
