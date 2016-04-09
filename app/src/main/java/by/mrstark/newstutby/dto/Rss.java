package by.mrstark.newstutby.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by mrstark on 9.4.16.
 */
@Root(name = "rss", strict = false)
public class Rss implements Serializable {
    @Element(name = "channel")
    private Channel channel;

    public Rss() {
    }

    public Rss(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }
}
