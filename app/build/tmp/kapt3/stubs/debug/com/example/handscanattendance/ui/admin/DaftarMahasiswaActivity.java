package com.example.handscanattendance.ui.admin;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/handscanattendance/ui/admin/DaftarMahasiswaActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnCari", "Landroid/widget/Button;", "btnTambahData", "etSearchNama", "Landroid/widget/EditText;", "filteredMahasiswa", "", "Lcom/example/handscanattendance/data/model/MahasiswaModel;", "listMahasiswa", "mahasiswaAdapter", "Lcom/example/handscanattendance/ui/admin/MahasiswaAdapter;", "rvMahasiswa", "Landroidx/recyclerview/widget/RecyclerView;", "spinnerMk", "Landroid/widget/Spinner;", "filterMahasiswa", "", "initViews", "loadMahasiswa", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupListeners", "setupRecyclerView", "setupSpinner", "showDeleteDialog", "mahasiswa", "showTambahMahasiswaDialog", "app_debug"})
public final class DaftarMahasiswaActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.Spinner spinnerMk;
    private android.widget.EditText etSearchNama;
    private android.widget.Button btnCari;
    private android.widget.Button btnTambahData;
    private androidx.recyclerview.widget.RecyclerView rvMahasiswa;
    private com.example.handscanattendance.ui.admin.MahasiswaAdapter mahasiswaAdapter;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.handscanattendance.data.model.MahasiswaModel> listMahasiswa;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.handscanattendance.data.model.MahasiswaModel> filteredMahasiswa;
    
    public DaftarMahasiswaActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setupSpinner() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupListeners() {
    }
    
    private final void loadMahasiswa() {
    }
    
    private final void filterMahasiswa() {
    }
    
    private final void showDeleteDialog(com.example.handscanattendance.data.model.MahasiswaModel mahasiswa) {
    }
    
    private final void showTambahMahasiswaDialog() {
    }
}