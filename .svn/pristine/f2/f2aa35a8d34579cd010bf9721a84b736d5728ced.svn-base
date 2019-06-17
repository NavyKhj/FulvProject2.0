package com.tcps.fulvproject.ui.adapter;

import android.support.v4.content.ContextCompat;

import com.tcps.common_module.baseAdapter.BaseRecycleAdapter;
import com.tcps.common_module.baseApplication.app;
import com.tcps.fulvproject.R;
import com.tcps.fulvproject.entity.HomeHorRecycleEntity;

import java.util.List;

/**
 * Create by khj on 2019-1-9
 **/
public class HomeVerRecycleAdapter extends BaseRecycleAdapter<HomeHorRecycleEntity> {
    private List<HomeHorRecycleEntity> list;

    /**
     * @param list      list
     * @param viewsType itemsType quantity
     */
    public HomeVerRecycleAdapter(List<HomeHorRecycleEntity> list, int viewsType) {
        super(list, viewsType);
        this.list = list;
    }

    @Override
    public int getLayoutId(int ViewType) {
        return R.layout.item_home_ver_recycle;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        if (position % 2 == 0)
            holder.getView(R.id.item_parent).setBackground(ContextCompat.getDrawable(app.getApplication(), R.drawable.sel_home_ver_recycle_bg_1));
        else
            holder.getView(R.id.item_parent).setBackground(ContextCompat.getDrawable(app.getApplication(), R.drawable.sel_home_ver_recycle_bg_2));
        holder.setItemImage(app.getApplication(), holder.getView(R.id.item_img), list.get(position).getImgRes());
        holder.setItemText(holder.getView(R.id.item_title), list.get(position).getText());
    }
}
