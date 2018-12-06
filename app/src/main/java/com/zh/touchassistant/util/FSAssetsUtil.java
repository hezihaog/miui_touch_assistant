package com.zh.touchassistant.util;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Package: me.wally.arch.util
 * FileName: FSAssetsUtil
 * Date: on 2018/11/12  下午9:37
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class FSAssetsUtil {
    private FSAssetsUtil() {
    }

    public static String getAssetsString(Context context, String fileName) throws IOException {
        ByteArrayOutputStream bos = null;
        InputStream is = null;
        try {
            is = context.getApplicationContext().getAssets().open(fileName);
            if (is == null) {
                throw new NullPointerException("assets文件夹下不存在" + fileName + "文件");
            }
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[4 * 1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            return new String(bos.toByteArray(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            FSUtil.close(is);
            FSUtil.close(bos);
        }
    }
}