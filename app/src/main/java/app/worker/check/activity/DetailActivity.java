package app.worker.check.activity;

import android.os.Bundle;
import android.view.MenuItem;

import app.worker.check.kakasubstitutedriving.R;

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.label_activity_detail));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {

            // 왼쪽 메뉴
            case android.R.id.home :

                finish();

                break;


        }

        return super.onOptionsItemSelected(item);
    }


}