package com.doit.networklibrary;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0017\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/doit/networklibrary/MultiStateObserver;", "T", "Landroidx/lifecycle/Observer;", "Lcom/doit/networklibrary/BaseResponse;", "()V", "onChanged", "", "t", "onDataChange", "data", "(Ljava/lang/Object;)V", "onFailed", "networklibrary_debug"})
public class MultiStateObserver<T extends java.lang.Object> implements androidx.lifecycle.Observer<com.doit.networklibrary.BaseResponse<T>> {
    
    @java.lang.Override()
    public void onChanged(@org.jetbrains.annotations.Nullable()
    com.doit.networklibrary.BaseResponse<T> t) {
    }
    
    /**
     * 请求数据且数据不为空
     */
    public void onDataChange(@org.jetbrains.annotations.Nullable()
    T data) {
    }
    
    public void onFailed() {
    }
    
    public MultiStateObserver() {
        super();
    }
}