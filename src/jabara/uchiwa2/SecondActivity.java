/**
 * 
 */
package jabara.uchiwa2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

/**
 * @author jabaraster
 */
public class SecondActivity extends ListActivity {

    /**
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);

        final String text = getIntent().getStringExtra(Const.EX_INPUT_TEXT);

        final String[] ss = { //
        text + "アイテム1", //
                text + "アイテム2", //
                text + "アイテム3", //
                text + "アイテム4", //
        };

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ss);
        setListAdapter(adapter);

        getListView().setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> pParent, final View pView, final int pIndex, final long pId) {
                final Intent intent = new Intent(SecondActivity.this, SecondActivity.class);
                intent.putExtra(Const.EX_RETURN_TEXT, ss[pIndex]);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
