package com.twoam.agent.callback

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout

import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView
import com.reach.plus.admin.util.UserSessionManager
import com.twoam.agent.R
import com.twoam.agent.login.LoginActivity
import com.twoam.agent.utilities.AppConstants

/**
 * Created by sonu on 17:07, 10/01/19
 * Copyright (c) 2019 . All rights reserved.
 */
class BottomSheetNavigationFragment : BottomSheetDialogFragment() {

    //Bottom Sheet Callback
    private val mBottomSheetBehaviorCallback = object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss()
            }

        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            //check the slide offset and change the visibility of close button
            if (slideOffset > 0.5) {
                closeButton!!.visibility = View.VISIBLE
            } else {
                closeButton!!.visibility = View.GONE
            }
        }
    }

    private var closeButton: ImageView? = null

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        //Get the content View
        val contentView = View.inflate(context, R.layout.bottom_navigation_drawer, null)
        dialog.setContentView(contentView)

        val navigationView = contentView.findViewById<NavigationView>(R.id.navigation_view)

        //implement navigation menu item click event
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navLogout -> {
                    AlertDialog.Builder(context)
                        .setTitle(AppConstants.WARNING)
                        .setMessage(getString(com.twoam.agent.R.string.exit))
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(AppConstants.OK) { dialog, which ->
                            logOut()
                        }
                        .setNegativeButton(AppConstants.CANCEL) { dialog, which ->  }
                        .show()
                }
            }
            false
        }
        closeButton = contentView.findViewById(R.id.close_image_view)
        closeButton!!.setOnClickListener {
            //dismiss bottom sheet
            dismiss()
        }

        //Set the coordinator layout behavior
        val params = (contentView.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior

        //Set callback
        if (behavior is BottomSheetBehavior<*>) {
            behavior.setBottomSheetCallback(mBottomSheetBehaviorCallback)
        }
    }
    private fun logOut() {
        UserSessionManager.getInstance(context!!).setUserData(null)
        UserSessionManager.getInstance(context!!).setIsLogined(false)
        context?.startActivity(Intent(context, LoginActivity::class.java))

    }

    companion object {


        fun newInstance(): BottomSheetNavigationFragment {

            val args = Bundle()

            val fragment = BottomSheetNavigationFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
