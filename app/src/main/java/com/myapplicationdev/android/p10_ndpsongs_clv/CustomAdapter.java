package com.myapplicationdev.android.p10_ndpsongs_clv;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int layout_id;
    ArrayList<Song> al;

    public CustomAdapter(Context context, int resource,ArrayList<Song> al) {
        super(context, resource, al);
        this.context = context;
        this.layout_id = resource;
        this.al = al;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertview, @NonNull ViewGroup parent) {
        LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflator.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
//        TextView tvStar = rowView.findViewById(R.id.tvStar);
        TextView tvSinger = rowView.findViewById(R.id.tvSingers);

        RatingBar rbStar = rowView.findViewById(R.id.rbStar);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        Song currSong = al.get(position);


        //Better to set the sizes in xml because in xml can roughly see how big it is.
        tvTitle.setText(currSong.getTitle());
        tvTitle.setTextColor(Color.BLUE);
        tvTitle.setTextSize(20.5f);
        tvSinger.setText(currSong.getSingers());
        tvSinger.setTextColor(Color.CYAN);
        tvSinger.setTextSize(16.5f);
        String stars = Integer.toString(currSong.getStars());
//        tvStar.setText(stars);
//        tvStar.setTextSize(20.5f);
        rbStar.setRating(currSong.getStars());
        imageView.setImageResource(R.drawable.newimg);
        String year = Integer.toString(currSong.getYearReleased());
        tvYear.setText(year);
        tvYear.setTextSize(18.5f);

        if(currSong.getYearReleased() >= 2019) {
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.INVISIBLE);
        }

//        if(currSong.getStars() == 5 ) {
//            rbStar.setNumStars(5);
//            tvStar.setText("* * * * *");
//            tvStar.setTextColor(Color.RED);
//        } else if (currSong.getStars() == 4) {
//            rbStar.setNumStars(4);
//            tvStar.setText("* * * *");
//        } else if (currSong.getStars() == 3) {
//            rbStar.setNumStars(3);
//            tvStar.setText("* * *");
//        } else if (currSong.getStars() == 2) {
//            rbStar.setNumStars(2);
//            tvStar.setText("* *");
//        } else if (currSong.getStars() == 1) {
//            rbStar.setNumStars(1);
//            tvStar.setText("*");
//        }



        return rowView;
    }
}
