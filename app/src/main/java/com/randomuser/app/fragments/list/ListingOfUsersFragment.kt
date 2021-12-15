package com.randomuser.app.fragments.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.randomuser.app.R
import com.randomuser.app.utils.showInfoAlertDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListingOfUsersFragment : Fragment() {

    private val viewModel: ListingOfUsersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.listing_of_users_fragment, container, false)

        initObservers()
        viewModel.getUsers()

        return view
    }

    private fun initObservers() {
        viewModel.getUsersList().observe(viewLifecycleOwner, {
            if(it != null) {
                
            }
        })

        viewModel.getShowNoInternet().observe(viewLifecycleOwner, {
            if (it) {
                viewModel.setShowNoInternet(false)
                showInfoAlertDialog(requireActivity(), getString(R.string.no_internet), getString(R.string.check_connection))
            }
        })
    }
}