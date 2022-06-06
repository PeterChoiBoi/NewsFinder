package com.example.news;

import java.util.Date;

public class News {
    private String mArticleUrl;
    private String mArticleTitle;
    private String mArticleAuthor;
    private Date mArticleDate;
    private String mArticleCategory;
    private String mArticleImg;

    public News(String articleTitle, String articleAuthor, Date articleDate,String articleCategory, String articleUrl, String articleImage) {
        mArticleAuthor = articleAuthor;
        mArticleTitle = articleTitle;
        mArticleDate = articleDate;
        mArticleUrl = articleUrl;
        mArticleCategory = articleCategory;
        mArticleImg = articleImage;
    }

    /**
     * Returns the Author of the News.
     */
    public String getArticleAuthor() {
        return mArticleAuthor;
    }

    /**
     * Returns the Title of the News.
     */
    public String getArticleTitle() {
        return mArticleTitle;
    }

    /**
     * Returns the Date of the News.
     * @return
     */
    public Date getArticleDate() {
        return mArticleDate;
    }

    /**
     * Returns the URL of the News.
     */
    public String getUrl() {
        return mArticleUrl;
    }

    /**
     * Returns the Category of the News.
     */
    public String getArticleCategory() {
        return mArticleCategory;
    }

    /**
     * Returns the Image of the News.
     */
    public String getArticleImg() {
        return mArticleImg;
    }
}
