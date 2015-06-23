package lennux.com.mx.todolist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import lennux.com.mx.todolist.database.DatabaseHelper;

/**
 * Created by mobilestudio06 on 17/06/15.
 */
public class DatabaseAdapter {
    private static DatabaseHelper mDbHelper;
    private static SQLiteDatabase mDb;

    public static boolean openDB ( Context context){
        if (mDbHelper != null)
            mDbHelper.close();

        mDbHelper = new DatabaseHelper(context);
        try {
            mDb = mDbHelper.getWritableDatabase();
            return true;

        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static SQLiteDatabase getDB(Context context){
        if (mDb == null)
            openDB(context);

        return mDb;
    }

}
