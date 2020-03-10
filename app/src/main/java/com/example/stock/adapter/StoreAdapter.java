package com.example.stock.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stock.R;
import com.example.stock.bean.ResultBean;
import com.example.stock.databinding.ItemStoreBinding;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreHolder>{

    private List<ResultBean> items;
    private OnItemClickListener listener;

    @NonNull
    @Override
    public StoreAdapter.StoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store, parent, false);

        return new StoreHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.StoreHolder holder, int position) {

        ResultBean bean = items.get(holder.getAdapterPosition());

        holder.binding.setBean(bean);
        holder.binding.setListener(listener);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void setItems(List<ResultBean> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public void setClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onClick(ResultBean bean);
    }

    class StoreHolder extends RecyclerView.ViewHolder{

        ItemStoreBinding binding;

        StoreHolder(@NonNull View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }
    }
}
