package com.example.hafzaoyunu;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.Button;


import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatDrawableManager;


@SuppressLint("AppCompatCustomView")
public class card  extends  Button {

    boolean acikMi = false;
    boolean cevirilebilir=true;
    int resimID;
    int arkaPlanID;
    int onPlanID;
    Drawable arka;
    Drawable on;
    @SuppressLint({"NewApi", "RestrictedApi"})
    public card(Context context,int id) {
        super(context);
        setId(id);
        arkaPlanID = R.drawable.back;
        if (id%8==1)
            onPlanID=R.drawable.c1;
        if (id%8==2)
            onPlanID=R.drawable.c2;
        if (id%8==3)
            onPlanID=R.drawable.c3;
        if (id%8==4)
            onPlanID=R.drawable.c4;
        if (id%8==5)
            onPlanID=R.drawable.c5;
        if (id%8==6)
            onPlanID=R.drawable.c6;
        if (id%8==7)
            onPlanID=R.drawable.c7;
        if (id%8==0)
            onPlanID=R.drawable.c8;

        arka= AppCompatDrawableManager.get().getDrawable(context,arkaPlanID);
        on= AppCompatDrawableManager.get().getDrawable(context,onPlanID);
        setBackground(arka);
    }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void cevir(){
        if (cevirilebilir){

            if (!acikMi){
                setBackground(on);
                acikMi=true;
            }
            else {
                setBackground(arka);
                acikMi=false;
                }
             }
        }

}
