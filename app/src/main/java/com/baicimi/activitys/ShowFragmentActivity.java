package com.baicimi.activitys;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.baicimi.R;
import com.baicimi.conf.Constant;
import com.baicimi.fragments.MipcaActivityCapture;
import com.baicimi.ui.SharedPreferencesUtil;


public class ShowFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_fragment);

		MipcaActivityCapture fragment = new MipcaActivityCapture();
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		fragmentTransaction.replace(R.id.container, fragment, "");
		fragmentTransaction.commit();

		MyBrodcast brodcast = new MyBrodcast();
		IntentFilter intentFilter = new IntentFilter(
				MipcaActivityCapture.SCAN_RESULT_ACTION);
		registerReceiver(brodcast, intentFilter);
	}

	public class MyBrodcast extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {

			if (intent.getAction().equals(MipcaActivityCapture.SCAN_RESULT_ACTION)) {

				Toast.makeText(getApplicationContext(),"扫描成功",Toast.LENGTH_SHORT).show();

				String scan_result=intent.getExtras().getString("result");
				SharedPreferencesUtil.putString(getApplicationContext(), Constant.SCAN_RESULT,scan_result);

				Intent intent1=new Intent(getApplicationContext(),ScanResultActivity.class);
				startActivity(intent1);

			}
		}
	}
}
