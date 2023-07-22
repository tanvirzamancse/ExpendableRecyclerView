package com.tzp.expendablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tzp.expendablerecyclerview.databinding.RowParentsBinding;

import java.util.List;


public class ParentsAdapter extends RecyclerView.Adapter<ParentsAdapter.ViewHolder> {
    public List<ParentsDataModel> list;
    public List<String> nList;
    public Context context;

    public ParentsAdapter(List<ParentsDataModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        RowParentsBinding binding = DataBindingUtil.inflate(inflater, R.layout.row_parents, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ParentsDataModel dataModel = list.get(position);
        holder.binding.address.setText(dataModel.getItemText());
        boolean isExpendable = dataModel.isExpendable();

        holder.binding.expendable.setVisibility(isExpendable ? View.VISIBLE : View.GONE);

        if (isExpendable){
            holder.binding.arrow.setImageResource(R.drawable.arrow_up);
        }else {
            holder.binding.arrow.setImageResource(R.drawable.arrow_down);

        }

        ChildAdapter childAdapter = new ChildAdapter(nList, context);
        holder.binding.childRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.binding.childRecyclerView.setAdapter(childAdapter);
        holder.binding.layoutExpendable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataModel.setExpendable(!dataModel.isExpendable());
                nList = dataModel.getItemList();
                notifyItemChanged(holder.getAdapterPosition());

            }
        });

    }

    @Override
    public int getItemCount() {

        if (list != null) {

            return list.size();

        }

        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RowParentsBinding binding;

        public ViewHolder(@NonNull RowParentsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}
