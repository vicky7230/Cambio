package com.vicky7230.cambio.ui.currencies

import android.graphics.Rect
import android.view.View

class ItemOffsetDecoration(private val offset: Int) :
    androidx.recyclerview.widget.RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: androidx.recyclerview.widget.RecyclerView,
        state: androidx.recyclerview.widget.RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = offset
        } else
            outRect.top = offset / 2

        outRect.left = offset
        outRect.right = offset
        outRect.bottom = offset / 2
    }
}
