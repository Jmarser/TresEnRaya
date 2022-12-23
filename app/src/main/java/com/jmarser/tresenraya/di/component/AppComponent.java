package com.jmarser.tresenraya.di.component;

import com.jmarser.tresenraya.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    //TODO Vistas que serán inyectadas

}
