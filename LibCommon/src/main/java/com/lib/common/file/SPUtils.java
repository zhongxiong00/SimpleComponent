package com.lib.common.file;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

import com.lib.common.app.AppConfig;
import com.lib.common.utils.AppUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import me.jessyan.autosize.utils.LogUtils;

/**
 * 作者： 钟雄辉
 * 时间： 2018/9/26
 * 描述： SP文件操作
 **/
public class SPUtils {
    Context context;
    String name;
    private static volatile SPUtils spUtils;
    private SharedPreferences sp;
    private static final String SP_NAME = "mysp";

    private SPUtils(Context context, String name) {
        this.context = context.getApplicationContext();
        this.name = name;
        sp = context.getSharedPreferences(this.name,
                Context.MODE_PRIVATE);
    }

    public static SPUtils getInstance() {
        if (spUtils == null) {
            synchronized (SPUtils.class) {
                if (spUtils == null) {
                    synchronized (SPUtils.class) {
                        if (AppConfig.getInstance().getApplication() != null) {
                            spUtils = new SPUtils(AppConfig.getInstance().getApplication(), SP_NAME);
                        } else {
                            throw new RuntimeException("you should init AppConfig");
                        }
                    }
                }
            }
        }
        return spUtils;
    }

    /**
     * 针对复杂类型存储<对象>
     *
     * @param key
     * @param object
     */
    public void setObject(String key, Object object) {
        if (sp == null) {
            return;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(baos);
            out.writeObject(object);
            String objectVal = new String(Base64.encode(baos.toByteArray(),
                    Base64.DEFAULT));
            Editor editor = sp.edit();
            editor.putString(key, objectVal);
            editor.commit();

        } catch (IOException e) {
            LogUtils.e("序列化失败： " + e.toString());
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                LogUtils.e("序列化失败： " + e.toString());
                e.printStackTrace();
            }
        }
    }

    public void removeObject(String key) {
        if (sp != null && sp.contains(key)) {
            sp.edit().remove(key).commit();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(String key) {
        if (sp != null && sp.contains(key)) {
            String objectVal = sp.getString(key, null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                return (T) ois.readObject();
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void clear() {
        if (context == null) {
            return;
        }
        SharedPreferences preferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}
