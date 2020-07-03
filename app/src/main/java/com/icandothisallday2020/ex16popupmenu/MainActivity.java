package com.icandothisallday2020.ex16popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        btn2=findViewById(R.id.btn2);
        //버튼에 롱클릭리스너 객체 생성 및 설정
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Toast.makeText(MainActivity.this,"Long Click",Toast.LENGTH_SHORT).show();
                //PopupMenu 객체 생성[Menu 객체가 놓여질 수 있는 마법의 양탄자같은 객체]
                PopupMenu popup=new PopupMenu(MainActivity.this,btn2);
                //두번째 파라미터: 팝업메뉴가 붙을 뷰
                MenuInflater menuInflater=getMenuInflater();
                menuInflater.inflate(R.menu.popup,popup.getMenu());//*****
                //popup:팝업메뉴 X /메뉴가 놓여질 수 있는 공간
                //팝업메뉴의 메뉴아이템을 클릭했을 때 듣는 리스너 객체 생성&설정
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id=item.getItemId();
                        switch (id){
                            case R.id.menu_info:
                                Toast.makeText(MainActivity.this,"information",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_delete:
                                Toast.makeText(MainActivity.this,"delete",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_modify:
                                Toast.makeText(MainActivity.this,"modify",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;                    }                });
                popup.show();
                return true;
                //리턴값: 이 클릭이벤트의 작업을 여기서 마칠 것인지(consume:소비했다)의 여부
                //(롱클릭을 하면 터치를 떼는 순간 click method 까지 실행되기때문)
            }        });
    }

    public void click(View view) {
        Toast.makeText(this,"Click",Toast.LENGTH_SHORT).show();
    }
}
