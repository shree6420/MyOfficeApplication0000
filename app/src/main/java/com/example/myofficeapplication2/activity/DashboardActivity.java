package com.example.myofficeapplication2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.myofficeapplication2.R;

public class DashboardActivity extends AppCompatActivity {

    private Context context;
    private AutoCompleteTextView edtSelectState, edtSelectDist, edtSelectTaluka, edtSelectSoilProperties;
    private RelativeLayout rlTalukaBox,rlsoilpropertiesBox;
    private ImageView imageMap;
    float[] lastEvent = null;
    float d = 0f;
    float newRot = 0f;
    private boolean isZoomAndRotate;
    private boolean isOutSide;
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;
    private PointF start = new PointF();
    private PointF mid = new PointF();
    float oldDist = 1f;
    private float xCoOrdinate, yCoOrdinate;


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
        edtSelectTaluka = findViewById(R.id.edt_select_taluka);
        edtSelectSoilProperties= findViewById(R.id.edt_select_soilproperties);
        rlTalukaBox = findViewById(R.id.rl_taluka_box);
        rlTalukaBox.setVisibility(View.GONE);
        rlsoilpropertiesBox = findViewById(R.id.rl_soilproperties_box);
        imageMap = findViewById(R.id.img_view);
        setOnClick();
    }

    private void setOnClick() {

        imageMap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView view = (ImageView) v;
                view.bringToFront();
                viewTransformation(view, event);
                return true;
            }
        });
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
                            rlTalukaBox.setVisibility(View.GONE);
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
                        if (item.getTitle().equals("Akola")){
                            rlTalukaBox.setVisibility(View.GONE);
                            Glide.with( context )
                                    .load(R.drawable.akola )
                                    .into( imageMap );
                        }else if (item.getTitle().equals("Osmanabad")){
                            rlTalukaBox.setVisibility(View.GONE);
                            Glide.with( context )
                                    .load(R.drawable.osmanbad )
                                    .into( imageMap );
                        }else if (item.getTitle().equals("Wardha")){
                            rlTalukaBox.setVisibility(View.VISIBLE);

                        }else if (item.getTitle().equals("Amrawati")) {
                            rlTalukaBox.setVisibility(View.VISIBLE);
                            Glide.with( context )
                                    .load(R.drawable.chandurrailwayelevation )
                                    .into( imageMap );
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });

        edtSelectTaluka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popup = new PopupMenu(context, edtSelectTaluka);
                popup.getMenuInflater()
                        .inflate(R.menu.taluka_wardha_type, popup.getMenu());


                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        rlTalukaBox.setVisibility(View.VISIBLE);
                        edtSelectTaluka.setText(item.getTitle());

                        if (item.getTitle().equals("Aarvi")){
                            Glide.with( context )
                                    .load(R.drawable.arvi )
                                    .into( imageMap );
                        }
                        else if (item.getTitle().equals("Deoli")) {

                            Glide.with(context)
                                    .load(R.drawable.deoli)
                                    .into(imageMap);
                        }




                        return true;
                    }
                });

                popup.show();
            }
        });

        edtSelectTaluka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popup = new PopupMenu(context, edtSelectTaluka);
                popup.getMenuInflater()
                        .inflate(R.menu.taluka_amravati_type, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        rlTalukaBox.setVisibility(View.VISIBLE);
                        edtSelectTaluka.setText(item.getTitle());

                        if (item.getTitle().equals("Chandur Railway")){
                            Glide.with( context )
                                    .load(R.drawable.chandurrailwayelevation )
                                    .into( imageMap );
                        } else if (item.getTitle().equals("Chikhaldhara")){
                            Glide.with( context )
                                    .load(R.drawable.chikhaldharaelevation )
                                    .into( imageMap );
                        } else if (item.getTitle().equals("Dhamangaon")){
                            Glide.with( context )
                                    .load(R.drawable.dhamangaonelevation )
                                    .into( imageMap );
                        } else if (item.getTitle().equals("Taluka4")){
                            Glide.with( context )
                                    .load(R.drawable.dharnielevation)
                                    .into( imageMap );
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });


        edtSelectSoilProperties.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Create and show the PopupMenu for selecting soil properties
                final PopupMenu popup = new PopupMenu(context, edtSelectSoilProperties);
                popup.getMenuInflater().inflate(R.menu.arvisoil_properties_type, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        rlsoilpropertiesBox.setVisibility(View.VISIBLE);
                        edtSelectSoilProperties.setText(item.getTitle());
                        if (item.getItemId() == R.id.soil_property_1) {
                            Glide.with( context )
                                    .load(R.drawable.arvielevation )
                                    .into( imageMap );
                        }

                        else if (item.getItemId() == R.id.soil_property_2) {

                            Glide.with(context)
                                    .load(R.drawable.arvidpth)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_3) {

                            Glide.with(context)
                                    .load(R.drawable.arvilandform)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_4) {

                            Glide.with(context)
                                    .load(R.drawable.arvitexture)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_5) {

                            Glide.with(context)
                                    .load(R.drawable.arviph)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_6) {

                            Glide.with(context)
                                    .load(R.drawable.arviec)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_7) {

                            Glide.with(context)
                                    .load(R.drawable.arvioc)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_8) {

                            Glide.with(context)
                                    .load(R.drawable.arvin)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_9) {

                            Glide.with(context)
                                    .load(R.drawable.arvip)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_10) {

                            Glide.with(context)
                                    .load(R.drawable.arvik)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_11) {

                            Glide.with(context)
                                    .load(R.drawable.arvife)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_12) {

                            Glide.with(context)
                                    .load(R.drawable.arvimn)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_13) {

                            Glide.with(context)
                                    .load(R.drawable.arvicu)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_14) {

                            Glide.with(context)
                                    .load(R.drawable.arvizn)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_15) {

                            Glide.with(context)
                                    .load(R.drawable.arviawc)
                                    .into(imageMap);
                        }
                        else if (item.getItemId() == R.id.soil_property_16) {

                            Glide.with(context)
                                    .load(R.drawable.arvilulc)
                                    .into(imageMap);
                        }






                        return true;
                    }
                });

                popup.show();
            }
        });
    }








        private void viewTransformation(View view, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                xCoOrdinate = view.getX() - event.getRawX();
                yCoOrdinate = view.getY() - event.getRawY();

                start.set(event.getX(), event.getY());
                isOutSide = false;
                mode = DRAG;
                lastEvent = null;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                oldDist = spacing(event);
                if (oldDist > 10f) {
                    midPoint(mid, event);
                    mode = ZOOM;
                }

                lastEvent = new float[4];
                lastEvent[0] = event.getX(0);
                lastEvent[1] = event.getX(1);
                lastEvent[2] = event.getY(0);
                lastEvent[3] = event.getY(1);
                d = rotation(event);
                break;
            case MotionEvent.ACTION_UP:
                isZoomAndRotate = false;
                if (mode == DRAG) {
                    float x = event.getX();
                    float y = event.getY();
                }
            case MotionEvent.ACTION_OUTSIDE:
                isOutSide = true;
                mode = NONE;
                lastEvent = null;
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                lastEvent = null;
                break;
            case MotionEvent.ACTION_MOVE:
                if (!isOutSide) {
                    if (mode == DRAG) {
                        isZoomAndRotate = false;
                        view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();
                    }
                    if (mode == ZOOM && event.getPointerCount() == 2) {
                        float newDist1 = spacing(event);
                        if (newDist1 > 10f) {
                            float scale = newDist1 / oldDist * view.getScaleX();
                            view.setScaleX(scale);
                            view.setScaleY(scale);
                        }
                        if (lastEvent != null) {
                            newRot = rotation(event);
                            view.setRotation((float) (view.getRotation() + (newRot - d)));
                        }
                    }
                }
                break;
        }
    }

    private float rotation(MotionEvent event) {
        double delta_x = (event.getX(0) - event.getX(1));
        double delta_y = (event.getY(0) - event.getY(1));
        double radians = Math.atan2(delta_y, delta_x);
        return (float) Math.toDegrees(radians);
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (int) Math.sqrt(x * x + y * y);
    }

    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }
}