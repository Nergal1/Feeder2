package com.feeder.android.base;

import android.content.Context;

import com.feeder.model.Article;

import java.util.List;

/**
 * @description:
 * @author: Match
 * @date: 10/25/16
 */

public abstract class IArticlesView extends MVPView {
    protected ArticleViewObserver mObserver;

    public IArticlesView(Context context) {
        super(context);
    }

    public abstract void setDataSource(List<Article> articleList);

    public void setObserver(ArticleViewObserver observer) {
        mObserver = observer;
    }
}
