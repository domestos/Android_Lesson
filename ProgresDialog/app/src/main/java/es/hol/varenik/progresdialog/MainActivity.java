package es.hol.varenik.progresdialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    private String TAG = "myLog";
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = (Task) getLastCustomNonConfigurationInstance();
        if (task == null) {
            task = new Task();
            Log.d(TAG, "task = new Task() = " + task.hashCode());
        }
        task.link(this);
    }

    public void onCklick(View v) {
        if(task.isCancelled()){
            task = new Task();
            task.link(this);
            task.execute();

        }else{
            task.execute();

        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        task.unLink();
        Log.d(TAG, "task.unLink() = " + task.hashCode());

        return task;
    }

    public void showDialog(boolean run) {

        if (run) {
            dialog = new ProgressDialog(this);
            dialog.setTitle("Dialog");
            dialog.setMessage("Pleas Waite...");
            dialog.setButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    cancelTask();
                }
            });
            dialog.show();

        } else {

                dialog.dismiss();
        }

    }

    private void cancelTask() {
        if(task == null){
            return;
        }
        Log.d(TAG, "Cancel Task "+task.cancel(true));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "povorot");
        if(dialog.isShowing()){
        dialog.dismiss();}
    }
}
