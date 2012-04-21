package jabara.uchiwa2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Uchiwa2Activity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final EditText text = (EditText) findViewById(R.id.text);

        final Button bt = (Button) findViewById(R.id.go);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View pView) {
                final Intent intent = new Intent(Uchiwa2Activity.this, SecondActivity.class);

                final String t = text.getText().toString();
                Log.d(Uchiwa2Activity.class.getSimpleName(), String.valueOf(t));

                intent.putExtra(Const.EX_INPUT_TEXT, t);

                startActivityForResult(intent, Const.RC_TEXT);
            }
        });
    }

    /**
     * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
     */
    @Override
    protected void onActivityResult(final int pRequestCode, final int pResultCode, final Intent pData) {
        if (pResultCode != RESULT_OK) {
            return;
        }
        if (pData == null) {
            return;
        }
        switch (pRequestCode) {
        case Const.RC_TEXT:
            popup(pData.getStringExtra(Const.EX_RETURN_TEXT));
            break;
        default:
            break;
        }
    }

    private void popup(final String pReturnText) {
        new AlertDialog.Builder(this) //
                .setTitle("選択されたテキストだよん") //
                .setMessage(pReturnText) //
                .setPositiveButton("OK", null) //
                .show();
    }
}