package com.slack.weeklychallengeone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.slack.weeklychallengeone.utils.Model
import com.slack.weeklychallengeone.utils.MyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var mArrayList: ArrayList<Model>? = null
    private var mAdapter: MyAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        loadData()
    }


    private fun initViews() {
        activity_recycler_view.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        activity_recycler_view.layoutManager = layoutManager
    }


    private fun loadData() {

        val mDescConstraint = "A ConstraintLayout is a ViewGroup which allows you to position and size widgets in a flexible way.\n" +
                "\n" +
                "Note: ConstraintLayout is available as a support library that you can use on Android systems starting with API level 9 (Gingerbread).\n" +
                "\n" +
                "As such, we are planning on enriching its API and capabilities over time. This documentation will reflect those changes."
        val mDescLinearLayout = "LinearLayout is a view group that aligns all children in a single direction, vertically or horizontally.\n" +
                "\n" +
                "You can specify the layout direction with the android:orientation attribute."
        val mDescRelativeLayout = "RelativeLayout is a view group that displays child views in relative positions.\n" +
                "\n" +
                "The position of each view can be specified as relative to sibling elements (such as to the left-of or below another view)\n" +
                "\n" +
                "or in positions relative to the parent RelativeLayout area (such as aligned to the bottom, left or center)."

        val mDescScrollView = "A view group that allows the view hierarchy placed within it to be scrolled.\n" +
                "\n" +
                "Scroll view may have only one direct child placed within it.\n" +
                "\n" +
                "To add multiple views within the scroll view, make the direct child you add a view group, for example LinearLayout,\n" +
                "\n" +
                "and place additional views within that LinearLayout."

        val mDescGridView = "GridView is a ViewGroup that displays items in a two-dimensional,\n" +
                "\n" +
                "scrollable grid. The grid items are automatically inserted to the layout using a ListAdapter."

        val mDescCardView = "A FrameLayout with a rounded corner background and shadow.\n" +
                "\n" +
                "CardView uses elevation property on Lollipop for shadows and falls back to a custom emulated shadow implementation on older platforms."
        mArrayList = ArrayList()

        mArrayList!!.add(Model("Constraint Layout", mDescConstraint))
        mArrayList!!.add(Model("Linear Layout", mDescLinearLayout))
        mArrayList!!.add(Model("Relative Layout", mDescRelativeLayout))
        mArrayList!!.add(Model("Card View", mDescCardView))
        mArrayList!!.add(Model("Scroll Views", mDescScrollView))
        mArrayList!!.add(Model("Grid View", mDescGridView))
        mAdapter = MyAdapter(mArrayList!!)
        activity_recycler_view.adapter = mAdapter
    }
}