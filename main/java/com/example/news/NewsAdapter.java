package com.example.news;

import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context  of the app
     * @param newsList is the list of new article, which is the data source of the adapter
     */
    public NewsAdapter(Activity context, ArrayList<News> newsList) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, newsList);
    }

    /**
     * Returns a list item view that displays information about the news
     * in the list of news.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }
        News currentNews = getItem(position);

        TextView articleTitleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        articleTitleTextView.setText(currentNews.getArticleTitle());

        // Display the images of the authors
        ImageView articleImageView = (ImageView) listItemView.findViewById(R.id.img);
        //imported glide file
        Glide.with(getContext()).load(currentNews.getArticleImg()).into(articleImageView);

        TextView articleAuthorTextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        // Display the author name of the current news in that TextView
        if (currentNews.getArticleAuthor() != "") {
            articleAuthorTextView.setText(currentNews.getArticleAuthor());

            //Set author name view as visible
            articleAuthorTextView.setVisibility(View.VISIBLE);
        } else {
            //Set author name view as gone
            articleAuthorTextView.setVisibility(View.GONE);
        }

        TextView dateView = null;
        if (currentNews.getArticleDate() != null) {
            dateView = listItemView.findViewById(R.id.date_text_view);
            // Format the date string (i.e. "May 5, 2000")
            String formattedDate = formatDate(currentNews.getArticleDate());
            // Display the date of the current news in that TextView
            dateView.setText(formattedDate);

            //Set date views as visible
            dateView.setVisibility(View.VISIBLE);
        } else {
            //Set date views as gone
            dateView.setVisibility(View.GONE);
        }

        TextView articleCategoryTextView = (TextView) listItemView.findViewById(R.id.category_text_view);
        articleCategoryTextView.setText("Category: "+currentNews.getArticleCategory());

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "May 5, 2000") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
}
