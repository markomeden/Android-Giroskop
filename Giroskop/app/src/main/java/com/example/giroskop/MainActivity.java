package com.example.giroskop;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.view.Menu;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.ImageView;


public class MainActivity extends Activity implements SensorEventListener{

	public TextView text1;
	public SensorManager senzor;
	public TextView textView1;
	public ImageView imageview4;
	public float x,y,z;
	public int a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		senzor = (SensorManager) getSystemService(SENSOR_SERVICE);
		text1 = (TextView) findViewById(R.id.textView2);
		textView1 = (TextView) findViewById(R.id.textView1);
		imageview4 = (ImageView) findViewById(R.id.imageButton4);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		
		x = event.values[1];
		y = event.values[2];
		z = event.values[0];
		
		text1.setText("X: "+ x + " stopinj\n"+ "Y: "+ y + " stopinj\n"+ "Z: "+ z + " stopinj\n");
		
		imageview4.setRotation(-event.values[0]);
		
		a = (int)(event.values[0]);
		textView1.setText(a+"");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void onStart()
	{
		senzor.registerListener(this, senzor.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_FASTEST);
		super.onStart();
	}
	

	@Override
	protected void onStop()
	{
		senzor.unregisterListener(this);
		super.onStop();
	}

}
