package com.example.practice.adapter;

import android.os.Build;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice.databinding.LayoutDogItemBinding;
import com.example.practice.model.Dog;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {
    List<Dog> DogList;

    public DogAdapter(List<Dog> dogList) {
        DogList = dogList;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutDogItemBinding binding = LayoutDogItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        DogViewHolder holder = new DogViewHolder(binding);

        return holder;
    }

    @Override
    @RequiresApi(api= Build.VERSION_CODES.O)
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        holder.binding.txtViewId.setText(DogList.get(position).getDogid());
        holder.binding.txtViewName.setText(DogList.get(position).getDogName());
        holder.binding.txtViewBreed.setText(DogList.get(position).getDogType());
        holder.binding.imageViewPics.setImageResource(DogList.get(position).getDogPic());
        holder.binding.txtViewDOB.setText(DogList.get(position).getDogDob());

    }

    @Override
    public int getItemCount() {
        return DogList.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder{
        LayoutDogItemBinding binding;
        public DogViewHolder(@NonNull LayoutDogItemBinding itemBinding) {
            super(itemBinding.getRoot());
            binding = itemBinding;
        }
    }
}
