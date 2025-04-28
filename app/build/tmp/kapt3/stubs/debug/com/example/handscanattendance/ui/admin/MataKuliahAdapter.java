package com.example.handscanattendance.ui.admin;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/handscanattendance/ui/admin/MataKuliahAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/handscanattendance/ui/admin/MataKuliahAdapter$MataKuliahViewHolder;", "list", "", "Lcom/example/handscanattendance/data/MataKuliah;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MataKuliahViewHolder", "app_debug"})
public final class MataKuliahAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.handscanattendance.ui.admin.MataKuliahAdapter.MataKuliahViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.handscanattendance.data.MataKuliah> list = null;
    
    public MataKuliahAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.handscanattendance.data.MataKuliah> list) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.handscanattendance.ui.admin.MataKuliahAdapter.MataKuliahViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.handscanattendance.ui.admin.MataKuliahAdapter.MataKuliahViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/example/handscanattendance/ui/admin/MataKuliahAdapter$MataKuliahViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "btnDelete", "Landroid/widget/ImageButton;", "getBtnDelete", "()Landroid/widget/ImageButton;", "btnEdit", "getBtnEdit", "txtIdMk", "Landroid/widget/TextView;", "getTxtIdMk", "()Landroid/widget/TextView;", "txtNamaMk", "getTxtNamaMk", "txtSemester", "getTxtSemester", "app_debug"})
    public static final class MataKuliahViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView txtIdMk = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView txtNamaMk = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView txtSemester = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageButton btnEdit = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageButton btnDelete = null;
        
        public MataKuliahViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTxtIdMk() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTxtNamaMk() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTxtSemester() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageButton getBtnEdit() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageButton getBtnDelete() {
            return null;
        }
    }
}