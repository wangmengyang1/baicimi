package com.baicimi.ui;

import android.view.View;

import com.youth.banner.transformer.ABaseTransformer;

/**
 * Created by Administrator on 2017/9/22.
 */

public class VertiaclTransformer extends ABaseTransformer {
    @Override
    protected void onTransform(View page, float position) {
        float alpha = 0;
        if (0 <= position && position <= 1) {
            alpha = 1 - position;
        } else if (-1 < position && position < 0) {
            alpha = position + 1;
        }
        page.setAlpha(alpha);
        page.setTranslationX(page.getWidth() * -position);
        float yPosition = position * page.getHeight();
        page.setTranslationY(yPosition);
    }



}
