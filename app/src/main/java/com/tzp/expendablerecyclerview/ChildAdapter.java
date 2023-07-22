package com.tzp.expendablerecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tzp.expendablerecyclerview.databinding.RowChildsBinding;
import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {
    private List<String> list;
    private Context context;

    public ChildAdapter(List<String> list, Context context) {

        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        RowChildsBinding binding = DataBindingUtil.inflate(inflater, R.layout.row_childs, parent, false);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvDis.setText(list.get(position));

    }

    @Override
    public int getItemCount() {

        if (list != null) {

            return list.size();

        }

        return 0;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RowChildsBinding binding;

        public ViewHolder(@NonNull RowChildsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }


}
