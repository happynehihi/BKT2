package com.example.bkt2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CayThuocNamAdapter extends BaseAdapter {
    Activity activity;
    List<CayThuocNam> cayThuocNams;

    public CayThuocNamAdapter(Activity activity, List<CayThuocNam> cayThuocNams) {
        this.activity = activity;
        this.cayThuocNams = cayThuocNams;
    }

    @Override
    public int getCount() {
        return cayThuocNams.size();
    }

    @Override
    public Object getItem(int i) {
        return cayThuocNams.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.layoutitem, null);
        TextView tvName = (TextView) view.findViewById(R.id.tenkhoahoc);
        TextView tvtenthuonggoi = (TextView) view.findViewById(R.id.tenthuonggoi);
        TextView tvmaula = (TextView) view.findViewById(R.id.maula);
        TextView tvcongdung = (TextView) view.findViewById(R.id.congdung);
        TextView tvchuy = (TextView) view.findViewById(R.id.chuY);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageHinh);
        tvName.setText(cayThuocNams.get(i).getTenKhoaHoc());
        tvtenthuonggoi.setText(cayThuocNams.get(i).getTenThuongGoi());
        tvmaula.setText(String.valueOf("Màu lá: "+cayThuocNams.get(i).getMauLa()));
        tvcongdung.setText(cayThuocNams.get(i).getCongDung());
        tvchuy.setText(cayThuocNams.get(i).getChuY());
        imageView.setImageResource(cayThuocNams.get(i).getHinhAnh());
        return view;
    }
}
