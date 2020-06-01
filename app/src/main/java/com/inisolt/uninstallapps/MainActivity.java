package com.inisolt.uninstallapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<MyModel> installedList = new ArrayList<>();
    private ChineseAppList chineseAppList = new ChineseAppList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllInstalledApps();
    }

    private void getAllInstalledApps() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ApplicationInfo> pkgAppsList = this.getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo appname:
                pkgAppsList) {
            if ((appname.flags & ApplicationInfo.FLAG_SYSTEM) != 1) {
                if (chineseAppList.getChineseAppList().contains(appname.packageName)) {
                    installedList.add(new MyModel(appname.packageName, true));
                } else {
                    installedList.add(new MyModel(appname.packageName, false));
                }
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(this);
        mAdapter.addItems(installedList);
        recyclerView.setAdapter(mAdapter);

    }
}
