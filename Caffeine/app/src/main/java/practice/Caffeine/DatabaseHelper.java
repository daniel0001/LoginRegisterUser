package practice.Caffeine;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel on 18/02/2017.
 */

public final class DatabaseHelper extends SQLiteOpenHelper{

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "UserDetails.db";


    /* Inner class that defines the table contents */


        public static final String TABLE_NAME = "user";
        public static final String _ID = "_ID";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_USERID = "userID";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_LOCATIONID = "locationID";
        public static final String COLUMN_NAME_EMAIL = "email";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_USERNAME + " TEXT," +
                    COLUMN_NAME_USERID + " TEXT," +
                    COLUMN_NAME_NAME + " TEXT," +
                    COLUMN_NAME_PASSWORD + " TEXT," +
                    COLUMN_NAME_PHONE + " TEXT," +
                    COLUMN_NAME_LOCATIONID + " TEXT," +
                    COLUMN_NAME_EMAIL + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

        public  boolean insertData(String username, String userID, String name, String password, Integer phone, Integer locationID, String email){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME_USERNAME, username);
            values.put(COLUMN_NAME_USERID, userID);
            values.put(COLUMN_NAME_NAME , name);
            values.put(COLUMN_NAME_PASSWORD, password);
            values.put(COLUMN_NAME_PHONE, phone);
            values.put(COLUMN_NAME_LOCATIONID, locationID);
            values.put(COLUMN_NAME_EMAIL, email);
            long result = db.insert(TABLE_NAME, null, values);
            return result != -1;

            }
        }

