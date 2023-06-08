package com.moutamid.postapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemVH> {
    Context context;
    ArrayList<ItemModel> list;

    public ItemAdapter(Context context, ArrayList<ItemModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemVH(LayoutInflater.from(context).inflate(R.layout.item_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVH holder, int position) {
        ItemModel model = list.get(holder.getAdapterPosition());
        holder.name.setText(model.getName());
        holder.time.setText(model.getTime());
        holder.text.setText(model.getText());
        ArrayList<String> images = model.getImages();
        SliderAdapter adapter = new SliderAdapter(images);
        holder.sliderView.setSliderAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {
        private ArrayList<String> mSliderItems;

        public SliderAdapter(ArrayList<String> mSliderItems) {
            this.mSliderItems = mSliderItems;
        }

        @Override
        public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, parent, false);
            return new SliderAdapterVH(inflate);
        }

        @Override
        public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

            String sliderItem = mSliderItems.get(position);
            viewHolder.count.setText((position+1) + "/" + mSliderItems.size() );
            Glide.with(viewHolder.itemView)
                    .load(sliderItem)
                    .fitCenter()
                    .into(viewHolder.imageViewBackground);
        }

        @Override
        public int getCount() {
            return mSliderItems.size();
        }

        class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
            ImageView imageViewBackground;
            TextView count;
            public SliderAdapterVH(View itemView) {
                super(itemView);
                imageViewBackground = itemView.findViewById(R.id.image_slider);
                count = itemView.findViewById(R.id.count);
            }
        }

    }


    public class ItemVH extends RecyclerView.ViewHolder{
        TextView name, time, text;
        CircleImageView profile;
        SliderView sliderView;

        public ItemVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            time = itemView.findViewById(R.id.time);
            text = itemView.findViewById(R.id.text);
            profile = itemView.findViewById(R.id.circleImageView);
            sliderView = itemView.findViewById(R.id.imageSlider);
        }
    }

}
