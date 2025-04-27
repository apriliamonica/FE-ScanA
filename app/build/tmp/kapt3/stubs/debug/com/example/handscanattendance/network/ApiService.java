package com.example.handscanattendance.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/example/handscanattendance/network/ApiService;", "", "getMataKuliah", "", "Lcom/example/handscanattendance/model/MataKuliahResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hapusMataKuliah", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/example/handscanattendance/model/LoginResponse;", "credentials", "Lcom/example/handscanattendance/model/LoginCredentials;", "(Lcom/example/handscanattendance/model/LoginCredentials;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Lcom/example/handscanattendance/model/RegisterResponse;", "request", "Lcom/example/handscanattendance/model/RegisterRequest;", "(Lcom/example/handscanattendance/model/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tambahMataKuliah", "mataKuliah", "Lcom/example/handscanattendance/model/MataKuliahRequest;", "(Lcom/example/handscanattendance/model/MataKuliahRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "login")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object login(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.handscanattendance.model.LoginCredentials credentials, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.handscanattendance.model.LoginResponse> $completion);
    
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object register(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.handscanattendance.model.RegisterRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.handscanattendance.model.RegisterResponse> $completion);
    
    @retrofit2.http.GET(value = "mata-kuliah")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMataKuliah(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.handscanattendance.model.MataKuliahResponse>> $completion);
    
    @retrofit2.http.POST(value = "mata-kuliah")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object tambahMataKuliah(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.handscanattendance.model.MataKuliahRequest mataKuliah, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.handscanattendance.model.MataKuliahResponse> $completion);
    
    @retrofit2.http.DELETE(value = "mata-kuliah/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object hapusMataKuliah(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.handscanattendance.model.MataKuliahResponse> $completion);
}