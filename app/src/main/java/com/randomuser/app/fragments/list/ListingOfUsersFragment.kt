package com.randomuser.app.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.randomuser.app.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListingOfUsersFragment : Fragment() {

    private val viewModel: ListingOfUsersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listing_of_users_fragment, container, false)
    }
}