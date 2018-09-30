package com.feeder.android;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.feeder.android.util.ImageLoaderManager;
import com.feeder.common.LogUtil;
import com.feeder.android.util.StatManager;
import com.feeder.common.SPManager;
import com.feeder.common.ThreadManager;
import com.feeder.domain.AssertManager;
import com.feeder.domain.DBManager;
import com.feeder.domain.inoreader.InoreaderManager;
import com.feeder.domain.model.AccountModel;
import com.feeder.domain.net.VolleySingleton;

import me.zsr.feeder.BuildConfig;
import me.zsr.feeder.R;

/**
 * @description:
 * @author: Match
 * @date: 7/22/16
 */
// Mark : use account as collection
public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        LogUtil.enable(BuildConfig.DEBUG);
        LogUtil.d("App Init");

        // Need to init first start ******************

        ThreadManager.init();
        VolleySingleton.init(this);

        SPManager.init(this);

        DBManager.init(this);

        StatManager.init(this);

        ImageLoaderManager.init(this);

        AssertManager.setEnabled(BuildConfig.DEBUG);

        InoreaderManager.getInstance().init(BuildConfig.INOREADER_CLIENT_SECRET);

        // Need to init first end ******************

        AccountModel.setDefaultAccountName(getResources().getString(R.string.default_account_name));
    }

    /**
     * 分割 Dex 支持* @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }




}
