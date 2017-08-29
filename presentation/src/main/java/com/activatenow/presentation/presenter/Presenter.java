package com.activatenow.presentation.presenter;

import com.activatenow.presentation.view.BaseView;

public interface Presenter {

    void initWithView(BaseView view);
    void resume();
    void pause();
    void destroy();

}
