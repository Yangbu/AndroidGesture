package com.example.gesturegame;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import net.sqlcipher.database.SQLiteDatabase;
//import net.sqlcipher.database.SQLiteDatabase.CursorFactory;
//import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * Created by HL on 30-09-2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contacts.db";

    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="uname";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_STAGE="name";
    private static final String COLUMN_PASS="pass";

    SQLiteDatabase db;

    private static final String TABLE_CREATE="create table contacts(id integer primary key not null ,"+
            "uname text not null,email text not null,name text not null,pass text not null);";

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //Called when the database is first created, ued execSQL function to create the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;

    }

    //Insert new contact information
    public void insertContact(Contact c)
    {
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        String query="select * from contacts";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_STAGE,"0");
        values.put(COLUMN_PASS, c.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    
    //new
    public void modifyContact(String uname, String stage){
    		
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
    	values.put("name", stage);
    	String whereClause = "uname=?";
    	String[] whereArgs = new String[] { String.valueOf(uname)};
    	db.update(TABLE_NAME, values, whereClause, whereArgs);
    }

    
    public String searchPass(String uname)
    {
        db=this.getReadableDatabase();
        String query="select uname, pass from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String input,b;
        b="not found";
        if (cursor.moveToFirst())
        {
            do {
                input=cursor.getString(0);
                if (input.equals(uname))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    
    //new
    public String searchStage(String uname)
    {
        db=this.getReadableDatabase();
        String query="select uname, name from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String input,b;
        b="not found";
        if (cursor.moveToFirst())
        {
            do {
                input=cursor.getString(0);
                if (input.equals(uname))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }

}
