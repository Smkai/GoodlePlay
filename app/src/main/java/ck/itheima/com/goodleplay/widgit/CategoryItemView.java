package ck.itheima.com.goodleplay.widgit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ck.itheima.com.goodleplay.R;
import ck.itheima.com.goodleplay.bean.CategoryBean;

/**
 * 类名:    CategoryItemView
 * 创建者:  ckqu
 * 创建时间:2017/2/16 0016 下午 7:18
 * 包名:    ck.itheima.com.goodleplay.widgit
 * 更新者:  $Author$ $Date$
 * 描述:    分类的Item
 */

public class CategoryItemView extends LinearLayout {
    @BindView(R.id.tv_title)
    TextView    mTvTitle;
    @BindView(R.id.table_layout)
    TableLayout mTableLayout;

    public CategoryItemView(Context context) {
        this(context, null);
    }

    public CategoryItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_category_view, this);
        ButterKnife.bind(this, this);
    }


    public void bindView(CategoryBean categoryBean) {
        mTableLayout.removeAllViews();

        int screenWidth = getResources().getDisplayMetrics().widthPixels;//获取屏幕的宽度

        int maxWidth = screenWidth - mTableLayout.getPaddingLeft()-mTableLayout.getPaddingRight();

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();

        layoutParams.width = maxWidth / 3;

        mTvTitle.setText(categoryBean.title);//设置title

        for (int i = 0; i < categoryBean.infos.size(); i++) {
            TableRow tableRow = new TableRow(getContext());

            CategoryBean.InfosBean infosBean = categoryBean.infos.get(i);
            //添加三个item
            //添加第一个CategoryInfoItemView
            addFirstChild(layoutParams, tableRow, infosBean);
            //添加第二个CategoryInfoItemView
            addSecondChild(layoutParams, tableRow, infosBean);
            //添加第三个CategoryInfoItemView
            addThirdChild(layoutParams, tableRow, infosBean);

            mTableLayout.addView(tableRow);
        }
    }

    private void addThirdChild(LayoutParams layoutParams, TableRow tableRow, CategoryBean.InfosBean infosBean) {
           if (infosBean.getName3().length() > 0) {

               CategoryInfoItemView categoryInfoItemView1 = new CategoryInfoItemView(getContext());

               categoryInfoItemView1.setLayoutParams(layoutParams);

               categoryInfoItemView1.bindView(infosBean.name3, infosBean.url3);

               tableRow.addView(categoryInfoItemView1);
           }

    }

    private void addSecondChild(LayoutParams layoutParams, TableRow tableRow, CategoryBean.InfosBean infosBean) {

            CategoryInfoItemView categoryInfoItemView2 = new CategoryInfoItemView(getContext());
            categoryInfoItemView2.setLayoutParams(layoutParams);

            categoryInfoItemView2.bindView(infosBean.name2, infosBean.url2);

            tableRow.addView(categoryInfoItemView2);


    }

    private void addFirstChild(LayoutParams layoutParams, TableRow tableRow, CategoryBean.InfosBean infosBean) {

            CategoryInfoItemView categoryInfoItemView3 = new CategoryInfoItemView(getContext());
            categoryInfoItemView3.setLayoutParams(layoutParams);

            categoryInfoItemView3.bindView(infosBean.name1, infosBean.url1);

            tableRow.addView(categoryInfoItemView3);


    }
}
