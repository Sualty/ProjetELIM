package blou.elim;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by blou on 28/12/16.
 */

//class which defines the database on the phone
//this database is going to store data when there is no internet connection

//http://stackoverflow.com/questions/7363112/best-way-to-work-with-dates-in-android-sqlite
public class FeedReaderDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_KIND+ "TEXT" + "," +
                    FeedEntry.COLUMN_DATE+ "TEXT"+ " )";

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
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void clearDatabase(SQLiteDatabase db) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
