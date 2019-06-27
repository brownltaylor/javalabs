package websitefactory.sitetypes;

import websitefactory.abstractions.Website;
import websitefactory.pages.AboutPage;
import websitefactory.pages.CommentPage;
import websitefactory.pages.ContactPage;
import websitefactory.pages.PostPage;

public class Blog extends Website {

    @Override
    public void createWebsite(){
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    }

    @Override
    public String toString() {
        return "Blog{}";
    }
}
