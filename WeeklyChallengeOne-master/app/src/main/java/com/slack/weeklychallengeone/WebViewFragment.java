package com.slack.weeklychallengeone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thefinestartist.finestwebview.FinestWebView;

import java.util.Objects;

/**
 * Created by stemdot on 4/6/18,27
 */
public class WebViewFragment extends Fragment {
    private final String CONSTRAINT_LAYOUT_URL = "https://developer.android.com/training/constraint-layout/index.html";
    private final String LINEAR_LAYOUT_URL = "https://developer.android.com/guide/topics/ui/layout/linear.html";
    
    private final String RELATIVE_LAYOUT_URL = "https://developer.android.com/guide/topics/ui/layout/relative.html";
    
    private final String CARD_LAYOUT_URL = "https://developer.android.com/guide/topics/ui/layout/cardview.html";
    
    private final String SCROLLVIEW_LAYOUT_URL = "https://developer.android.com/reference/android/widget/ScrollView.html";
    private final String GRIDVIEW_LAYOUT_URL = "https://developer.android.com/guide/topics/ui/layout/gridview.html";
    
    
    
    private String urlArray[] = {CONSTRAINT_LAYOUT_URL,LINEAR_LAYOUT_URL,RELATIVE_LAYOUT_URL,CARD_LAYOUT_URL,SCROLLVIEW_LAYOUT_URL,GRIDVIEW_LAYOUT_URL};
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //First check bundle have a value or not
        Bundle  bundle = this.getArguments();
        int postion = 0;
        if (bundle != null){
             postion = getArguments().getInt("index");
        }
        
        
        new FinestWebView.Builder(Objects.requireNonNull(getActivity())).theme(R.style.FinestWebViewTheme)
                .titleDefault("Android Layouts")
                .showUrl(false)
                .statusBarColorRes(R.color.colorWebViewStatus)
                .toolbarColorRes(R.color.colorWebViewPrimary)
                .titleColorRes(R.color.finestWhite)
                .urlColorRes(R.color.colorAccent)
                .iconDefaultColorRes(R.color.finestWhite)
                .progressBarColorRes(R.color.finestWhite)
                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                .showSwipeRefreshLayout(true)
                .swipeRefreshColorRes(R.color.colorAccent)
                .menuSelector(R.drawable.selector_light_theme)
                .menuTextGravity(Gravity.CENTER)
                .menuTextPaddingRightRes(R.dimen.defaultMenuTextPaddingLeft)
                .dividerHeight(0)
                .showIconClose(false)
                .showIconForward(true)
                .showIconBack(true)
                .backPressToClose(true)
                .gradientDivider(false)
                .setCustomAnimations(R.anim.slide_up, R.anim.hold, R.anim.hold, R.anim.slide_down)
                .show(urlArray[postion]);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
