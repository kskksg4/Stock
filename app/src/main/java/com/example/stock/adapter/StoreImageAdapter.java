package com.example.stock.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stock.R;
import com.example.stock.bean.DetailImageBean;
import com.example.stock.databinding.ItemStoreImageBinding;

import java.util.List;

public class StoreImageAdapter extends RecyclerView.Adapter<StoreImageAdapter.StoreImageHolder> {

    private List<DetailImageBean> items;
    private OnItemClickListener listener;
    private int count;
    private View itemView = null;

    @NonNull
    @Override
    public StoreImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Toast.makeText(parent.getContext(), "count: "+count, Toast.LENGTH_SHORT).show();
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store_image, parent, false);

        return new StoreImageHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreImageHolder holder, int position) {

        DetailImageBean bean = items.get(holder.getAdapterPosition());

        holder.binding.setBean(bean);
        holder.binding.setListener(listener);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void setItems(List<DetailImageBean> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public void setImgCount(Integer count){
        this.count = count;
        notifyDataSetChanged();
    }

    public void setClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onClick(String url);
    }

    class StoreImageHolder extends RecyclerView.ViewHolder{

        ItemStoreImageBinding binding;

        StoreImageHolder(@NonNull View itemView) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
        }
    }
}



