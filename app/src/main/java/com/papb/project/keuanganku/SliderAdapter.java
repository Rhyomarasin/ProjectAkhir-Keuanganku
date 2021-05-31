package com.papb.project.keuanganku;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.papb.project.keuanganku.R;
import com.squareup.picasso.Picasso;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public  SliderAdapter(Context context){
        this.context = context;
    }


    //menyimpan url untuk picaso untuk ditampilkan pada slide view
    public String[] slide_image={
            "https://image.flaticon.com/icons/png/512/33/33308.png",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Logo_Universitas_Brawijaya.svg/200px-Logo_Universitas_Brawijaya.png"
    };

    //menyimpan text untuk ditampilkan pada slide view
    public String[] slide_headings={
            "Kelompok 5",
            "UNIVERSITAS BRAWIJAYA"
    };
//
    //menyimpan text untuk ditampilkan pada slide view
    public  String[] slide_descs = {
            "1. YUDHANA EKA NUGRAHA - 175150207111023\n" +
                    "2. ALEXANDRIO KHARISMA PUTRA MARASIN - 185150207111017\n" +
                    "3. MOHAMMAD LUKMAN WIBOWO - 185150200111030\n" +
                    "4. MUHAMMAD NAUFAL DZIKRULLAH - 205150209111009\n" +
                    "5. AHMAD FEBRIYAN AMIN - 185150200111039\n",
            "Jl. Veteran, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return  view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription= (TextView) view.findViewById(R.id.slide_desc);
        //untuk menampilkan image dari url sesuai posisi
        Picasso.with(context).load(slide_image[position]).placeholder(R.drawable.profil).error(R.drawable.warning).into(slideImageView);
        //untuk mengatur isi teksview dari array yang telah disimpan
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
