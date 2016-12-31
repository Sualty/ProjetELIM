package blou.elim;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by blou on 28/12/16.
 */
//class which defines the database on the phone
//this database is going to store data when there is no internet connection

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    private static final String DATE_FORMAT = "yyyy MMM dd HH:mm:ss";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_KIND+ " TEXT," +
                    FeedEntry.COLUMN_DATE+ " TEXT"+ " );";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;


    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "datas";
        public static final String COLUMN_KIND = "kind";
        public static final String COLUMN_DATE = "day";
    }

    public FeedReaderDbHelper(Context context) {
        super(context,"HELPER",null,1);//context name factory version
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("LALALALA",SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("LALALALA UPGRADE",SQL_CREATE_ENTRIES);
        onCreate(db);
    }

    public void addData(String kind,SQLiteDatabase db) {
        Date date = new Date();//date of now
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String date_str = sdf.format(date);

        String SQL_ADDING_DATA = "INSERT INTO "+FeedEntry.TABLE_NAME+" ("+FeedEntry.COLUMN_KIND+", "+FeedEntry.COLUMN_DATE+")"
                +" VALUES ('"+kind+"','"+date_str+"');";
        Log.d("LALALALA ADD",SQL_ADDING_DATA);
        db.execSQL(SQL_ADDING_DATA);
    }

    public void clearDatabase(SQLiteDatabase db) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public String getDateFormat() {
        return DATE_FORMAT;
    }
}
