package com.example.myworld;

import android.annotation.SuppressLint;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhuqianglong@bigo.sg on 2020/6/10
 * Description: 测试RxJava相关
 *
 * 从下往上是订阅流
 * 从上往下是数据流
 */

public class TestRxJava {

    public static void love() {
        Observable
                .create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                        Log.d("wyz", "create:" + Thread.currentThread().getName());
                        e.onNext(1);
                    }
                })
                .subscribeOn(Schedulers.io())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        Log.d("wyz", "map1:" + Thread.currentThread().getName());
                        return integer;
                    }
                })
//                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        Log.d("wyz", "doOnSubscribe1:" + Thread.currentThread().getName());
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        Log.d("wyz", "doOnSubscribe2:" + Thread.currentThread().getName());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(new Function<Integer, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Integer integer) throws Exception {
                        Log.d("wyz", "flatMap:" + Thread.currentThread().getName());
                        return Observable.fromArray(integer);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.d("wyz", "执行完毕:" + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @SuppressLint("CheckResult")
    public static void testMap() {
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("c");
        System.out.println("1对1:[b, a, c]-->[b, a, c]");
        //1对1
        Observable.just(list)
                .flatMap(
                        new Function<List<String>, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(List<String> s) throws Exception {
//                                System.out.println("map--1----" + s);
                                return Observable.fromArray(s);
                            }
                        })
                .subscribe(s -> {
                    System.out.println(s);
                });
        System.out.println("1对多:[b, a, c]-->b, a, c");
        //1对多
        Observable.just(list)
                .flatMap(
                        new Function<List<String>, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(List<String> s) throws Exception {
//                                System.out.println("map--1----" + s);
                                return Observable.fromIterable(s);
                            }
                        })
                .subscribe(s -> {
                    System.out.println(s);
                });

        //多对多
        System.out.println("多对多:a, b, c-->a, c");
        Observable.just("a", "b", "c")
                .flatMap(
                        new Function<String, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(String s) throws Exception {
//                                System.out.println("map--1----" + s);
                                if (s.equalsIgnoreCase("b")) return Observable.empty();
                                return Observable.just(s);
                            }
                        })
                .subscribe(s -> {
                    System.out.println(s);
                });

        //多对多
        System.out.println("多对多:a, b, c-->a,b,c,d");
        Observable.just("a", "b", "c")
                .flatMap(
                        new Function<String, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(String s) throws Exception {
//                                System.out.println("map--1----" + s);
                                if (s.equalsIgnoreCase("c")) return Observable.just("c", "d");
                                return Observable.just(s);
                            }
                        })
                .subscribe(s -> {
                    System.out.println(s);
                });
        System.out.println("map 一对一:[b, a, c]-->[b, a, c]");
        Observable.just(list)
                .map(new Function<List<String>, List<String>>() {
                    @Override
                    public List<String> apply(List<String> strings) throws Exception {
                        return strings;
                    }
                })
                .subscribe(s -> {
                    System.out.println(s);
                });

    }
}
