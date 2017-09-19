package com.baicimi.ui;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;

import com.baicimi.R;
import com.baicimi.entity.CityEneity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * 文件名：InfoCityUtils
 * 描    述：城市数据库管理类
 * 作    者：穆琨
 * 时    间：2016-01-18
 * 版    权：
 */
public class InfoCityUtils {
    private static InfoCityUtils InfoCityUtils;
    public static final String PACKAGE_NAME = "baby.pandie.com.ibobo";
    /**
     * 数据库在手机系统内存里的路径
     */
    private static String DATABASE_PATH = "/data"
            + Environment.getDataDirectory() + "/" + PACKAGE_NAME + "/databases/";
    /**
     * 数据库的名称
     */
    public static final String dbName = "mzk_db";
    private SQLiteDatabase mSDB;

    public static InfoCityUtils getInstance(Context context) {
        initDataBase(context);
        if (InfoCityUtils == null) {
            InfoCityUtils = new InfoCityUtils();
        }
        return InfoCityUtils;

    }

    /**
     * 初试化数据库
     */
    private static void initDataBase(Context context) {
        boolean dbExist = checkDataBase();
        if (dbExist) {

        } else {
            // 如果不存在，则将raw里的数据存入手机sd卡
            copyDataBase(context);
        }
    }

    /**
     * 复制数据库到手机指定文件夹下
     *
     * @throws IOException
     */
    private static void copyDataBase(Context context) {
        String databaseFilenames = DATABASE_PATH + dbName;
        File dir = new File(DATABASE_PATH);
        FileOutputStream os = null;
        InputStream is = null;
        // 判断文件夹是否存在，不存在就创建一个
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            // 得到数据库的输出流
            os = new FileOutputStream(databaseFilenames);
            // 得到数据文件的输入流
            is = context.getResources().openRawResource(R.raw.mzk_db);
            byte[] buffer = new byte[8192];
            int count = 0;
            while ((count = is.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
            // 之所以不在这里初始化，是因为这边是静态的方法，而mSDB并没有设置为静态的，也不推荐设为静态的
            // mSDB = SQLiteDatabase.openOrCreateDatabase(DATABASE_PATH +
            // dbName, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 判断数据库是否存在
     *
     * @return
     */
    private static boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        String databaseFilename = DATABASE_PATH + dbName;
        // 要自己加上try catch方法
        try {
            // 返回最新的数据库
            checkDB = SQLiteDatabase.openDatabase(databaseFilename, null,
                    SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            // TODO: handle exception
        }

        if (checkDB != null) {
            checkDB.close();
        }
        // 如果checkDB为null，则没有数据库，返回false
        return checkDB == null ? false : true;
    }

    /**
     * 查询所有省份的信息
     *
     * @return 省份信息
     */
    public ArrayList<CityEneity> queryProvince() {
        // 创建数据库
        mSDB = SQLiteDatabase.openOrCreateDatabase(DATABASE_PATH + dbName, null);
        ArrayList<CityEneity> list = new ArrayList<CityEneity>();
        String sql = "select * from fs_province";
        Cursor cursor = mSDB.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            CityEneity city = new CityEneity();
            String id = cursor.getString(cursor.getColumnIndex("ProvinceID"));
            String name = cursor.getString(cursor.getColumnIndex("ProvinceName"));
            city.setName(name);
            city.setId(id);
            list.add(city);
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }

    /**
     * 通过省份来查找城市
     *
     * @param provinceId 省份的id
     * @return 该省的所有城市
     */
    public ArrayList<CityEneity> queryCityByProvince(String provinceId) {

        // 创建数据库
        mSDB = SQLiteDatabase.openOrCreateDatabase(DATABASE_PATH + dbName, null);
        ArrayList<CityEneity> list = new ArrayList<CityEneity>();
        String sql = "select * from fs_city where ProvinceID=" + provinceId;
        Cursor cursor = mSDB.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            CityEneity city = new CityEneity();
            String id = cursor.getString(cursor.getColumnIndex("CityID"));
            String name = cursor.getString(cursor.getColumnIndex("CityName"));
            city.setName(name);
            city.setId(id);
            list.add(city);
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;

    }

    /**
     * 通过城市来查找县区
     *
     * @return 该省的所有城市
     */
    public ArrayList<CityEneity> queryDistrictByCity(String cityId) {

        // 创建数据库
        mSDB = SQLiteDatabase
                .openOrCreateDatabase(DATABASE_PATH + dbName, null);
        ArrayList<CityEneity> list = new ArrayList<CityEneity>();
        String sql = "select * from fs_district where CityID=" + cityId;
        Cursor cursor = mSDB.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            CityEneity city = new CityEneity();
            String id = cursor.getString(cursor.getColumnIndex("DistrictID"));
            String name = cursor.getString(cursor
                    .getColumnIndex("DistrictName"));
            city.setName(name);
            city.setId(id);
            list.add(city);
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;

    }

    public void closeDataBase() {
        if (mSDB != null) {
            mSDB.close();
        }
    }
}
