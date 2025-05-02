package com.example.handscanattendance.ui.auth;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\"\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0012\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/example/handscanattendance/ui/auth/RegisterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnRegister", "Landroid/widget/Button;", "btnUploadLeftPalm", "btnUploadRightPalm", "etConfirmPassword", "Landroid/widget/EditText;", "etEmail", "etNIM", "etNama", "etPassword", "etPhone", "leftPalmBitmap", "Landroid/graphics/Bitmap;", "rightPalmBitmap", "spinnerKelas", "Landroid/widget/Spinner;", "tvLoginRedirect", "Landroid/widget/TextView;", "convertBitmapToBase64", "", "bitmap", "initViews", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openCamera", "setupListeners", "Companion", "app_debug"})
public final class RegisterActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.EditText etNIM;
    private android.widget.EditText etNama;
    private android.widget.EditText etPhone;
    private android.widget.EditText etEmail;
    private android.widget.Spinner spinnerKelas;
    private android.widget.EditText etPassword;
    private android.widget.EditText etConfirmPassword;
    private android.widget.Button btnRegister;
    private android.widget.TextView tvLoginRedirect;
    private android.widget.Button btnUploadRightPalm;
    private android.widget.Button btnUploadLeftPalm;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap rightPalmBitmap;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap leftPalmBitmap;
    private static final int CAMERA_REQUEST_CODE_LEFT = 101;
    private static final int CAMERA_REQUEST_CODE_RIGHT = 102;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.handscanattendance.ui.auth.RegisterActivity.Companion Companion = null;
    
    public RegisterActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setupListeners() {
    }
    
    private final java.lang.String convertBitmapToBase64(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final void openCamera(int requestCode) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/handscanattendance/ui/auth/RegisterActivity$Companion;", "", "()V", "CAMERA_REQUEST_CODE_LEFT", "", "CAMERA_REQUEST_CODE_RIGHT", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}