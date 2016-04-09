package by.mrstark.newstutby.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by mrstark on 6.4.16.
 */
@Root(name = "item", strict = false )
public class Item implements Serializable {
    @Element(name = "title")
    private String title;

    @Element(data = true, name = "description")
    private String description;

    @Element(name = "enclosure")
    private Enclosure url;

    @Element(name = "pubDate")
    private String pubDate;

    private String e_url;

    @Root(strict = false)
    public static class Enclosure {
        @Attribute(name = "url")
        private String url;

        public String getUrl() {
            return url;
        }
    }

    public Item() {
    }

    public Item(String title, String description, String pubDate, String e_url) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.e_url = getUrl().getUrl();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Enclosure getUrl() {
        return url;
    }

    public String getPubDate() {
        return pubDate;
    }
}