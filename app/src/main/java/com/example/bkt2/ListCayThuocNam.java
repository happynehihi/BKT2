package com.example.bkt2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListCayThuocNam extends AppCompatActivity {

    private ListView listView;
    ArrayList<CayThuocNam> items = new ArrayList<>();
    CayThuocNamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cay_thuoc_nam);
        listView = (ListView) findViewById(R.id.lvCayXanh);
        items.add(new CayThuocNam("MINT","BẠC HÀ","dactinh","Xanh","Thanh nhiệt, thấu chẩn.","Ngày dùng 12 - 20g, hãm vào nước sôi 200 ml, cách 3 giờ uống một lần.","Không dùng trực tiếp",R.drawable.bacha));
        items.add(new CayThuocNam("Mulberry","DÂU TẰM","dactinh","Đỏ","Trừ ho, bổ phế","Rễ, thân, lá, quả","ngày dùng 6-12g.",R.drawable.backbo));
        items.add(new CayThuocNam("Kaempferia galanga L","ĐỊA LIỀN","dactinh","Xanh","Tán hàn, trị cảm lạn","duoctinh","Ngày dùng 4 - 8g, sắc uống. Dùng ngoài ngâm rượu để xoa bóp.",R.drawable.bachdongnu));


        adapter = new CayThuocNamAdapter(ListCayThuocNam.this,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListCayThuocNam.this,Detail.class);
                intent.putExtra("Ten",items.get(i).getTenKhoaHoc()+"\n"+items.get(i).getTenThuongGoi());
                intent.putExtra("MoTa",items.get(i).getDacTinh());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Xacnhanxoa(i);
                return true;
            }
        });
    }
    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(ListCayThuocNam.this);
        alertDiaLog.setTitle("Thông báo");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Bạn có muốn xóa");
        alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                items.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDiaLog.show();
    }
}