package com.activatenow.presentation.dependency.component;

import com.activatenow.presentation.dependency.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent extends FragmentInjector {}
