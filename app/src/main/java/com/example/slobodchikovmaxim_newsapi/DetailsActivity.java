package com.example.slobodchikovmaxim_newsapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.slobodchikovmaxim_newsapi.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadlines headlines;
    TextView txt_title, txt_author, txt_time, txt_detail, txt_content;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Enable the back button in the ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Initialize TextViews and ImageView
        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_time = findViewById(R.id.text_detail_time);
        txt_detail = findViewById(R.id.text_detail_detail);
        txt_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news); // Ensure this ID matches your layout

        // Get NewsHeadlines object
        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        // Populate views with data, checking for nulls
        if (headlines != null) {
            txt_title.setText(headlines.getTitle() != null ? headlines.getTitle() : "");
            txt_author.setText(headlines.getAuthor() != null ? headlines.getAuthor() : "");
            txt_time.setText(headlines.getPublishedAt() != null ? headlines.getPublishedAt() : "");
            txt_detail.setText(headlines.getDescription() != null ? headlines.getDescription() : "");
            txt_content.setText(headlines.getContent() != null ? headlines.getContent() : "");

            if (headlines.getUrlToImage() != null && !headlines.getUrlToImage().isEmpty()) {
                Picasso.get().load(headlines.getUrlToImage()).into(img_news);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the action bar item clicks
        if (item.getItemId() == android.R.id.home) {
            // Respond to the action bar's Up/Home button
            finish(); // Close this activity and return to the previous activity (if there is one)
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
