package com.example.david_w_beck.scorecalculator;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mColorPoints = 0;
    private int mNearPoints = 0;
    private int mFarPoints = 0;
    private int mHomePoints = 0;
    private int mwbPoints = 0;

    private TextView mMessageColorPoints;
    private TextView mMessageNearPoints;
    private TextView mMessageFarPoints;
    private TextView mMessageHomePoints;
    private TextView mMessagewbPoints;
    private TextView mMessageTotalPoints;

    private TextInputLayout mInputNearPoints;
    private TextInputLayout mInputFarPoints;
    private TextInputLayout mInputHomePoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind variables to the objects
        mMessageColorPoints = findViewById(R.id.message_color_points);
        mMessagewbPoints = findViewById(R.id.message_wbpoints);
        mMessageTotalPoints = findViewById(R.id.message_total_points);
        mMessageNearPoints = findViewById(R.id.message_near_points);
        mMessageFarPoints = findViewById(R.id.message_far_points);
        mMessageHomePoints = findViewById(R.id.message_home_points);

        mInputNearPoints = findViewById(R.id.text_input_near);
        mInputFarPoints = findViewById(R.id.text_input_far);
        mInputHomePoints = findViewById(R.id.text_input_home);

    }

    public void handle3Fix(View v){
        mColorPoints = 0;
        updateAndRecalculate();
    }
    public void handle2Fix(View v){
        mColorPoints = 25;
        updateAndRecalculate();
    }
    public void handle1Fix(View v){
        mColorPoints = 75;
        updateAndRecalculate();
    }
    public void handle0Fix(View v){
        mColorPoints = 150;
        updateAndRecalculate();
    }
    public void handleUpdate(View v){
        double mInput;
        mInput = Double.parseDouble(mInputNearPoints.getEditText().getText().toString().trim());
        if(mInput > 45){mNearPoints = 0;}
        else if (mInput > 30){mNearPoints = 10;}
        else if (mInput > 20){mNearPoints = 50;}
        else if (mInput > 10){mNearPoints = 80;}
        else if (mInput > 5){mNearPoints = 100;}
        else {mNearPoints = 110;}
        mInput = Double.parseDouble(mInputFarPoints.getEditText().getText().toString());
        if(mInput > 45){mFarPoints = 0;}
        else if (mInput > 30){mFarPoints = 20;}
        else if (mInput > 20){mFarPoints = 100;}
        else if (mInput > 10){mFarPoints = 160;}
        else if (mInput > 5){mFarPoints = 200;}
        else {mFarPoints = 220;}
        mInput = Double.parseDouble(mInputHomePoints.getEditText().getText().toString());
        if(mInput > 45){mHomePoints = 0;}
        else if (mInput > 30){mHomePoints = 10;}
        else if (mInput > 20){mHomePoints = 50;}
        else if (mInput > 10){mHomePoints = 80;}
        else if (mInput > 5){mHomePoints = 100;}
        else {mHomePoints = 110;}
        updateAndRecalculate();
    }
    public void handlewbFailure(View v){
        mwbPoints = 0;
        updateAndRecalculate();
    }
    public void handlewbSuccess(View v){
        mwbPoints = 60;
        updateAndRecalculate();
    }
    public void handleReset(View v){
        mColorPoints = 0;
        mNearPoints = 0;
        mFarPoints = 0;
        mHomePoints = 0;
        mwbPoints = 0;
        updateAndRecalculate();
    }

    private void updateAndRecalculate() {
        int mTotalPoints;
        mTotalPoints = mColorPoints + mNearPoints + mFarPoints + mHomePoints + mwbPoints;
        mMessageColorPoints.setText(getString(R.string.message_color_points_format, mColorPoints));
        mMessageNearPoints.setText(getString(R.string.message_distance_points_format, mNearPoints));
        mMessageFarPoints.setText(getString(R.string.message_distance_points_format, mFarPoints));
        mMessageHomePoints.setText(getString(R.string.message_distance_points_format, mHomePoints));
        mMessagewbPoints.setText(getString(R.string.message_distance_points_format, mwbPoints));
        mMessageTotalPoints.setText(getString(R.string.message_wb_points_format, mTotalPoints));
    }

}
