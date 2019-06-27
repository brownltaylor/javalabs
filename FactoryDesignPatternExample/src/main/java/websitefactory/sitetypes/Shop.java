package websitefactory.sitetypes;

import websitefactory.abstractions.Website;
import websitefactory.pages.CartPage;
import websitefactory.pages.ItemPage;
import websitefactory.pages.SearchPage;

public class Shop extends Website {

    @Override
    public void createWebsite(){
        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());

    }
}
