package com.activatenow.presentation;

import com.activatenow.presentation.dependency.ActivityScope;
import com.activatenow.presentation.dependency.component.ApplicationComponent;
import com.activatenow.presentation.dependency.component.ViewInjector;

import dagger.Component;

@ActivityScope
@Component(modules = TestMockerModule.class, dependencies = ApplicationComponent.class)
public interface TestMockerComponent extends ViewInjector {}
