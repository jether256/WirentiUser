package com.jether.wirentiuserapp.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jether.wirentiuserapp.Model.PropertyModel;

import java.util.ArrayList;
import java.util.List;


public class PropertyDatabase extends SQLiteOpenHelper {

    private static final String TAG =PropertyDatabase.class.getSimpleName() ;

    public PropertyDatabase(Context context) {
        super(context, Constants.DATABASE.DB_NAME,null,Constants.DATABASE.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
        db.execSQL(Constants.DATABASE.CREATE_TABLE_QUERY);
        }catch(SQLException ex){
            Log.d(TAG,ex.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Constants.DATABASE.DROP_QUERY);
        this.onCreate(db);

    }


    public void addPropertyList(PropertyModel propertyModel){

        Log.d(TAG,"Values Got"+propertyModel.getPropertyTitle());

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Constants.DATABASE.PROPERTY_ID,propertyModel.getID());
        values.put(Constants.DATABASE.USER_ID,propertyModel.getUserID());
        values.put(Constants.DATABASE.PROPERTY_TITLE,propertyModel.getPropertyTitle());
        values.put(Constants.DATABASE.PROPERTY_DESC,propertyModel.getPropertDescription());
        values.put(Constants.DATABASE.PROPERTY_TYPE,propertyModel.getType());
        values.put(Constants.DATABASE.PROPERTY_STATUS,propertyModel.getStatus());
        values.put(Constants.DATABASE.PROPERTY_LOCATION,propertyModel.getLocation());
        values.put(Constants.DATABASE.PROPERTY_IMAGE,Utils.getPictureByteOfArray(propertyModel.getPicture()));
        values.put(Constants.DATABASE.PROPERTY_ADDRESS,propertyModel.getAddress());
        values.put(Constants.DATABASE.PROPERTY_PRICE,propertyModel.getRentorsalePrice());
        values.put(Constants.DATABASE.PROPERTY_BED,propertyModel.getBedroom());
        values.put(Constants.DATABASE.PROPERTY_BATH,propertyModel.getBathrooms());
        values.put(Constants.DATABASE.PROPERTY_FLOORS,propertyModel.getFloors());
        values.put(Constants.DATABASE.PROPERTY_GARAGE,propertyModel.getGarages());
        values.put(Constants.DATABASE.PROPERTY_AREA,propertyModel.getArea());
        values.put(Constants.DATABASE.PROPERTY_SIZE,propertyModel.getSize());
        values.put(Constants.DATABASE.PROPERTY_UNIQUE_ID,propertyModel.getPropertyID());
        values.put(Constants.DATABASE.PROPERTY_COUNTRY,propertyModel.getCountry());
        values.put(Constants.DATABASE.PROPERTY_CITY,propertyModel.getCity());
        values.put(Constants.DATABASE.PROPERTY_STATE,propertyModel.getState());
        values.put(Constants.DATABASE.PROPERTY_ZIP,propertyModel.getZipCode());
        values.put(Constants.DATABASE.PROPERTY_DATE,propertyModel.getListingDate());


        try{
            db.insert(Constants.DATABASE.TABLE_NAME,null,values);
        }catch(Exception e){

        }


        db.close();

    }


    public List<PropertyModel> getProps(){

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor = db.rawQuery(Constants.DATABASE.GET_PROPERTY_QUERY,null);

        List<PropertyModel> propertyModelList= new ArrayList<>();

        if(cursor.getCount()>0){

            if(cursor.moveToFirst()){

                do{
                    PropertyModel propertyModel=new PropertyModel();
                    propertyModel.setPropertyID(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_ID)));
                    propertyModel.setUserID(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.USER_ID)));
                    propertyModel.setPropertyTitle(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_TITLE)));
                    propertyModel.setPropertDescription(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_DESC)));
                    propertyModel.setType(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_TYPE)));
                    propertyModel.setStatus(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_STATUS)));
                    propertyModel.setLocation(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_LOCATION)));
                    propertyModel.setAddress(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_ADDRESS)));
                    propertyModel.setRentorsalePrice(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_PRICE)));
                    propertyModel.setBedroom(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_BED)));
                    propertyModel.setBathrooms(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_BATH)));
                    propertyModel.setFloors(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_FLOORS)));
                    propertyModel.setGarages(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_GARAGE)));
                    propertyModel.setArea(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_AREA)));
                    propertyModel.setSize(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_SIZE)));
                    propertyModel.setPropertyID(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_UNIQUE_ID)));
                    propertyModel.setCountry(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_COUNTRY)));
                    propertyModel.setCity(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_CITY)));
                    propertyModel.setState(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_STATE)));
                    propertyModel.setZipCode(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_ZIP)));
                    propertyModel.setListingDate(cursor.getColumnName(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_DATE)));
                    propertyModel.setPicture(Utils.getBitmapFromByte(cursor.getBlob(cursor.getColumnIndex(Constants.DATABASE.PROPERTY_IMAGE))));

                    propertyModelList.add(propertyModel);

                }while(cursor.moveToNext());

            }

        }

        return propertyModelList;
    }

}
