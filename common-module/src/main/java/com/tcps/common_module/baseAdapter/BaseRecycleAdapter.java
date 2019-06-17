package com.tcps.common_module.baseAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RecycleView基础adapter
 * Created by my dell on 2016/12/23.
 */
@SuppressWarnings("ALL")
public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseRecycleAdapter.BaseViewHolder> {
    private List<T> list;
    private int viewsType;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    /**
     * @param list      list
     * @param viewsType itemsType quantity
     */
    public BaseRecycleAdapter(List<T> list, int viewsType) {
        this.list = list;
        if (viewsType > 0)
            this.viewsType = viewsType;
        else
            this.viewsType = 1;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType), parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecycleAdapter.BaseViewHolder holder, int position) {
        //noinspection unchecked
        bindData(holder, position);
        setOnItemClickListener(holder);
        setOnItemLongClickListener(holder);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * 根据索引值，返回不同的布局类型
     *
     * @param position 下标
     * @return 如果viewType是2返回position个类型   如果viewType是3返回两种类型
     */
    @Override
    public int getItemViewType(int position) {
        // 根据索引获取当前View的类型，以达到复用的目的
        // 根据位置的索引，获取当前position的类型
        return position % viewsType;
    }

    /**
     * 封装ViewHolder ,子类可以直接使用
     */
    public class BaseViewHolder extends RecyclerView.ViewHolder {
        private Map<Integer, View> mViewMap;

        @SuppressLint("UseSparseArrays")
        BaseViewHolder(View itemView) {
            super(itemView);
            mViewMap = new HashMap<>();
        }

        /**
         * 获取设置的view
         *
         * @param id 控件id
         * @return ViewHolder中的控件
         */
        public View getView(int id) {
            View view = mViewMap.get(id);
            if (view == null) {
                view = itemView.findViewById(id);
                mViewMap.put(id, view);
            }
            return view;
        }

        /**
         * 设置文本属性
         *
         * @param view 控件
         * @param text 文本
         */
        public void setItemText(View view, String text) {
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            }
        }

        /**
         * 设置图片
         *
         * @param view 控件
         * @param res  资源id
         */
        public void setItemImage(Context context, View view, int res) {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(ContextCompat.getDrawable(context, res));
            }
        }
    }

    /**
     * 获取子item
     *
     * @return item布局
     */
    public abstract int getLayoutId(int ViewType);

    /**
     * 绑定数据
     *
     * @param holder   具体的ViewHolder
     * @param position 对应的索引
     */
    protected abstract void bindData(BaseViewHolder holder, int position);

    private void setOnItemClickListener(final RecyclerView.ViewHolder holder) {
        if (mOnItemClickListener != null)
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, layoutPosition);
                }
            });
    }

    private void setOnItemLongClickListener(final RecyclerView.ViewHolder holder) {
        if (mOnItemLongClickListener != null)
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder.itemView, layoutPosition);
                    return true;
                }
            });
    }

    //点击事件接口
    public interface OnItemClickListener {
        void onItemClick(View v, int position);

    }

    //长按事件接口
    public interface OnItemLongClickListener {
        void onItemLongClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.mOnItemLongClickListener = listener;
    }

    //添加方法
    public void addData(List<T> list) {
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }

    //全部移除方法
    public void removeAll() {
        list.clear();
        this.notifyDataSetChanged();
    }
}
