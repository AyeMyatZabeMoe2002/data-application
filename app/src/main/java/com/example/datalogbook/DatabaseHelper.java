package com.example.datalogbook;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DBNAME ="testing";
    public static final String TABLE_NAME ="contact";
    public static final String CONTACT_ID ="_id";
    public static final String CONTACT_NAME ="name";
    public static final String CONTACT_DOB ="dob";
    public static final String CONTACT_EMAIL ="email";
    private SQLiteDatabase database;

    public  DatabaseHelper(Context context){
        super(context, DBNAME, null, 1);
        database = getWritableDatabase();
    }//end of constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableCreate ="create table "+TABLE_NAME+"("+
                CONTACT_ID+" integer primary key autoincrement,"+
                CONTACT_NAME+" text, "+CONTACT_DOB+" text, "+CONTACT_EMAIL+" text)";
        db.execSQL(tableCreate);
    }//end of onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable = "drop table if exists "+TABLE_NAME;
        db.execSQL(dropTable);
        onCreate(db);
    }//end of onUpgrade

    public long saveContact(Contact contact){

        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME,contact.getName());
        values.put(CONTACT_DOB,contact.getDob());
        values.put(CONTACT_EMAIL,contact.getEmail());

        long contact_id = database.insertOrThrow(TABLE_NAME,null,values);
        return contact_id;
    }//end of saveContact

    public ArrayList<Contact> getAllContacts(){

        database = getReadableDatabase();

        Cursor results = database.query(TABLE_NAME,
                new String[]{CONTACT_ID,CONTACT_NAME,CONTACT_DOB,CONTACT_EMAIL},
                null,null,null,null,null);

        ArrayList<Contact> contactArrayList = new ArrayList<>();
        results.moveToFirst();

        while(!results.isAfterLast()) {
            int id = results.getInt(0);
            String title = results.getString(1);
            String dob = results.getString(2);
            String email = results.getString(3);

            Contact contact = new Contact(id, title, dob, email);
            contactArrayList.add(contact);
            results.moveToNext();
        }//end of the loop
        return contactArrayList;
    }//end of getAllContacts

}//end of databasehelper
