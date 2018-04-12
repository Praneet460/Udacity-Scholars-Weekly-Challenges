package com.slack.weeklychallengeone.utils;

import android.os.Build;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

/**
 * Utility class for Text Appearance related modifications done using classes like {@link Spannable}
 *
 * @author Kaushik N Sanji
 */
public class TextAppearanceUtility {

    /**
     * Method that sets the Html Text content on the TextView passed
     *
     * @param textView      is the TextView on which the Html content needs to be set
     * @param htmlTextToSet is the String containing the Html markup that needs to be set on the TextView
     */
    public static void setHtmlText(TextView textView, String htmlTextToSet) {
        //Initializing a SpannableStringBuilder to build the text
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //For Android N and above
            spannableStringBuilder.append(Html.fromHtml(htmlTextToSet, Html.FROM_HTML_MODE_COMPACT));
        } else {
            //For older versions
            spannableStringBuilder.append(Html.fromHtml(htmlTextToSet));
        }
        //Setting the Spannable Text on TextView with the SPANNABLE Buffer type,
        //for later modification on spannable if required
        textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

}
