package com.zh.touchassistant.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzh.easythread.EasyThread;
import com.zh.touchassistant.R;
import com.zh.touchassistant.database.biz.IAutoHideFloatBiz;
import com.zh.touchassistant.database.biz.impl.AutoHideFloatBiz;
import com.zh.touchassistant.database.model.dto.AutoHideFloatDTO;
import com.zh.touchassistant.database.model.vo.AutoHideFloatVO;
import com.zh.touchassistant.model.AutoHideModel;
import com.zh.touchassistant.model.InstallAppInfoModel;
import com.zh.touchassistant.provider.ContextProvider;
import com.zh.touchassistant.util.AppInfoUtil;
import com.zh.touchassistant.util.singleton.ISingletonStorage;
import com.zh.touchassistant.widget.SwitchButton;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Package:</b> com.zh.touchassistant.ui.fragment <br>
 * <b>FileName:</b> AutoHideSettingFragment <br>
 * <b>Create Date:</b> 2018/12/17  下午4:19 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class AutoHideSettingFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<AutoHideModel> mDatas;
    private ProgressBar mWaitProgressBar;

    public static AutoHideSettingFragment newInstance() {
        return new AutoHideSettingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auto_hide, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ISingletonStorage storage = (ISingletonStorage) ContextProvider.get().getApplication();
        final AutoHideFloatBiz biz = storage.getInstance(IAutoHideFloatBiz.class, AutoHideFloatBiz.class);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mWaitProgressBar = view.findViewById(R.id.wait_progress_bar);
        mDatas = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final BaseQuickAdapter adapter = new BaseQuickAdapter<AutoHideModel, BaseViewHolder>(R.layout.item_local_install_app, mDatas) {
            @Override
            protected void convert(BaseViewHolder helper, final AutoHideModel item) {
                helper.setImageDrawable(R.id.app_icon_iv, item.getAppIcon());
                helper.setText(R.id.app_name_tv, item.getAppName());
                SwitchButton switchButton = helper.getView(R.id.auto_hide_switch);
                switchButton.setChecked(item.isAutoHide());
                if (switchButton.getCheckedChangeListener() == null) {
                    switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(SwitchButton button, boolean isChecked) {
                            //取消自动隐藏
                            AutoHideFloatDTO dto = new AutoHideFloatDTO();
                            dto.setAppPackageName(item.getPackageName());
                            if (isChecked) {
                                biz.addAutoHide(dto);
                            } else {
                                biz.removeAutoHide(dto);
                            }
                        }
                    });
                }
            }
        };
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));
        mWaitProgressBar.setVisibility(View.VISIBLE);
        EasyThread.Builder.createCacheable().build().execute(new Runnable() {
            @Override
            public void run() {
                //本机App列表
                List<InstallAppInfoModel> installAppInfoList = AppInfoUtil
                        .getInstallAppInfoList(getContext(), true);
                List<String> autoHideAppPackageNameList = getAutoHideAppPackageNameList();
                //过滤掉本应用
                autoHideAppPackageNameList.remove(getContext().getPackageName());
                for (InstallAppInfoModel installAppInfoModel : installAppInfoList) {
                    AutoHideModel autoHideModel = new AutoHideModel();
                    //是自动隐藏
                    if (autoHideAppPackageNameList.contains(installAppInfoModel.getPackageName())) {
                        autoHideModel.setAutoHide(true);
                    } else {
                        autoHideModel.setAutoHide(false);
                    }
                    autoHideModel.setAppIcon(installAppInfoModel.getAppIcon());
                    autoHideModel.setAppName(installAppInfoModel.getAppName());
                    autoHideModel.setPackageName(installAppInfoModel.getPackageName());
                    mDatas.add(autoHideModel);
                }
                adapter.notifyDataSetChanged();
                FragmentActivity activity = getActivity();
                if (activity != null && !activity.isFinishing()) {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mWaitProgressBar.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });
    }

    private List<String> getAutoHideAppPackageNameList() {
        ArrayList<String> result = new ArrayList<>();
        //已经存在的数据
        ISingletonStorage storage = (ISingletonStorage) ContextProvider.get().getApplication();
        AutoHideFloatBiz biz = storage.getInstance(IAutoHideFloatBiz.class, AutoHideFloatBiz.class);
        List<AutoHideFloatVO> autoHideAppList = biz.getAutoHideAppList();
        for (AutoHideFloatVO vo : autoHideAppList) {
            result.add(vo.getAppPackageName());
        }
        return result;
    }
}