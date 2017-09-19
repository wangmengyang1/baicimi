package com.baicimi.ui;

import com.baicimi.bean.Categories;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/31.
 * json解析
 */
public class JSONUtils {
    /**
     * 解析分类列表接口
     */
    public static List<Categories> getClassifyData(JSONObject object) {
        List<Categories> datas = new ArrayList<Categories>();
        List<Categories.Subcategories> data = new ArrayList<Categories.Subcategories>();
        if (object != null) {
            try {
                int code = object.getInt("code");
                if (code == 200) {

                    Gson gson = new Gson();
                    JSONObject object2 = object.getJSONObject("data");
                    JSONArray array = object2.getJSONArray("categories");

                    for (int j = 0; j < array.length(); j++) {
                        Categories categories = new Categories();
                        JSONObject obj = array.getJSONObject(j);
                        String name = obj.getString("name");
                        JSONArray arr = obj.getJSONArray("subcategories");
                        TypeToken<List<Categories.Subcategories>> tt = new TypeToken<List<Categories.Subcategories>>() {
                        };
                        categories.setName(name);
                        data = gson.fromJson(arr.toString(), tt.getType());
                        categories.setSubcategories(data);
                        datas.add(categories);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return datas;

    }


    /**
     * 解析注册接口
     */
    public static List<Categories> getRegistData(JSONObject object) {
        List<Categories> datas = new ArrayList<Categories>();
        List<Categories.Subcategories> data = new ArrayList<Categories.Subcategories>();
        if (object != null) {
            try {
                int code = object.getInt("code");
                if (code == 200) {

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return datas;

    }
}
