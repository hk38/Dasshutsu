package com.lifeistech.android.dasshutsu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 鍵を所持しているか表す変数
    private boolean hasKey;
    // ドアが開いているか表す変数
    private boolean isOpened;
    // キーのボタンと結びつける変数
    private Button buttonKey;
    // ドアのボタンと結びつける変数
    private Button buttonDoor;

    //アプリが起動した時に呼ばれるメソッド
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 鍵は所持しておらず，ドアも開いていない
        hasKey = false;
        isOpened = false;

        // 変数とViewを結びつける
        buttonKey = (Button) findViewById(R.id.buttonKey);
        buttonDoor = (Button) findViewById(R.id.buttonDoor);
    }

    // 鍵を押した時の動作
    public void clickKey(View v){
        // 入手したことを表す表示
        Toast.makeText(this, "鍵を入手", Toast.LENGTH_SHORT).show();
        // 鍵の所持状態を更新
        hasKey = true;
        // 所有したのでViewを非表示にする
        buttonKey.setVisibility(View.INVISIBLE);
    }

    // ドアを押した時の動作
    public void clickDoor(View v){
        // 既に開いている時
        if(isOpened) {
            // 次のステージへ画面遷移
            Intent intent = new Intent(this, Stage2Activity.class);
            startActivity(intent);
        }else{
            // 鍵を持っている時
            if(hasKey){
                // ドアの画像を開いているものに差し替え
                buttonDoor.setBackgroundResource(R.drawable.door2);
                // ドアの開閉状態を更新
                isOpened = true;
                // ドアが開いたことを表す表示
                Toast.makeText(this, "Open the Door", Toast.LENGTH_SHORT).show();
            // 鍵を持っていない場合
            }else{
                // 鍵がないことを表す表示
                Toast.makeText(this, "鍵がないよ", Toast.LENGTH_SHORT).show();
            }
        }
    }

}