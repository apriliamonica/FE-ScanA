package com.example.handscanattendance.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u000bH\'J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\'J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00a2\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\u001e\u001a\u00020\fH\'J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\u001a\u001a\u00020!H\u00a7@\u00a2\u0006\u0002\u0010\"\u00a8\u0006#"}, d2 = {"Lcom/example/handscanattendance/network/ApiService;", "", "addMahasiswa", "Lretrofit2/Response;", "Lcom/example/handscanattendance/data/model/MahasiswaModel;", "mahasiswa", "(Lcom/example/handscanattendance/data/model/MahasiswaModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMahasiswa", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMataKuliah", "Lretrofit2/Call;", "Lcom/example/handscanattendance/data/model/MataKuliah;", "hapusMahasiswa", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hapusMataKuliah", "Lcom/example/handscanattendance/data/model/MataKuliahResponse;", "login", "Lcom/example/handscanattendance/data/model/LoginResponse;", "credentials", "Lcom/example/handscanattendance/data/model/LoginCredentials;", "(Lcom/example/handscanattendance/data/model/LoginCredentials;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Lcom/example/handscanattendance/data/model/RegisterResponse;", "request", "Lcom/example/handscanattendance/data/model/RegisterRequest;", "(Lcom/example/handscanattendance/data/model/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tambahMataKuliah", "mataKuliah", "uploadPresensi", "Lcom/example/handscanattendance/data/model/UploadPresensiResponse;", "Lcom/example/handscanattendance/data/model/UploadPresensiRequest;", "(Lcom/example/handscanattendance/data/model/UploadPresensiRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.handscanattendance.data.model.LoginCredentials credentials, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.handscanattendance.data.model.LoginResponse>> $completion);
    
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.handscanattendance.data.model.RegisterRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.handscanattendance.data.model.RegisterResponse>> $completion);
    
    @retrofit2.http.POST(value = "mahasiswa")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addMahasiswa(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.handscanattendance.data.model.MahasiswaModel mahasiswa, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.handscanattendance.data.model.MahasiswaModel>> $completion);
    
    @retrofit2.http.GET(value = "mahasiswa")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMahasiswa(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.handscanattendance.data.model.MahasiswaModel>> $completion);
    
    @retrofit2.http.DELETE(value = "mahasiswa/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object hapusMahasiswa(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.handscanattendance.data.model.MahasiswaModel>> $completion);
    
    @retrofit2.http.POST(value = "upload-presensi")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uploadPresensi(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.handscanattendance.data.model.UploadPresensiRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.handscanattendance.data.model.UploadPresensiResponse>> $completion);
    
    @retrofit2.http.GET(value = "mata_kuliah")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<java.util.List<com.example.handscanattendance.data.model.MataKuliah>> getMataKuliah();
    
    @retrofit2.http.POST(value = "mata_kuliah")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<com.example.handscanattendance.data.model.MataKuliah> tambahMataKuliah(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.handscanattendance.data.model.MataKuliah mataKuliah);
    
    @retrofit2.http.DELETE(value = "mata_kuliah/{id}")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<com.example.handscanattendance.data.model.MataKuliahResponse> hapusMataKuliah(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id);
}