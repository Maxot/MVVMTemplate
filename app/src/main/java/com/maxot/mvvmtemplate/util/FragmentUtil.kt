package com.maxot.mvvmtemplate.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.maxot.mvvmtemplate.R

class FragmentUtil {
    companion object{
        @JvmOverloads
        fun replaceFragment(
            manager: FragmentManager, fragment: Fragment,
            addToBackStack: Boolean, useLeftRightAnimations: Boolean = false
        ) {
            val fTrans: FragmentTransaction
            fTrans = manager.beginTransaction()
            if (useLeftRightAnimations) {
                //      fTrans.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left);
            } else {
                fTrans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            }
            if (addToBackStack) {
                fTrans.addToBackStack(null)
            } else {
                //            manager.popBackStackImmediate();
            }
            fTrans.replace(R.id.container, fragment, fragment.javaClass.simpleName)
            fTrans.commitAllowingStateLoss()
        }
    }
}