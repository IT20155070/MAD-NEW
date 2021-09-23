package com.example.madnew.database;

import android.net.Uri;
import android.provider.BaseColumns;

public class OrderContract {

     public OrderContract(){

     }


     public static final String CONTENT_AUTHORITY = "com.example.madnew";
     public static final Uri BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
     public static final String PATH = "CUPCAKEOrder";

     public static abstract class  OrderEntry implements BaseColumns{

          public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH);

         public static final String TABLE_NAME = "CUPCAKEOrder" ;

          public static final String _ID = BaseColumns._ID;
          public static final String COLUMN_CAKENAME = "cake_name";
          public static final String COLUMN_QUANTITY = "quantity";
          public static final String COLUMN_PRICE = "price";
          public static final String COLUMN_CHIPS = "chips";
          public static final String COLUMN_DES = "desicates";
          public static final String COLUMN_NAME = "name";
          public static final String COLUMN_ADDRESS = "address";
          public static final String COLUMN_PHONE = "phone";
          public static final String COLUMN_DATE = "date";

     }



}
