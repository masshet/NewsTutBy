package by.mrstark.newstutby.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mrstark on 7.4.16.
 */
@Root(name = "channel", strict = false)
public class Channel implements Serializable {
    @Element(name = "title")
    private String title;
    @ElementList(inline = true, name = "item")
    private List<Item> items;

    public Channel() {
    }

    public Channel(String title, List<Item> items) {
        this.title = title;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public List<Item> getItems() {
        return items;
    }
}
