package com.game.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private float X;
    private float Y;
    private ImageView Box1;
    private ImageView Box2;
    private ImageView Box3;
    private ImageView Box4;
    private ImageView Box5;
    private ImageView Box6;
    private ImageView Box7;
    private ImageView Box8;
    private ImageView Box9;
    private ImageView grid;
    private ImageView topline;
    private ImageView centerline;
    private ImageView bottomline;
    private ImageView leftdiagonal;
    private ImageView rightdiagonal;
    private ImageView leftvertical;
    private ImageView centervertical;
    private ImageView rightvertical;
    private ImageView imageX;
    private ImageView imageO;
    private TextView textView;
    private Button button;
    enum Player
    {
        one,two;
    }
    Player player;
    private int Check()
    {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (Box1.getDrawable() != null && Box2.getDrawable() != null && Box3.getDrawable() !=null && ((BitmapDrawable)Box1.getDrawable()).getBitmap() == ((BitmapDrawable)Box2.getDrawable()).getBitmap() && ((BitmapDrawable)Box2.getDrawable()).getBitmap() == ((BitmapDrawable)Box3.getDrawable()).getBitmap())
        {
            return 1;
        }
        else if (Box4.getDrawable() != null && Box5.getDrawable() != null && Box6.getDrawable() !=null && ((BitmapDrawable)Box4.getDrawable()).getBitmap() == ((BitmapDrawable)Box5.getDrawable()).getBitmap() && ((BitmapDrawable)Box5.getDrawable()).getBitmap() == ((BitmapDrawable)Box6.getDrawable()).getBitmap())
        {
            return 2;
        }
        else if (Box7.getDrawable() != null && Box8.getDrawable() != null && Box9.getDrawable() !=null && ((BitmapDrawable)Box7.getDrawable()).getBitmap() == ((BitmapDrawable)Box8.getDrawable()).getBitmap() && ((BitmapDrawable)Box8.getDrawable()).getBitmap() == ((BitmapDrawable)Box9.getDrawable()).getBitmap())
        {
            return 3;
        }
        else if (Box1.getDrawable() != null && Box5.getDrawable() != null && Box9.getDrawable() !=null && ((BitmapDrawable)Box1.getDrawable()).getBitmap() == ((BitmapDrawable)Box5.getDrawable()).getBitmap() && ((BitmapDrawable)Box5.getDrawable()).getBitmap() == ((BitmapDrawable)Box9.getDrawable()).getBitmap())
        {
            return 4;
        }
        else if (Box3.getDrawable() != null && Box5.getDrawable() != null && Box7.getDrawable() !=null && ((BitmapDrawable)Box3.getDrawable()).getBitmap() == ((BitmapDrawable)Box5.getDrawable()).getBitmap() && ((BitmapDrawable)Box5.getDrawable()).getBitmap() == ((BitmapDrawable)Box7.getDrawable()).getBitmap())
        {
            return 5;
        }
        else if (Box1.getDrawable() != null && Box4.getDrawable() != null && Box7.getDrawable() !=null && ((BitmapDrawable)Box1.getDrawable()).getBitmap() == ((BitmapDrawable)Box4.getDrawable()).getBitmap() && ((BitmapDrawable)Box4.getDrawable()).getBitmap() == ((BitmapDrawable)Box7.getDrawable()).getBitmap())
        {
            return 6;
        }
        else if (Box2.getDrawable() != null && Box5.getDrawable() != null && Box8.getDrawable() !=null && ((BitmapDrawable)Box2.getDrawable()).getBitmap() == ((BitmapDrawable)Box5.getDrawable()).getBitmap() && ((BitmapDrawable)Box5.getDrawable()).getBitmap() == ((BitmapDrawable)Box8.getDrawable()).getBitmap())
        {
            return 7;
        }
        else if (Box3.getDrawable() != null && Box6.getDrawable() != null && Box9.getDrawable() !=null && ((BitmapDrawable)Box3.getDrawable()).getBitmap() == ((BitmapDrawable)Box6.getDrawable()).getBitmap() && ((BitmapDrawable)Box6.getDrawable()).getBitmap() == ((BitmapDrawable)Box9.getDrawable()).getBitmap())
        {
            return 8;
        }
        else if (Box1.getDrawable() != null && Box2.getDrawable() != null && Box3.getDrawable() != null && Box4.getDrawable() != null && Box5.getDrawable() != null && Box6.getDrawable() != null && Box7.getDrawable() != null && Box8.getDrawable() != null && Box9.getDrawable() != null)
        {
            return 9;
        }
        return 0;

    }
    int[] location = new int[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        topline = findViewById(R.id.topline);
        centerline = findViewById(R.id.centerline);
        bottomline = findViewById(R.id.bottomline);
        leftdiagonal = findViewById(R.id.leftdiagonal);
        rightdiagonal = findViewById(R.id.rightdiagonal);
        rightvertical = findViewById(R.id.rightvertical);
        centervertical = findViewById(R.id.centervertical);
        leftvertical = findViewById(R.id.leftvertical);
        textView = findViewById(R.id.textView);
        Box1 = findViewById(R.id.Box1);
        Box2 = findViewById(R.id.Box2);
        Box3 = findViewById(R.id.Box3);
        Box4 = findViewById(R.id.Box4);
        Box5 = findViewById(R.id.Box5);
        Box6 = findViewById(R.id.Box6);
        Box7 = findViewById(R.id.Box7);
        Box8 = findViewById(R.id.Box8);
        Box9 = findViewById(R.id.Box9);
        grid = findViewById(R.id.imageView);
        imageX = findViewById(R.id.imageX);
        imageO = findViewById(R.id.imageO);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        player = Player.one;
        button.setEnabled(false);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = (ImageView) v;
                if (imageView.getId() == Box1.getId() && Box1.getDrawable() == null)
                {
                    if (player == Player.one)
                    {
                        Box1.setImageResource(R.drawable.x);
                        Box1.animate().alpha(1).setDuration(1000);
                        player = Player.two;
                    }
                    else
                    {
                        Box1.setImageResource(R.drawable.o);
                        Box1.animate().alpha(1).setDuration(1000);
                        player = Player.one;
                    }

                }
                else if (imageView.getId() == Box2.getId() && Box2.getDrawable() ==null)
                {
                    if (player == Player.one)
                    {
                        Box2.setImageResource(R.drawable.x);
                        Box2.animate().alpha(1).setDuration(1000);
                        player = Player.two;
                    }
                    else
                    {
                        Box2.setImageResource(R.drawable.o);
                        Box2.animate().alpha(1).setDuration(1000);
                        player = Player.one;
                    }
                }
                else if (imageView.getId() == Box3.getId() && Box3.getDrawable() == null)
                {
                    if (player == Player.one)
                    {
                        Box3.setImageResource(R.drawable.x);
                        Box3.animate().alpha(1).setDuration(1000);
                        player = Player.two;
                    }
                    else
                    {
                        Box3.setImageResource(R.drawable.o);
                        Box3.animate().alpha(1).setDuration(1000);
                        player = Player.one;
                    }
                }
                else if (imageView.getId() == Box4.getId() && Box4.getDrawable() == null)
                {
                    if (player == Player.one)
                    {
                        Box4.setImageResource(R.drawable.x);
                        Box4.animate().alpha(1).setDuration(1000);
                        player = Player.two;
                    }
                    else
                    {
                        Box4.setImageResource(R.drawable.o);
                        Box4.animate().alpha(1).setDuration(1000);
                        player = Player.one;
                    }
                }
                else if (imageView.getId() == Box5.getId() && Box5.getDrawable() == null)
                {
                    if (player == Player.one)
                    {
                        Box5.setImageResource(R.drawable.x);
                        Box5.animate().alpha(1).setDuration(1000);
                        player = Player.two;
                    }
                    else
                    {
                        Box5.setImageResource(R.drawable.o);
                        Box5.animate().alpha(1).setDuration(1000);
                        player = Player.one;
                    }
                }
                else if (imageView.getId() == Box6.getId() && Box6.getDrawable() == null)
                {
                    if (player == Player.one)
                    {
                        Box6.setImageResource(R.drawable.x);
                        Box6.animate().alpha(1).setDuration(1000);
                        player = Player.two;
                    }
                    else
                    {
                        Box6.setImageResource(R.drawable.o);
                        Box6.animate().alpha(1).setDuration(1000);
                        player = Player.one;
                    }
                }
                else if (imageView.getId() == Box7.getId() && Box7.getDrawable() == null)
                {
                    if (player == Player.one)
                    {
                        Box7.setImageResource(R.drawable.x);
                        Box7.animate().alpha(1).setDuration(1000);
                        player = Player.two;
                    }
                    else
                    {
                        Box7.setImageResource(R.drawable.o);
                        Box7.animate().alpha(1).setDuration(1000);
                        player = Player.one;
                    }
                }
                else if (imageView.getId() == Box8.getId() && Box8.getDrawable() == null)
                {
                    if (player == Player.one)
                    {
                        Box8.setImageResource(R.drawable.x);
                        Box8.animate().alpha(1).setDuration(1000);
                        player = Player.two;
                    }
                    else
                    {
                        Box8.setImageResource(R.drawable.o);
                        Box8.animate().alpha(1).setDuration(1000);
                        player = Player.one;
                    }
                }
                else if (imageView.getId() == Box9.getId() && Box9.getDrawable() == null)
                {
                    if (player == Player.one)
                    {
                        Box9.setImageResource(R.drawable.x);
                        Box9.animate().alpha(1).setDuration(1000);
                        player = Player.two;
                    }
                    else
                    {
                        Box9.setImageResource(R.drawable.o);
                        Box9.animate().alpha(1).setDuration(1000);
                        player = Player.one;
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "This space is already occupied", Toast.LENGTH_SHORT).show();
                }
                X = Box5.getX() + Box5.getWidth()/2;
                Y = Box5.getY() + Box5.getHeight()/2;

                if (Check() == 1)
                {
                    Log.i("MY",Box2.getHeight() + "");
                    grid.animate().alpha(0).setDuration(300);
                    Box9.animate().alpha(0).setDuration(300);
                    Box8.animate().alpha(0).setDuration(300);
                    Box7.animate().alpha(0).setDuration(300);
                    Box6.animate().alpha(0).setDuration(300);
                    Box5.animate().alpha(0).setDuration(300);
                    Box4.animate().alpha(0).setDuration(300);

                    topline.animate().scaleX(1).setDuration(500);
                    Box1.setEnabled(false);
                    Box2.setEnabled(false);
                    Box3.setEnabled(false);
                    Box4.setEnabled(false);
                    Box5.setEnabled(false);
                    Box6.setEnabled(false);
                    Box7.setEnabled(false);
                    Box8.setEnabled(false);
                    Box9.setEnabled(false);
                    Box3.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Box1.animate().translationX(X - Box1.getWidth()/2 - Box1.getX()).translationY(Y - Box1.getHeight()/2 - Box1.getY()).setDuration(1000);
                            Box2.animate().translationX(X - Box2.getWidth()/2 - Box2.getX()).translationY(Y - Box2.getHeight()/2 - Box2.getY()).setDuration(1000);
                            Box3.animate().translationX(X - Box3.getWidth()/2 - Box3.getX()).translationY(Y - Box3.getHeight()/2 - Box3.getY()).setDuration(1000);
                            topline.animate().translationX(X - (topline.getWidth()/2) - 50).translationY(Y - (topline.getHeight()/2) - Box5.getHeight()/2 - 10).scaleX(0).setDuration(1000);
                            Box3.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Box1.animate().alpha(0).setDuration(0);
                                    Box2.animate().alpha(0).setDuration(0);
                                    Box3.animate().translationYBy(-150).setDuration(1000);
                                    textView.animate().alpha(1).setDuration(1000);
                                    button.animate().alpha(1).setDuration(1000);
                                    button.setEnabled(true);
                                }
                            }, 1000);
                        }
                    }, 1000);
                }

                else if (Check() == 2)
                {
                    grid.animate().alpha(0).setDuration(300);
                    Box1.animate().alpha(0).setDuration(300);
                    Box2.animate().alpha(0).setDuration(300);
                    Box3.animate().alpha(0).setDuration(300);
                    Box7.animate().alpha(0).setDuration(300);
                    Box8.animate().alpha(0).setDuration(300);
                    Box9.animate().alpha(0).setDuration(300);

                    centerline.animate().scaleX(1).setDuration(500);
                    Box1.setEnabled(false);
                    Box2.setEnabled(false);
                    Box3.setEnabled(false);
                    Box4.setEnabled(false);
                    Box5.setEnabled(false);
                    Box6.setEnabled(false);
                    Box7.setEnabled(false);
                    Box8.setEnabled(false);
                    Box9.setEnabled(false);
                    Box6.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Box4.animate().translationX(X - Box4.getWidth()/2 - Box4.getX()).translationY(Y - Box4.getHeight()/2 - Box4.getY()).setDuration(1000);
                            Box5.animate().translationX(X - Box5.getWidth()/2 - Box5.getX()).translationY(Y - Box5.getHeight()/2 - Box5.getY()).setDuration(1000);
                            Box6.animate().translationX(X - Box6.getWidth()/2 - Box6.getX()).translationY(Y - Box6.getHeight()/2 - Box6.getY()).setDuration(1000);
                            centerline.animate().scaleX(0).setDuration(1000);
                            Box6.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Box4.animate().alpha(0).setDuration(0);
                                    Box5.animate().alpha(0).setDuration(0);
                                    Box6.animate().translationYBy(-150).setDuration(1000);
                                    textView.animate().alpha(1).setDuration(1000);
                                    button.animate().alpha(1).setDuration(1000);
                                    button.setEnabled(true);
                                }
                            }, 1000);
                        }
                    }, 1000);
                }
                else if (Check() == 3)
                {

                    grid.animate().alpha(0).setDuration(300);
                    Box1.animate().alpha(0).setDuration(300);
                    Box2.animate().alpha(0).setDuration(300);
                    Box3.animate().alpha(0).setDuration(300);
                    Box4.animate().alpha(0).setDuration(300);
                    Box5.animate().alpha(0).setDuration(300);
                    Box6.animate().alpha(0).setDuration(300);

                    bottomline.animate().scaleX(1).setDuration(500);
                    Box1.setEnabled(false);
                    Box2.setEnabled(false);
                    Box3.setEnabled(false);
                    Box4.setEnabled(false);
                    Box5.setEnabled(false);
                    Box6.setEnabled(false);
                    Box7.setEnabled(false);
                    Box8.setEnabled(false);
                    Box9.setEnabled(false);
                    Box9.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Box7.animate().translationX(X - Box7.getWidth()/2 - Box7.getX()).translationY(Y - Box7.getHeight()/2 - Box7.getY()).setDuration(1000);
                            Box8.animate().translationX(X - Box8.getWidth()/2 - Box8.getX()).translationY(Y  -Box8.getHeight()/2 - Box8.getY()).setDuration(1000);
                            Box9.animate().translationX(X - Box9.getWidth()/2 - Box9.getX()).translationY(Y - Box9.getHeight()/2 - Box9.getY()).setDuration(1000);
                            bottomline.animate().translationX(X - (bottomline.getWidth()/2) - 50).translationY(-Y + (bottomline.getHeight()/2) + (Box5.getHeight()/2) + 30).scaleX(0).setDuration(1000);
                            Box9.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Box7.animate().alpha(0).setDuration(0);
                                    Box8.animate().alpha(0).setDuration(0);
                                    Box9.animate().translationYBy(-150).setDuration(1000);
                                    textView.animate().alpha(1).setDuration(1000);
                                    button.animate().alpha(1).setDuration(1000);
                                    button.setEnabled(true);
                                }
                            }, 1000);
                        }
                    }, 1000);
                }
                else if (Check() == 4)
                {
                    grid.animate().alpha(0).setDuration(300);
                    Box2.animate().alpha(0).setDuration(300);
                    Box3.animate().alpha(0).setDuration(300);
                    Box4.animate().alpha(0).setDuration(300);
                    Box6.animate().alpha(0).setDuration(300);
                    Box7.animate().alpha(0).setDuration(300);
                    Box8.animate().alpha(0).setDuration(300);

                    leftdiagonal.animate().scaleX(1).setDuration(500);
                    Box1.setEnabled(false);
                    Box2.setEnabled(false);
                    Box3.setEnabled(false);
                    Box4.setEnabled(false);
                    Box5.setEnabled(false);
                    Box6.setEnabled(false);
                    Box7.setEnabled(false);
                    Box8.setEnabled(false);
                    Box9.setEnabled(false);
                    Box9.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Box1.animate().translationX(X - Box1.getWidth()/2 - Box1.getX()).translationY(Y - Box1.getHeight()/2 - Box1.getY()).setDuration(1000);
                            Box5.animate().translationX(X - Box5.getWidth()/2 - Box5.getX()).translationY(Y  -Box5.getHeight()/2 - Box5.getY()).setDuration(1000);
                            Box9.animate().translationX(X - Box9.getWidth()/2 - Box9.getX()).translationY(Y - Box9.getHeight()/2 - Box9.getY()).setDuration(1000);
                            leftdiagonal.animate().scaleX(0).setDuration(1000);
                            Box9.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Box1.animate().alpha(0).setDuration(0);
                                    Box5.animate().alpha(0).setDuration(0);
                                    Box9.animate().translationYBy(-150).setDuration(1000);
                                    textView.animate().alpha(1).setDuration(1000);
                                    button.animate().alpha(1).setDuration(1000);
                                    button.setEnabled(true);
                                }
                            }, 1000);
                        }
                    }, 1000);
                }
                else if (Check() == 5)
                {
                    grid.animate().alpha(0).setDuration(300);
                    Box1.animate().alpha(0).setDuration(300);
                    Box2.animate().alpha(0).setDuration(300);
                    Box4.animate().alpha(0).setDuration(300);
                    Box6.animate().alpha(0).setDuration(300);
                    Box8.animate().alpha(0).setDuration(300);
                    Box9.animate().alpha(0).setDuration(300);

                    rightdiagonal.animate().scaleX(1).setDuration(500);
                    Box1.setEnabled(false);
                    Box2.setEnabled(false);
                    Box3.setEnabled(false);
                    Box4.setEnabled(false);
                    Box5.setEnabled(false);
                    Box6.setEnabled(false);
                    Box7.setEnabled(false);
                    Box8.setEnabled(false);
                    Box9.setEnabled(false);
                    Box7.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Box3.animate().translationX(X - Box3.getWidth()/2 - Box3.getX()).translationY(Y - Box3.getHeight()/2 - Box3.getY()).setDuration(1000);
                            Box5.animate().translationX(X - Box5.getWidth()/2 - Box5.getX()).translationY(Y  -Box5.getHeight()/2 - Box5.getY()).setDuration(1000);
                            Box7.animate().translationX(X - Box7.getWidth()/2 - Box7.getX()).translationY(Y - Box7.getHeight()/2 - Box7.getY()).setDuration(1000);
                            rightdiagonal.animate().scaleX(0).setDuration(1000);
                            Box7.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Box3.animate().alpha(0).setDuration(0);
                                    Box5.animate().alpha(0).setDuration(0);
                                    Box7.animate().translationYBy(-150).setDuration(1000);
                                    textView.animate().alpha(1).setDuration(1000);
                                    button.animate().alpha(1).setDuration(1000);
                                    button.setEnabled(true);
                                }
                            }, 1000);
                        }
                    }, 1000);
                }
                else if (Check() == 6)
                {
                    grid.animate().alpha(0).setDuration(300);
                    Box2.animate().alpha(0).setDuration(300);
                    Box3.animate().alpha(0).setDuration(300);
                    Box5.animate().alpha(0).setDuration(300);
                    Box6.animate().alpha(0).setDuration(300);
                    Box8.animate().alpha(0).setDuration(300);
                    Box9.animate().alpha(0).setDuration(300);

                    leftvertical.animate().scaleX(1).setDuration(500);
                    Box1.setEnabled(false);
                    Box2.setEnabled(false);
                    Box3.setEnabled(false);
                    Box4.setEnabled(false);
                    Box5.setEnabled(false);
                    Box6.setEnabled(false);
                    Box7.setEnabled(false);
                    Box8.setEnabled(false);
                    Box9.setEnabled(false);
                    Box7.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Box1.animate().translationX(X - Box1.getWidth()/2 - Box1.getX()).translationY(Y - Box1.getHeight()/2 - Box1.getY()).setDuration(1000);
                            Box4.animate().translationX(X - Box4.getWidth()/2 - Box4.getX()).translationY(Y  -Box4.getHeight()/2 - Box4.getY()).setDuration(1000);
                            Box7.animate().translationX(X - Box7.getWidth()/2 - Box7.getX()).translationY(Y - Box7.getHeight()/2 - Box7.getY()).setDuration(1000);
                            leftvertical.animate().translationX(X - (leftvertical.getWidth()/2) - leftvertical.getX() + 100).scaleX(0).setDuration(1000);
                            Box7.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Box1.animate().alpha(0).setDuration(0);
                                    Box4.animate().alpha(0).setDuration(0);
                                    Box7.animate().translationYBy(-150).setDuration(1000);
                                    textView.animate().alpha(1).setDuration(1000);
                                    button.animate().alpha(1).setDuration(1000);
                                    button.setEnabled(true);
                                }
                            }, 1000);
                        }
                    }, 1000);
                }
                else if (Check() == 7)
                {
                    grid.animate().alpha(0).setDuration(300);
                    Box1.animate().alpha(0).setDuration(300);
                    Box3.animate().alpha(0).setDuration(300);
                    Box4.animate().alpha(0).setDuration(300);
                    Box6.animate().alpha(0).setDuration(300);
                    Box7.animate().alpha(0).setDuration(300);
                    Box9.animate().alpha(0).setDuration(300);

                    centervertical.animate().scaleX(1).setDuration(500);
                    Box1.setEnabled(false);
                    Box2.setEnabled(false);
                    Box3.setEnabled(false);
                    Box4.setEnabled(false);
                    Box5.setEnabled(false);
                    Box6.setEnabled(false);
                    Box7.setEnabled(false);
                    Box8.setEnabled(false);
                    Box9.setEnabled(false);
                    Box8.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Box2.animate().translationY(Y - Box3.getHeight()/2 - Box3.getY()).setDuration(1000);
                            Box5.animate().translationY(Y  -Box5.getHeight()/2 - Box5.getY()).setDuration(1000);
                            Box8.animate().translationY(Y - Box7.getHeight()/2 - Box7.getY()).setDuration(1000);
                            centervertical.animate().scaleX(0).setDuration(1000);
                            Box8.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Box2.animate().alpha(0).setDuration(0);
                                    Box5.animate().alpha(0).setDuration(0);
                                    Box8.animate().translationYBy(-150).setDuration(1000);
                                    textView.animate().alpha(1).setDuration(1000);
                                    button.animate().alpha(1).setDuration(1000);
                                    button.setEnabled(true);
                                }
                            }, 1000);
                        }
                    }, 1000);
                }
                else if (Check() == 8)
                {
                    grid.animate().alpha(0).setDuration(300);
                    Box1.animate().alpha(0).setDuration(300);
                    Box2.animate().alpha(0).setDuration(300);
                    Box4.animate().alpha(0).setDuration(300);
                    Box5.animate().alpha(0).setDuration(300);
                    Box7.animate().alpha(0).setDuration(300);
                    Box8.animate().alpha(0).setDuration(300);

                    rightvertical.animate().scaleX(1).setDuration(500);
                    Box1.setEnabled(false);
                    Box2.setEnabled(false);
                    Box3.setEnabled(false);
                    Box4.setEnabled(false);
                    Box5.setEnabled(false);
                    Box6.setEnabled(false);
                    Box7.setEnabled(false);
                    Box8.setEnabled(false);
                    Box9.setEnabled(false);
                    Box9.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Box3.animate().translationX(X - Box3.getWidth()/2 - Box3.getX()).translationY(Y - Box3.getHeight()/2 - Box3.getY()).setDuration(1000);
                            Box6.animate().translationX(X - Box6.getWidth()/2 - Box6.getX()).translationY(Y  -Box6.getHeight()/2 - Box6.getY()).setDuration(1000);
                            Box9.animate().translationX(X - Box9.getWidth()/2 - Box9.getX()).translationY(Y - Box9.getHeight()/2 - Box9.getY()).setDuration(1000);
                            rightvertical.animate().translationX(X - (rightvertical.getWidth()/2) - rightvertical.getX() + 100).scaleX(0).setDuration(1000);
                            Box9.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Box3.animate().alpha(0).setDuration(0);
                                    Box6.animate().alpha(0).setDuration(0);
                                    Box9.animate().translationYBy(-150).setDuration(1000);
                                    textView.animate().alpha(1).setDuration(1000);
                                    button.animate().alpha(1).setDuration(1000);
                                    button.setEnabled(true);
                                }
                            }, 1000);
                        }
                    }, 1000);
                }
                else if (Check() == 9)
                {
                    grid.animate().alpha(0).setDuration(300);
                    Box1.animate().alpha(0).setDuration(300);
                    Box2.animate().alpha(0).setDuration(300);
                    Box3.animate().alpha(0).setDuration(300);
                    Box4.animate().alpha(0).setDuration(300);
                    Box5.animate().alpha(0).setDuration(300);
                    Box6.animate().alpha(0).setDuration(300);
                    Box7.animate().alpha(0).setDuration(300);
                    Box8.animate().alpha(0).setDuration(300);
                    Box9.animate().alpha(0).setDuration(300);
                    Box1.setEnabled(false);
                    Box2.setEnabled(false);
                    Box3.setEnabled(false);
                    Box4.setEnabled(false);
                    Box5.setEnabled(false);
                    Box6.setEnabled(false);
                    Box7.setEnabled(false);
                    Box8.setEnabled(false);
                    Box9.setEnabled(false);
                    textView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imageX.animate().alpha(1).setDuration(1000);
                            imageO.animate().alpha(1).setDuration(1000);
                            textView.setText("Draw!!");
                            textView.animate().alpha(1).setDuration(1000);
                            button.animate().alpha(1).setDuration(1000);
                            button.setEnabled(true);
                        }
                    },300);
                }
            }
        };
        Box1.setOnClickListener(clickListener);
        Box2.setOnClickListener(clickListener);
        Box3.setOnClickListener(clickListener);
        Box4.setOnClickListener(clickListener);
        Box5.setOnClickListener(clickListener);
        Box6.setOnClickListener(clickListener);
        Box7.setOnClickListener(clickListener);
        Box8.setOnClickListener(clickListener);
        Box9.setOnClickListener(clickListener);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
    }
}