package com.cafrecode.writersplanx.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cafrecode.writersplanx.databinding.FragmentHomeBinding
import com.cafrecode.writersplanx.db.Message
import com.cafrecode.writersplanx.di.Injectable
import com.cafrecode.writersplanx.ui.notifications.NotificationsAdapter
import javax.inject.Inject

const val TAG = "HomeFragment"

class HomeFragment : Fragment(), Injectable {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

}