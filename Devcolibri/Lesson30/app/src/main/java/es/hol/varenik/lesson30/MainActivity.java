package es.hol.varenik.lesson30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyAsyncTask  task ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = MyAsyncTask.getInitAsyncTask(this);

    }

    public void onStart (View v){
        task.execute();

    }
    public void onCancel (View v){
        task.cancel(false);
    }
    public void onStatus (View v){
        Toast.makeText(this, task.getStatus().toString(), Toast.LENGTH_SHORT).show();
    }
}
