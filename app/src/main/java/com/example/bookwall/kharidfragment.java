package com.example.bookwall;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class kharidfragment extends Fragment {

    Button filter ,sort;
    RecyclerView recyclerView;
    public kharidfragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kharidfragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findviews(view);
        setUpRecycler();
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),FilterActivity.class));
            }
        });

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog sortdialog = new Dialog(getContext());
                sortdialog.setContentView(R.layout.sort_dialog);
                sortdialog.setTitle("مرتب سازی بر اساس");
                RadioButton newsort = sortdialog.findViewById(R.id.newest_sort);
                RadioButton viewsort = sortdialog.findViewById(R.id.viewest_sort);
                RadioButton ratesort = sortdialog.findViewById(R.id.rate_sort);

                newsort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean checked = ((RadioButton) view).isChecked();
                        if (checked){
                            sortdialog.dismiss();
                        }
                    }
                });

                ratesort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean checked = ((RadioButton) view).isChecked();
                        if (checked){
                            sortdialog.dismiss();
                        }
                    }
                });
                viewsort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean checked = ((RadioButton) view).isChecked();
                        if (checked){
                            sortdialog.dismiss();
                        }
                    }
                });
                sortdialog.show();
            }
        });

    }
    @SuppressLint("WrongConstant")
    private void setUpRecycler() {
        recyclerView.setAdapter(new Customadapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
    private class Customadapter extends RecyclerView.Adapter<Customadapter.ViewHolder>{

        LayoutInflater inflater;

        private Customadapter() {
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @NonNull
        @Override
        public Customadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Customadapter.ViewHolder(inflater.inflate(R.layout.book_card_view, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull Customadapter.ViewHolder holder, int position) {
            holder.image.setImageResource(R.drawable.notebookplaceholder);
            holder.name.setText("مدار منطقی");
            holder.price.setText("100000");


        }

        @Override
        public int getItemCount() {
            return 8;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name;
            TextView price;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.more_list_card_view_image);
                name = itemView.findViewById(R.id.more_list_card_view_name);
                price = itemView.findViewById(R.id.more_list_card_view_price);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getContext(),CustomBookActivity.class));
                    }
                });
            }
        }
    }


    private void findviews(View view) {
        filter = view.findViewById(R.id.kharid_filter);
        sort = view.findViewById(R.id.kharid_sort);
        recyclerView = view.findViewById(R.id.kharid_recycler_view);
    }
}
