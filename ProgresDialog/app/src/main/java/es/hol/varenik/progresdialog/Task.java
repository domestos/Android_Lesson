package es.hol.varenik.progresdialog;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

/**
 * Created by varenik on 14.02.16.
 */
public class Task extends AsyncTask<Void, Integer, Void> {
    private String TAG = "myLog";
    private MainActivity activity;
    private Button btn;

    public void link(MainActivity activity) {
        Log.d(TAG, "link(activity) = " + activity.hashCode());
        this.activity = activity;
    }

    public void unLink() {
        this.activity = null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
         btn= (Button) activity.findViewById(R.id.btnStartDialog);
        btn.setEnabled(false);
        activity.showDialog(true);
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            for (int i = 0; i < 20; i++) {
                TimeUnit.SECONDS.sleep(1);
                publishProgress(i);
                try {
                    Log.d(TAG, "task  = " + hashCode());
                    Log.d(TAG, "activity  = " + activity.hashCode());
                } catch (Exception e) {
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        try {

            if (activity.dialog == null || !activity.dialog.isShowing()) {
                Log.d(TAG, "dialog ne pokazye");
                activity.showDialog(true);
                btn.setEnabled(false);
            }
            activity.setTitle("" + values[0]);
        } catch (Exception e) {
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        activity.showDialog(false);
        btn.setEnabled(true);
    }


    @Override
    protected void onCancelled() {
        super.onCancelled();
        btn.setEnabled(true);

    }
}
