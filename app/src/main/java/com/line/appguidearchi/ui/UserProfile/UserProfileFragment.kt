package com.line.appguidearchi.ui.UserProfile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.line.appguidearchi.R
import org.koin.android.ext.android.inject

/**
 * 데이터를 표시하는 UI Controller
 */
class UserProfileFragment : Fragment() {
    private val viewModel : UserProfileViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("ID" , viewModel.userID)

        viewModel.userObject.observe(viewLifecycleOwner , Observer {
            // onChanged() lamda임 지금
            // update UI

        })
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}