package bytemx.com.mx.todolistn_android.models;

import android.content.ContentValues;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

import bytemx.com.mx.todolistn_android.database.DatabaseAdapter;

/**
 * Created by mobilestudio06 on 17/06/15.
 */
public class Task {
    public static final String TABLE_NAME = "Task";
    public static final String TASK_ID = "taskId";
    public static final String TITLE = "title";
    public static final String PRIORITY = "priority";
    public static final String DESCRIPTION = "description";
    public static final String FK_STATUS_ID = "fk_statusId";
    public static final String TERM_LIMIT = "termLimit";
    public static final String CREATE_AT = "createdAt";
    public static final String UPDATE_AT = "updatedAt";

    private int taskId;
    private String title;
    private int priority;
    private String description;
    private int fk_statusId;
    private Date termLimit;
    private Date updatedAt;

    public Task(String title, int priority, String description, int fk_statusId, Date termLimit) {
        this.title = title;
        this.priority = priority;
        this.description = description;
        this.fk_statusId = fk_statusId;
        this.termLimit = termLimit;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFk_statusId() {
        return fk_statusId;
    }

    public void setFk_statusId(int fk_statusId) {
        this.fk_statusId = fk_statusId;
    }

    public Date getTermLimit() {
        return termLimit;
    }

    public void setTermLimit(Date termLimit) {
        this.termLimit = termLimit;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static long insert (Context context, Task task){
        ContentValues cv = new ContentValues();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cv.put(TITLE, task.getTitle());
        cv.put(PRIORITY, task.getPriority());
        cv.put(DESCRIPTION, task.getDescription());
        cv.put(FK_STATUS_ID, task.getFk_statusId());
        if (task.getTermLimit()!=null)
            cv.put(TERM_LIMIT, dateFormat.format(task.getTermLimit()));

        return DatabaseAdapter.getDB(context).insert(TABLE_NAME,null,cv);
    }
}

