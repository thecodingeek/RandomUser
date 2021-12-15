package com.randomuser.app.fragments.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.randomuser.app.R

class ListingOfUsersFragment : Fragment() {

    companion object {
        fun newInstance() = ListingOfUsersFragment()
    }

    private lateinit var viewModel: ListingOfUsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listing_of_users_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListingOfUsersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}