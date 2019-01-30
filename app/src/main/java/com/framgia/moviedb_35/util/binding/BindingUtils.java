package com.framgia.moviedb_35.util.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.framgia.moviedb_35.R;
import com.framgia.moviedb_35.data.model.Actor;
import com.framgia.moviedb_35.data.model.Company;
import com.framgia.moviedb_35.data.model.Genre;
import com.framgia.moviedb_35.data.model.Movie;
import com.framgia.moviedb_35.screen.detail.adapter.CharacterAdapter;
import com.framgia.moviedb_35.screen.detail.adapter.ProductionAdapter;
import com.framgia.moviedb_35.screen.genres.GenresAdapter;
import com.framgia.moviedb_35.screen.home.CategoriesAdapter;
import com.framgia.moviedb_35.util.StringUtils;

import java.util.List;

public class BindingUtils {
    private static final int IMAGE_SIZE_200 = 1280;

    @BindingAdapter({"app:bindMovies"})
    public static void setMoviesForRecyclerView(RecyclerView recyclerView,
                                                List<Movie> movies) {
        CategoriesAdapter adapter = (CategoriesAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.replaceData(movies);
        }
    }

    @BindingAdapter({"app:bindActors"})
    public static void setActorsForRecyclerView(RecyclerView recyclerView,
                                                List<Actor> actors) {
        CharacterAdapter adapter = (CharacterAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.replaceData(actors);
        }
    }

    @BindingAdapter({"app:bindProductions"})
    public static void setCompanyForRecyclerView(RecyclerView recyclerView,
                                                 List<Company> companies) {
        ProductionAdapter adapter = (ProductionAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.replaceData(companies);
        }
    }

    @BindingAdapter("app:imageUrl")
    public static void setImage(ImageView imageView, String url) {
        if (url == null || url.isEmpty()) {
            imageView.setImageResource(R.drawable.ic_loading);
        }
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_loading);
        requestOptions.error(R.drawable.ic_loading);
        String imageLink = StringUtils.getImageUrl(IMAGE_SIZE_200, url);
        Glide.with(imageView.getContext())
                .load(imageLink)
                .apply(requestOptions)
                .into(imageView);
    }

    @BindingAdapter("app:bindGenres")
    public static void setGenresForRecyclerView(RecyclerView recyclerView, List<Genre> genres) {
        GenresAdapter adapter = (GenresAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.replaceData(genres);
        }
    }

    @BindingAdapter("bindImageGenre")
    public static void setImageGenre(ImageView imageView, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_loading);
        requestOptions.error(R.drawable.ic_loading);
        Glide.with(imageView.getContext())
                .load(position)
                .apply(requestOptions)
                .into(imageView);
    }
}
