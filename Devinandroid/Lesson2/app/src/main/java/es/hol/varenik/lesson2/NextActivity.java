package es.hol.varenik.lesson2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by varenik on 04.12.15.
 */


public class NextActivity extends Activity {

    ImageView img1;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);


        img1.setOnClickListener(myClick);
        img2.setOnClickListener(myClick);


    }


    View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.img1:
                    img2.setVisibility(View.VISIBLE);
                    img1.setVisibility(View.GONE);
                    break;
                case R.id.img2:
                    img1.setVisibility(View.VISIBLE);
                    img2.setVisibility(View.GONE);
                    break;
            }
        }
    };
}



