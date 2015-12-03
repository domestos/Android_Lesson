package es.hol.varenik.lesson30;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by varenik on 03.12.15.
 */
public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    private static Context context;
    private static MyAsyncTask initAsyncTask;


    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i < 6; i++) {
            printAsyncHashCode();
            if (isCancelled()) {
                return null;
            }
            Log.i("MY_TASK", "Task working...");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public void printAsyncHashCode() {
        Log.i("MY_CODE", "Async CODE: " + hashCode() + " | " + context.hashCode() + " Activity CODE");
    }

    public static MyAsyncTask getInitAsyncTask(Context context) {
        if (initAsyncTask == null) {
            initAsyncTask = new MyAsyncTask();
            initAsyncTask.execute();
            }
        setContext(context);
        return initAsyncTask;
    }

    public static void setContext(Context context) {
        MyAsyncTask.context = context;
    }

    public static void setInitAsyncTask(MyAsyncTask initAsyncTask) {
        MyAsyncTask.initAsyncTask = initAsyncTask;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        initAsyncTask =null;
        super.onPostExecute(aVoid);
    }
}
