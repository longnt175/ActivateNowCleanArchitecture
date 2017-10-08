package com.activatenow.presentation.dependency.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.activatenow.data.net.RestApi;
import com.activatenow.data.net.interceptor.HttpInterceptor;
import com.activatenow.data.repository.SessionDataRepository;
import com.activatenow.data.repository.UserDataRepository;
import com.activatenow.domain.repository.SessionRepository;
import com.activatenow.domain.repository.UserRepository;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;


@Module
public class DataModule {
    private static final String CACHE_DIR = "activate_cache";

    @Provides
    @Singleton
    SessionRepository provideSessionRepository(SharedPreferences sharedPreferences) {
        return new SessionDataRepository(sharedPreferences);
    }

    @Provides
    @Singleton
    RestApi provideRestApi(Context context, HttpLoggingInterceptor httpLoggingInterceptor) {
        File httpCacheDirectory = new File(context.getCacheDir(), CACHE_DIR);
        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new HttpInterceptor())
                .addInterceptor(httpLoggingInterceptor)
                .build();
        GsonConverterFactory factory =
                GsonConverterFactory.create(new GsonBuilder()
                .setDateFormat("dd-MM-yyyy")
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create());
        return new Retrofit.Builder()
                .baseUrl(RestApi.URL_BASE)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build().create(RestApi.class);
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(RestApi restApi) {
        return new UserDataRepository(restApi);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> Timber.d(message));
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


}
