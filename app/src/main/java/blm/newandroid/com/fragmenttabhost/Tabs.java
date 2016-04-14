package blm.newandroid.com.fragmenttabhost;

/**
 * Created by BLM on 2016/4/14.
 */
public class Tabs {
    private int title;
    private int icon;
    private Class fragment;

    public Tabs(int title, int icon, Class fragment) {
        this.title = title;
        this.icon = icon;
        this.fragment = fragment;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
