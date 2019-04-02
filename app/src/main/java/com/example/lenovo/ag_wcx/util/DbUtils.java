package com.example.lenovo.ag_wcx.util;

import com.example.lenovo.ag_wcx.MyApp;
import com.example.lenovo.ag_wcx.bean.Item;
import com.example.lenovo.ag_wcx.dao.DaoMaster;
import com.example.lenovo.ag_wcx.dao.DaoSession;
import com.example.lenovo.ag_wcx.dao.ItemDao;

import java.util.List;

public class DbUtils {
    private static DbUtils dbUtils;
    private final ItemDao itemDao;

    public DbUtils() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(), "item.db");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());

        DaoSession daoSession = daoMaster.newSession();

        itemDao = daoSession.getItemDao();
    }

    public static DbUtils getDbUtils() {
        if (dbUtils == null){
            synchronized (DbUtils.class){
                if (dbUtils == null){
                    dbUtils = new DbUtils();
                }
            }
        }
        return dbUtils;
    }
    //插入
    public void insert(Item item){
        if (has(item)){
            return;
        }
        dbUtils.itemDao.insertOrReplace(item);
    }
    //全查
    public List<Item> queryAll(){

        return dbUtils.itemDao.queryBuilder().list();
    }
    public boolean has(Item item){
        List<Item> list = dbUtils.itemDao.queryBuilder().where(ItemDao.Properties.Name.eq(item.getName())).list();
        if (list!=null&&list.size()>0){
            return true;
        }
        return false;
    }
}
