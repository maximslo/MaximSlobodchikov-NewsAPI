package com.example.slobodchikovmaxim_newsapi;
import com.example.slobodchikovmaxim_newsapi.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String message);

}
