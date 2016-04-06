package by.mrstark.newstutby.dto;

/**
 * Created by mrstark on 6.4.16.
 */
public class NewsDTO {

    private String title;

    public NewsDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
