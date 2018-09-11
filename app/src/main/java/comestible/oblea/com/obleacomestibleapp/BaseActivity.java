package comestible.oblea.com.obleacomestibleapp;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

/*
    Created By Victor Ramayo
 */
public class BaseActivity extends AppCompatActivity {

    public SweetAlertDialog mSweetAlertDialog;

    protected void showBackButton() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void showHomeButton() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    public void setActionbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
