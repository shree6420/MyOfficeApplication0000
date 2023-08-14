package com.example.myofficeapplication2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.myofficeapplication2.R;

public class DashboardActivity extends AppCompatActivity {

    private Context context;
    private AutoCompleteTextView edtSelectState, edtSelectDist;
    private ImageView imageMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
    }
    private void init(){
        context = this;
        edtSelectDist = findViewById(R.id.edt_select_dist);
        edtSelectState = findViewById(R.id.edt_select_state);
        imageMap = findViewById(R.id.img_view);
        setOnClick();
    }

    private void setOnClick() {
        edtSelectState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popup = new PopupMenu(context, edtSelectState);
                popup.getMenuInflater()
                        .inflate(R.menu.state_type, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        edtSelectState.setText(item.getTitle());
                        if (item.getTitle().equals("Maharashtra")){

                            edtSelectDist.setVisibility(View.VISIBLE);
                        }else {
                            edtSelectDist.setVisibility(View.GONE);
                        }

                        return true;
                    }
                });

                popup.show();
            }
        });

        edtSelectDist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popup = new PopupMenu(context, edtSelectDist);
                popup.getMenuInflater()
                        .inflate(R.menu.district_type, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        edtSelectDist.setText(item.getTitle());
                        return true;
                    }
                });

                popup.show();
            }
        });
    }
}