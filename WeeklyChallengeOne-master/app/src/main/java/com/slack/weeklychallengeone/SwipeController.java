package com.slack.weeklychallengeone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;

import static android.support.v7.widget.helper.ItemTouchHelper.ACTION_STATE_SWIPE;
import static android.support.v7.widget.helper.ItemTouchHelper.RIGHT;

enum ButtonState {
    GONE,
    LEFT_VISIBLE
}

public class SwipeController extends ItemTouchHelper.Callback {
    private boolean swipeBack = false;
    private ButtonState buttonShowedState = ButtonState.GONE;
    private static final float BUTTON_WIDTH = 300;
    private RectF buttonInstance;
    private RecyclerView.ViewHolder currentItemViewHolder;
    private SwipeControllerAction mButtonAction;


    public SwipeController(SwipeControllerAction buttonAction){
        mButtonAction = buttonAction;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, RIGHT);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        if(swipeBack){
            swipeBack = false;
            return 0;
        }
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                            float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState == ACTION_STATE_SWIPE) {
            if (buttonShowedState != ButtonState.GONE) {
                if (buttonShowedState == ButtonState.LEFT_VISIBLE) dX = Math.max(dX, BUTTON_WIDTH);
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
            else {
                setTouchListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        }

        if (buttonShowedState == ButtonState.GONE) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
        currentItemViewHolder = viewHolder;
    }

    private void drawButtons(Canvas c, RecyclerView.ViewHolder viewHolder){
        float buttonWidthWithoutPadding = BUTTON_WIDTH - 20;
        float corners = 16;

        View itemView = viewHolder.itemView;
        Paint p = new Paint();

        RectF leftButton = new RectF(itemView.getLeft(), itemView.getTop(), itemView.getLeft()
                + buttonWidthWithoutPadding, itemView.getBottom());
        p.setColor(Color.parseColor("#9E9E9E"));
        c.drawRoundRect(leftButton, corners, corners, p);

        drawText("Explain", c, leftButton, p);

        buttonInstance = null;
        if(buttonShowedState == ButtonState.LEFT_VISIBLE) buttonInstance = leftButton;
    }

    private void drawText(String text, Canvas c, RectF button, Paint p){
        float textSize = 60;
        p.setColor(Color.WHITE);
        p.setAntiAlias(true);
        p.setTextSize(textSize);
        float yTextMargin = 16;

        float textWidth = p.measureText(text);
        c.drawText(text, button.centerX() - (textWidth/2), button.centerY() + yTextMargin, p);
    }

    private void setTouchListener(final Canvas c, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder,
                                  final float dX, final float dY, final int actionState, final boolean isCurrentlyActive){
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                swipeBack = motionEvent.getAction() == MotionEvent.ACTION_CANCEL ||
                        motionEvent.getAction() == MotionEvent.ACTION_UP;
                if(swipeBack){
                    if(dX > BUTTON_WIDTH) buttonShowedState = ButtonState.LEFT_VISIBLE;

                    if(buttonShowedState != ButtonState.GONE){
                        setTouchDownListener(c, recyclerView, viewHolder, dX, dY, actionState,
                                isCurrentlyActive);
                        setItemsClickable(recyclerView, false);
                    }
                }
                return false;
            }
        });
    }

    private void setTouchDownListener(final Canvas c, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder,
                                      final float dX, final float dY, final int actionState, final boolean isCurrentlyActive){
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                    setTouchUpListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                return false;
            }
        });
    }

    private void setTouchUpListener(final Canvas c, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder,
                                      final float dX, final float dY, final int actionState, final boolean isCurrentlyActive){
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    SwipeController.super.onChildDraw(c, recyclerView, viewHolder, 0F, dY,
                            actionState, isCurrentlyActive);
                    recyclerView.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return false;
                        }
                    });
                    setItemsClickable(recyclerView, true);
                    swipeBack = false;

                    if(mButtonAction != null && buttonInstance != null && buttonInstance.contains(
                            motionEvent.getX(), motionEvent.getY())){
                        if(buttonShowedState == ButtonState.LEFT_VISIBLE){
                            mButtonAction.onButtonClick(viewHolder.getAdapterPosition());
                        }
                    }

                    buttonShowedState = ButtonState.GONE;
                    currentItemViewHolder = null;
                }
                return false;
            }
        });
    }

    private void setItemsClickable(RecyclerView recyclerView, boolean isClickable){
        for(int i = 0; i < recyclerView.getChildCount(); i++)
            recyclerView.getChildAt(i).setClickable(isClickable);
    }

    public void onDraw(Canvas c){
        if(currentItemViewHolder != null){
            drawButtons(c, currentItemViewHolder);
        }
    }
}
