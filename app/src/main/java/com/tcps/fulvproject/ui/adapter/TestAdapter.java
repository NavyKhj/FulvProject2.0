package com.tcps.fulvproject.ui.adapter;

import com.tcps.common_module.baseAdapter.BaseRecycleAdapter;
import com.tcps.fulvproject.R;

import java.util.List;

public class TestAdapter extends BaseRecycleAdapter<String> {
    private List<String> list;

    /**
     * @param list      list
     * @param viewsType itemsType quantity
     */
    public TestAdapter(List<String> list, int viewsType) {
        super(list, viewsType);
        this.list = list;
    }


    @Override
    public int getLayoutId(int ViewType) {
        return R.layout.item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        holder.setItemText(holder.getView(R.id.tv), list.get(position));
    }
}
