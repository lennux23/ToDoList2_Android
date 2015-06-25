package bytemx.com.mx.todolistn_android.models;

import android.content.ContentValues;
import android.content.Context;

import java.text.SimpleDateFormat;

import  bytemx.com.mx.todolistn_android.database.DatabaseAdapter;

/**
 * Created by mobilestudio06 on 17/06/15.
 */
public class Status {
    private static final String TABLE_NAME = "Status";
    private static final String STATUS_ID = "statusId";
    private static final String STATUS = "status";


    private int statusId;
    private String status;


    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Status(int statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }


    public static long insert (Context context, Status status){
        ContentValues cv = new ContentValues();
        cv.put(STATUS_ID, status.getStatusId());
        cv.put(STATUS, status.getStatus());

        return DatabaseAdapter.getDB(context).insert(TABLE_NAME,null,cv);
    }
}
