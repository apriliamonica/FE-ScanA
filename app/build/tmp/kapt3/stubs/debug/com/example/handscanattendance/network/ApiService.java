package com.example.handscanattendance.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\'J\u001b\u0010\u0014\u001a\u00020\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/example/handscanattendance/network/ApiService;", "", "getMataKuliah", "", "MataKuliah", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hapusMataKuliah", "Lcom/example/handscanattendance/model/MataKuliahResponse;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lretrofit2/Call;", "Lcom/example/handscanattendance/model/LoginResponse;", "credentials", "Lcom/example/handscanattendance/model/LoginCredentials;", "register", "Lcom/example/handscanattendance/model/RegisterResponse;", "request", "Lcom/example/handscanattendance/model/RegisterRequest;", "tambahMataKuliah", "mataKuliah", "Lcom/example/handscanattendance/model/MataKuliahRequest;", "(Lcom/example/handscanattendance/model/MataKuliahRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "login")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.example.handscanattendance.model.LoginResponse> login(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.handscanattendance.model.LoginCredentials credentials);
    
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.example.handscanattendance.model.RegisterResponse> register(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.handscanattendance.model.RegisterRequest request);
    
    @retrofit2.http.GET(value = "mata-kuliah")
    @org.jetbrains.annotations.Nullable
    public abstract <MataKuliah extends java.lang.Object>java.lang.Object getMataKuliah(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<? extends MataKuliah>> $completion);
    
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