package softwaredongjune.schoolproject160613;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 김동준 on 2016-06-15.
 */
public class DialogFragment extends android.support.v4.app.DialogFragment implements View.OnClickListener {

    private TextView settingText;
    private Button mTenbtn, pTenbtn, setbtn;
    private int setTime = 0;
    private SharedPreferences sp;

    public DialogFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialogfragment, container);

        sp = getActivity().getSharedPreferences("mdata", getContext().MODE_PRIVATE);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        findId(v);
        return v;
    }

    private void findId(View v) {
        settingText = (TextView) v.findViewById(R.id.timesetting);
        mTenbtn = (Button) v.findViewById(R.id.mten);
        pTenbtn = (Button) v.findViewById(R.id.pten);
        setbtn = (Button) v.findViewById(R.id.setting);
        mTenbtn.setOnClickListener(this);
        pTenbtn.setOnClickListener(this);
        setbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mten:
                setTime += 10;
                settingText.setText(setTime + "분");
                break;

            case R.id.pten:
                setTime -= 10;
                settingText.setText(setTime + "분");
                break;

            case R.id.setting:
                Log.d("setting", "click");
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("SettingTime", setTime);
                Log.d("Dialog setTime", setTime + "");
                editor.commit();
                dismiss();

                break;
        }
    }
}
