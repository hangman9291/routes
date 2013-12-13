package com.andy.routes.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.andy.routes.classes.Location;

import java.util.ArrayList;

public class LocationsHandler extends SQLiteOpenHelper
{
    //region Constant Variables
    private static final int DATABASE_VERSION   = 1;
    private static final String DATABASE_NAME   = "locationsManager";
    private static final String TABLE_LOCATIONS = "locations";
    //endregion

    //region Keys
    private static final String KEY_ID       = "id";
    private static final String KEY_NAME     = "name";
    private static final String KEY_ADDRESS  = "address";
    private static final String KEY_CITY     = "city";
    private static final String KEY_STATE    = "state";
    private static final String KEY_ZIP_CODE = "zip_code";
    //endregion

    public LocationsHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //endregion
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_LOCATIONS_TABLE = "CREATE TABLE "
                + TABLE_LOCATIONS
                + "("
                    + KEY_ID       + " INTEGER PRIMARY KEY,"
                    + KEY_NAME     + " TEXT,"
                    + KEY_ADDRESS  + " TEXT,"
                    + KEY_CITY     + " TEXT,"
                    + KEY_STATE    + " TEXT,"
                    + KEY_ZIP_CODE + " TEXT"
                + ")";
        db.execSQL(CREATE_LOCATIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        onCreate(db);
    }

    public void addLocation(Location location)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = putValuesForLocation(location);

        db.insert(TABLE_LOCATIONS, null, values);
        db.close();
    }

    public ArrayList<Location> getLocations()
    {
        ArrayList<Location> locationsList = new ArrayList<Location>();
        String query = "SELECT  * FROM " + TABLE_LOCATIONS;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            do
            {
                Location location = new Location();
                location.setName(cursor.getString(0));
                location.setStreetAddress(cursor.getString(1));
                location.setCity(cursor.getString(2));
                location.setState(cursor.getString(3));
                location.setZipCode(cursor.getString(4));
                locationsList.add(location);
            }
            while (cursor.moveToNext());
        }

        return locationsList;
    }

    public int getLocationsCount()
    {
        String query = "SELECT  * FROM " + TABLE_LOCATIONS;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.close();
        return cursor.getCount();
    }

    public int updateLocation(Location location)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = putValuesForLocation(location);
        return db.update(TABLE_LOCATIONS, values, KEY_ID + " = ? ", new String[] { String.valueOf(location.getId()) });
    }

    public void deleteLocation(Location location)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_LOCATIONS, KEY_ID + " = ?", new String[] { String.valueOf(location.getId()) });
        db.close();
    }

    private ContentValues putValuesForLocation(Location location)
    {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, location.getId());
        values.put(KEY_NAME, location.getName());
        values.put(KEY_ADDRESS, location.getStreetAddress());
        values.put(KEY_CITY, location.getCity());
        values.put(KEY_STATE, location.getState());
        values.put(KEY_ZIP_CODE, location.getZipCode());
        return values;
    }
}
