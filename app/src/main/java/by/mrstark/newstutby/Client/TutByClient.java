package by.mrstark.newstutby.Client;

import by.mrstark.newstutby.dto.Rss;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by mrstark on 7.4.16.
 */
public interface TutByClient {

    @GET("/rss/")
    void getItems(Callback<Rss> callback);
}
