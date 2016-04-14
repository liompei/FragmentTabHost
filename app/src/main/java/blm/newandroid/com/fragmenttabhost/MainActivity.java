package blm.newandroid.com.fragmenttabhost;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import blm.newandroid.com.fragmenttabhost.fragment_tabs.Fragment_1;
import blm.newandroid.com.fragmenttabhost.fragment_tabs.Fragment_2;
import blm.newandroid.com.fragmenttabhost.fragment_tabs.Fragment_3;
import blm.newandroid.com.fragmenttabhost.fragment_tabs.Fragment_4;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost fragmentTabHost;
    private LayoutInflater inflater;
    private List<Tabs> tabsList = new ArrayList<>(4);  //用于储存每个标签内容,4表示创建4个tabList对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabs();
    }

    private void initTabs() {
        //首先是Tabs的四个对象
        Tabs tabs1 = new Tabs(R.string.tab_1, R.mipmap.ic_launcher, Fragment_1.class);
        Tabs tabs2 = new Tabs(R.string.tab_2, R.mipmap.ic_launcher, Fragment_2.class);
        Tabs tabs3 = new Tabs(R.string.tab_3, R.mipmap.ic_launcher, Fragment_3.class);
        Tabs tabs4 = new Tabs(R.string.tab_4, R.mipmap.ic_launcher, Fragment_4.class);

        //将4个Tabs对象添加到List中
        tabsList.add(tabs1);
        tabsList.add(tabs2);
        tabsList.add(tabs3);
        tabsList.add(tabs4);

        inflater = LayoutInflater.from(this);
        fragmentTabHost = (FragmentTabHost) findViewById(R.id.tabHost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.mainContent);  //表示主内容的视图为定义的fragment内的视图

        for (Tabs tab : tabsList) {
            //分别设置
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildTabs(tab));
            fragmentTabHost.addTab(tabSpec, tab.getFragment(), null);
        }
        fragmentTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);  //去掉分割线
        fragmentTabHost.setCurrentTab(0);  //默认选择第一个

    }

    //传入一个Tabs对象,返回一个View
    private View buildTabs(Tabs tabs) {
        View view = inflater.inflate(R.layout.tabsindicator, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_icon);
        TextView textView = (TextView) view.findViewById(R.id.tab_text);

        //设置图片和文字
        imageView.setBackgroundResource(tabs.getIcon());
        textView.setText(tabs.getTitle());

        return view;
    }
}
