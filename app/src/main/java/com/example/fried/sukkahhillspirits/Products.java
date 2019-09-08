package com.example.fried.sukkahhillspirits;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Products extends AppCompatActivity {
    Integer[] Spirits = {R.drawable.etrog, R.drawable.besamim, R.drawable.cali, R.drawable.etrogback, R.drawable.besamimback, R.drawable.caliback};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String toast = new String();
                switch (position) {
                    case 0:
                        toast = "Etrog Liqueur front label";
                        break;
                    case 1:
                        toast = "Besamim Liqueur front label";
                        break;
                    case 2:
                        toast = "Cali Whiskey front label";
                        break;
                    case 3:
                        toast = "Etrog Liqueur back label";
                        break;
                    case 4:
                        toast = "Besamim Liqueur back label";
                        break;
                    case 5:
                        toast = "Cali Whiskey back label";
                        break;
                }
                Toast.makeText(getBaseContext(),toast, Toast.LENGTH_SHORT).show();
                pic.setImageResource(Spirits[position]);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter{
        private Context context;
        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return Spirits.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            pic = new ImageView(context);
            pic.setImageResource(Spirits[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }
    }
}
