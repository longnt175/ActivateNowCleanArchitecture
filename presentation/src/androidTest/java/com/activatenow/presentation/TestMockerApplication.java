package com.activatenow.presentation;

import com.activatenow.presentation.dependency.component.ViewInjector;

public class TestMockerApplication extends BaseApplication {

    @Override
    public ViewInjector getViewInjector() {
        return DaggerTestMockerComponent.builder()
                .applicationComponent(this.applicationComponent)
                .testMockerModule(new TestMockerModule()).build();
    }
}
