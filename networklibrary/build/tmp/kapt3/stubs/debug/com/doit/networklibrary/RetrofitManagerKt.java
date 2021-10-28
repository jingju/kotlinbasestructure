package com.doit.networklibrary;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00040\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"TAG", "", "request", "", "T", "Lcom/doit/networklibrary/RetrofitManager;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/doit/networklibrary/BaseResponse;", "", "stateLiveData", "Lcom/doit/networklibrary/StateLiveData;", "(Lcom/doit/networklibrary/RetrofitManager;Lkotlin/jvm/functions/Function1;Lcom/doit/networklibrary/StateLiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "networklibrary_debug"})
public final class RetrofitManagerKt {
    private static final java.lang.String TAG = "RetrofitManager";
    
    /**
     * todo 通过扩展函数封装到这里
     * todo zans
     * 1、根据不同app的errorCode做特殊处理的接口
     * 2、写一个结果转换器，做成不同状态的回调的显示，可以用扩展函数和map
     */
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>java.lang.Object request(@org.jetbrains.annotations.NotNull()
    com.doit.networklibrary.RetrofitManager $this$request, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.doit.networklibrary.BaseResponse<T>>, ? extends java.lang.Object> block, @org.jetbrains.annotations.NotNull()
    com.doit.networklibrary.StateLiveData<T> stateLiveData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
}