package com.example.isweixin;


import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class SetScroll extends ScrollView {
	private float dx;
	private float dy;
	private float l = 100;

	public SetScroll(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFadingEdgeLength(0);
	}
	
	
	




		@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
			System.out.println("--------正在滚动-------");
			
			float x = ev.getX();
			float y = ev.getY();
			
			switch(ev.getAction()){
			case MotionEvent.ACTION_DOWN:
				System.out.println("ACTION_DOWN");
				dx = x;
				dy = y;
				break;
			case MotionEvent.ACTION_MOVE:
				
				System.out.println("ACTION_MOVE=======");
				if(y-dy<100){
					return false;
				}
				break;
			}
		return false;
	}








		
//		@Override
//		public boolean onScroll(MotionEvent e1, MotionEvent e2,
//				float distanceX, float distanceY) {
//			// if(distanceY != 0    distanceX != 0){
//			//
//			// }
//			// if(Math.abs(distanceY)  = Math.abs(distanceX)){
//			// System.out.println( distanceX =   + distanceX +   , distanceY =  
//			// + distanceY);
//			// return true;
//			// }
//			// return false;
//			System.out.println("--------正在滚动-------");
//			double angle = Math.atan2(Math.abs(distanceY), Math.abs(distanceX));
////			System.out.println( angle--   + (180 * angle) / Math.PI);
//			if ((180 * angle) / Math.PI < 180) {
//				return false;
//			}
//
//			return false;
//		}
}
   

	

	
	

	

	

	

	

	

	

	

	
