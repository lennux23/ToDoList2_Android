package bytemx.com.mx.todolistn_android.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import bytemx.com.mx.todolistn_android.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_add_task,null);


        setContentView(view);
        /*songs = Song.getSongs(getApplicationContext());
        fragmentManager = getSupportFragmentManager();

        if (resourcesType.equals("sw600dp")||resourcesType.equals("sw320dp-land")){
            fragmentManager.beginTransaction()
                    .replace(R.id.containerLeft, ListSongsFragment.newInstance(songs))
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, ListSongsFragment.newInstance(songs))
                    .commit();

        }*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
