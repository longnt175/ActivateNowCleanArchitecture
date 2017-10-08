package com.activatenow.data.net.interceptor;

import com.activatenow.data.net.RestApi;
import com.activatenow.data.repository.SessionDataRepository;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class HttpInterceptor implements Interceptor {
    @Inject
    SessionDataRepository sessionDataRepository;

    @Inject
    public HttpInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
//                .addHeader("Authorization", "Bearer " + sessionDataRepository.getCurrentUser())
                .addHeader("Accept", RestApi.ACCEPT)
//                .addHeader("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24)
                .addHeader("Cache-Control", String.format("max-age=%d, only-if-cached, " +
                        "max-stale=%d", 60*4, 0))
                .build();
        return chain.proceed(request);
    }

//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request().newBuilder()
//                .addHeader("Accept-Language", Locale.getDefault().getLanguage())
//                .addHeader("Accept", RestApi.VERSION_HEADER)
//                .build();
//        return chain.proceed(request);
//    }

}
