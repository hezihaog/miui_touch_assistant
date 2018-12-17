package com.zh.touchassistant.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.zh.touchassistant.model.InstallAppInfoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant.util <br>
 * <b>FileName:</b> AppInfoUtil <br>
 * <b>Create Date:</b> 2018/12/17  下午4:12 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AppInfoUtil {
    private AppInfoUtil() {
    }

    /**
     * 获取所有已安装的App信息，不包含系统应用
     * @param isFilterSystem 是否过滤系统应用
     */
    public static List<InstallAppInfoModel> getInstallAppInfoList(Context context, boolean isFilterSystem) {
        List<InstallAppInfoModel> appList = new ArrayList<>();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        List<PackageInfo> packages = packageManager.getInstalledPackages(0);
        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            if (isFilterSystem) {
                //过滤掉系统应用
                if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                    continue;
                }
            }
            InstallAppInfoModel infoModel = new InstallAppInfoModel();
            infoModel.setAppName(packageInfo.applicationInfo.loadLabel(packageManager).toString());
            infoModel.setPackageName(packageInfo.packageName);
            infoModel.setVersionName(packageInfo.versionName);
            infoModel.setVersionCode(packageInfo.versionCode);
            infoModel.setAppIcon(packageInfo.applicationInfo.loadIcon(packageManager));
            appList.add(infoModel);
        }
        return appList;
    }
}