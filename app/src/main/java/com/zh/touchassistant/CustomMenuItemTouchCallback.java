package com.zh.touchassistant;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * <b>Package:</b> com.zh.touchassistant <br>
 * <b>FileName:</b> CustomMenuItemTouchCallback <br>
 * <b>Create Date:</b> 2018/12/21  下午8:42 <br>
 * <b>Author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
public class CustomMenuItemTouchCallback extends ItemTouchHelper.Callback {
    private OnItemMoveCallback mOnItemMoveCallback;

    public CustomMenuItemTouchCallback(OnItemMoveCallback onItemMoveCallback) {
        this.mOnItemMoveCallback = onItemMoveCallback;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags;
        int swipeFlags = 0;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        //网格允许上下左右
        if (layoutManager instanceof GridLayoutManager) {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                    ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        } else {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        }
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        super.isLongPressDragEnabled();
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        super.isItemViewSwipeEnabled();
        //不支持Item滑动
        return false;
    }

    @Override
    public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder current, @NonNull RecyclerView.ViewHolder target) {
        if (mOnItemMoveCallback != null) {
            boolean isCanMove = mOnItemMoveCallback.isCanMove(current, target);
            //如果不能拖，直接拦截
            if (!isCanMove) {
                return false;
            }
        }
        return super.canDropOver(recyclerView, current, target);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        //Item交换回调，交换adapter的数据
        if (mOnItemMoveCallback != null) {
            mOnItemMoveCallback.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        }
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //不支持滑动，不做处理
    }

    public interface OnItemMoveCallback {
        /**
         * 是否可以移动，
         *
         * @param current 当前拽托的条目
         * @param target  想交换的位置的条目
         */
        boolean isCanMove(RecyclerView.ViewHolder current, @NonNull RecyclerView.ViewHolder target);

        /**
         * Item移动交换回调，这个回调要做Adapter数据交换
         *
         * @param fromPosition 从哪个位置
         * @param toPosition   到哪个位置
         */
        void onItemMove(int fromPosition, int toPosition);
    }
}
