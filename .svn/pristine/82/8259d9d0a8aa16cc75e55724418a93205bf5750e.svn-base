package com.tcps.fulvproject.ui.adapter;

import com.tcps.common_module.baseAdapter.BaseRecycleAdapter;
import com.tcps.common_module.baseApplication.app;
import com.tcps.fulvproject.R;
import com.tcps.fulvproject.entity.HomeHorRecycleEntity;

import java.util.List;

/**
 * Create by khj on 2019-1-8
 **/
public class HomeHorRecycleAdapter extends BaseRecycleAdapter<HomeHorRecycleEntity> {
    private List<HomeHorRecycleEntity> list;

    /**
     * @param list      list
     * @param viewsType itemsType quantity
     */
    public HomeHorRecycleAdapter(List<HomeHorRecycleEntity> list, int viewsType) {
        super(list, viewsType);
        this.list = list;
    }

    @Override
    public int getLayoutId(int ViewType) {
        return R.layout.item_home_hor_recycle;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        holder.setItemImage(app.getApplication(), holder.getView(R.id.item_img), list.get(position).getImgRes());
        holder.setItemText(holder.getView(R.id.item_title), list.get(position).getText());
    }
}
